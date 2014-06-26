package com.language.parser;

import java.util.*;
import java_cup.runtime.*;
import com.language.exceptions.*;
import com.language.model.expression.*;

%%

%cup
%line
%unicode
%column

%class Scanner
%{
	private SymbolFactory sf;
	private StringBuffer string = new StringBuffer();

	public Scanner(java.io.InputStream r, SymbolFactory sf) {
		this(r);
		this.sf=sf;
	}

	private Symbol symbol(int type) {
		return new Symbol(type, yyline, yycolumn);
	}
	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline, yycolumn, value);
	}
%}

%eofval{
    return symbol(sym.EOF);
%eofval}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

Identifier = [A-Za-z\$\_][A-Za-z\$\_0-9]* 

IntegerLiteral = 0 | [1-9][0-9]*
FloatLiteral = (0 | [1-9][0-9]*)\.[0-9]+

%state COMMENT_LINE
%state COMMENT_BLOCK

%%

"." 			{return symbol(sym.POINT, "."); }
";"				{ return symbol(sym.SEMICOLON, ";"); }
","				{ return symbol(sym.COMMA, ","); }
"("				{ return symbol(sym.LEFT_ROUND_BRACKETS, "("); }
")"				{ return symbol(sym.RIGHT_ROUND_BRACKETS, ")"); }
"\""			{ return symbol(sym.DOUBLE_QUOTE, "\""); }
"'"				{ return symbol(sym.SINGLE_QUOTE, "'"); }
"["				{ return symbol(sym.LEFT_SQUARE_BRACKETS, "["); }
"]"				{ return symbol(sym.RIGHT_SQUARE_BRACKETS, "]"); }
"var"			{	System.out.println("*var* identificado" + " - " + yychar + " - " + yyline);
					return symbol(sym.VAR, "var"); 
				}
{WhiteSpace} 	{ /* ignore */ }

"\n" 	{ return symbol(sym.LINE_BREAK, "\n"); }
"\t" 	{ return symbol(sym.TABULATION, "\t"); }
"\\" 	{ return symbol(sym.ESCAPE, "\\"); }

"+" { return symbol(sym.ADDITION, "+"); }
"-" { return symbol(sym.SUBTRACTION, "-"); }
"*" { return symbol(sym.MULTIPLICATION, "*"); }
"/" { return symbol(sym.DIVISION, "/"); }
"=" { return symbol(sym.ASSIGNMENT, "="); }

"++" { return symbol(sym.INCREMENT, "++"); }
"--" { return symbol(sym.DECREMENT, "--"); }

"true"	{ 	System.out.println("*true* identificado" + " - " + yychar + " - " + yyline);
			return symbol(sym.TRUE, "true"); 
		}
"false"	{ 	System.out.println("*false* identificado" + " - " + yychar + " - " + yyline);
			return symbol(sym.FALSE, "false"); 
		}

"&&"	{	System.out.println("*&&* identificado" + " - " + yychar + " - " + yyline);
			return symbol(sym.AND, "&&"); 
		}
"||"	{ 	System.out.println("*||* identificado" + " - " + yychar + " - " + yyline);
			return symbol(sym.OR, "||"); 
		}
"!" 	{ return symbol(sym.NOT, "!"); }

">" 	{ 	System.out.println("*>* identificado" + " - " + yychar + " - " + yyline);
			return symbol(sym.GREATER, ">"); 
		}
"<" 	{ 	System.out.println("*<* identificado" + " - " + yychar + " - " + yyline);
			return symbol(sym.LESS, "<"); 
		}
">=" 	{ 	System.out.println("*>=* identificado" + " - " + yychar + " - " + yyline);
			return symbol(sym.GREATER_EQUAL, ">="); 
		}
"<=" 	{ 	System.out.println("*<=* identificado" + " - " + yychar + " - " + yyline);
			return symbol(sym.LESS_EQUAL, "<="); 
		}
"==" 	{ 	System.out.println("*==* identificado" + " - " + yychar + " - " + yyline);
			return symbol(sym.EQUAL, "=="); 
		}
"!=" 	{ 	System.out.println("*!=* identificado" + " - " + yychar + " - " + yyline);
			return symbol(sym.NOT_EQUAL, "!="); 
		}

<YYINITIAL> 	"//" 	{ yybegin(COMMENT_LINE); } 
<COMMENT_LINE> 	[^\n] 	{ }
<COMMENT_LINE> 	[\n] 	{ yybegin(YYINITIAL); }

<YYINITIAL> 	"/*" 		{ yybegin(COMMENT_BLOCK); } 
<COMMENT_BLOCK> [^(\*\/)] 	{ }
<COMMENT_BLOCK> \*\/ 		{ yybegin(YYINITIAL); }

"{" 		{ return symbol(sym.BLOCK_BEGIN, "{"); }
"}" 		{ return symbol(sym.BLOCK_BEGIN, "}"); }
"if" 		{ return symbol(sym.IF, "if"); }
"else" 		{ return symbol(sym.ELSE, "else"); }
"for" 		{ return symbol(sym.FOR, "for"); }
"break" 	{ return symbol(sym.BREAK, "break"); }
"continue" 	{ return symbol(sym.CONTINUE, "continue"); }

"length" 		{return symbol(sym.LENGTH, "length"); }
"concat" 		{return symbol(sym.CONCAT, "concat"); }
"toUpperCase" 	{return symbol(sym.TO_UPPER_CASE, "toUpperCase"); }
"toLowerCase" 	{return symbol(sym.TO_LOWER_CASE, "toLowerCase"); }
"charAt" 		{return symbol(sym.CHAR_AT, "charAt"); }
"indexOf" 		{return symbol(sym.INDEX_OF, "indexOf"); }
"lastIndexOf" 	{return symbol(sym.LAST_INDEX_OF, "lastIndexOf"); }
"substring" 	{return symbol(sym.SUBSTRING, "substring"); }
"split" 		{return symbol(sym.SPLIT, "split"); }

"join" 		{return symbol(sym.JOIN, "join"); }
"pop" 		{return symbol(sym.POP, "pop"); }
"push" 		{return symbol(sym.PUSH, "push"); }
"shift" 	{return symbol(sym.SHIFT, "shift"); }
"reverse" 	{return symbol(sym.REVERSE, "reverse"); }

"NaN" {return symbol(sym.NAN, "NaN"); }
"isNaN" {return symbol(sym.IS_NAN, "isNaN"); }
"parse" {return symbol(sym.PARSE, "parse"); }


\"([^\"\r\n\t]*)\"	{ return symbol(sym.STRING, yytext()); }

'([^\"\r\n\t]*)'	{ return symbol(sym.STRING, yytext()); }

{Identifier}		{ return symbol(sym.ID, yytext()); }
{IntegerLiteral}	{ return symbol(sym.INTEGRAL, yytext()); }
{FloatLiteral} 		{ return symbol(sym.DECIMAL, yytext()); }
