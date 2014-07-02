package com.language.parser;

import java.util.*;
import java_cup.runtime.*;
import com.language.exceptions.*;
import com.language.model.*;

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

"null"              { return symbol(sym.NULL, "null"); }
"console.log"       {return symbol(sym.CONSOLE_LOG, "console.log"); }

"." 				{ return symbol(sym.POINT, "."); }
";"					{ return symbol(sym.SEMICOLON, ";"); }
","					{ return symbol(sym.COMMA, ","); }
"("					{ return symbol(sym.LEFT_ROUND_BRACKET, "("); }
")"					{ return symbol(sym.RIGHT_ROUND_BRACKET, ")"); }
"\""				{ return symbol(sym.DOUBLE_QUOTE, "\""); }
"'"					{ return symbol(sym.SINGLE_QUOTE, "'"); }
"["					{ return symbol(sym.LEFT_SQUARE_BRACKET, "["); }
"]"					{ return symbol(sym.RIGHT_SQUARE_BRACKET, "]"); }
"var"				{ return symbol(sym.VAR, "var"); }

"\n" 				{ return symbol(sym.LINE_BREAK, "\n"); }
"\t" 				{ return symbol(sym.TABULATION, "\t"); }
"\\" 				{ return symbol(sym.ESCAPE, "\\"); }

"+" 				{ return symbol(sym.PLUS, "+"); }
"-" 				{ return symbol(sym.MINUS, "-"); }
"*" 				{ return symbol(sym.TIMES, "*"); }
"/" 				{ return symbol(sym.DIV, "/"); }
"=" 				{ return symbol(sym.EQUAL, "="); }
"?"                 { return symbol(sym.QUEST, "?"); }
":"                 { return symbol(sym.COLON, ":"); }
"new"                 { return symbol(sym.NEW, "new"); }

"++" 				{ return symbol(sym.INCREMENT, "++"); }
"--" 				{ return symbol(sym.DECREMENT, "--"); }

"true"				{ return symbol(sym.TRUE, "true"); }
"false"				{ return symbol(sym.FALSE, "false"); }

"&&"				{ return symbol(sym.AND, "&&"); }
"||"				{ return symbol(sym.OR, "||"); }
"!" 				{ return symbol(sym.NOT, "!"); }

">" 				{ return symbol(sym.GREATER, ">"); }
"<"	 				{ return symbol(sym.LESS, "<"); }
">=" 				{ return symbol(sym.GREATER_EQUAL, ">="); }
"<=" 				{ return symbol(sym.LESS_EQUAL, "<="); }
"==" 				{ return symbol(sym.EQUAL_EQUAL, "=="); }
"!=" 				{ return symbol(sym.NOT_EQUAL, "!="); }

<YYINITIAL> 	"//" 		{ yybegin(COMMENT_LINE); } 
<COMMENT_LINE> 	[^\n] 		{ }
<COMMENT_LINE> 	[\n] 		{ yybegin(YYINITIAL); }

<YYINITIAL> 	"/*" 		{ yybegin(COMMENT_BLOCK); } 
<COMMENT_BLOCK> [^(\*\/)] 	{ }
<COMMENT_BLOCK> \*\/ 		{ yybegin(YYINITIAL); }

"{" 				{ return symbol(sym.BLOCK_BEGIN, "{"); }
"}" 				{ return symbol(sym.BLOCK_END, "}"); }
"if" 				{ return symbol(sym.IF, "if"); }
"else" 				{ return symbol(sym.ELSE, "else"); }
"for" 				{ return symbol(sym.FOR, "for"); }
"break" 			{ return symbol(sym.BREAK, "break"); }
"continue" 			{ return symbol(sym.CONTINUE, "continue"); }

"length" 			{return symbol(sym.LENGTH_FUNCT, "length"); }
"typeof"            {return symbol(sym.TYPEOF_FUNCT, "typeof"); }
"concat" 			{return symbol(sym.CONCAT_FUNCT, "concat"); }
"toUpperCase" 		{return symbol(sym.TO_UPPER_CASE_FUNCT, "toUpperCase"); }
"toLowerCase" 		{return symbol(sym.TO_LOWER_CASE_FUNCT, "toLowerCase"); }
"charAt" 			{return symbol(sym.CHAR_AT_FUNCT, "charAt"); }
"indexOf" 			{return symbol(sym.INDEX_OF_FUNCT, "indexOf"); }
"lastIndexOf" 		{return symbol(sym.LAST_INDEX_OF_FUNCT, "lastIndexOf"); }
"substring" 		{return symbol(sym.SUBSTRING_FUNCT, "substring"); }
"split" 			{return symbol(sym.SPLIT_FUNCT, "split"); }

"join" 				{return symbol(sym.JOIN_FUNCT, "join"); }
"pop" 				{return symbol(sym.POP_FUNCT, "pop"); }
"push" 				{return symbol(sym.PUSH_FUNCT, "push"); }
"shift" 			{return symbol(sym.SHIFT_FUNCT, "shift"); }
"reverse"	 		{return symbol(sym.REVERSE_FUNCT, "reverse"); }

"NaN" 				{return symbol(sym.NAN, "NaN"); }
"isNaN" 			{return symbol(sym.IS_NAN, "isNaN"); }
"parse" 			{return symbol(sym.PARSE_FUNCT, "parse"); }

\"([^\"\r\n\t]*)\"	{ return symbol(sym.STRING, yytext()); }
'([^\"\r\n\t]*)'	{ return symbol(sym.STRING, yytext()); }

{Identifier}		{ return symbol(sym.ID, yytext()); }
{IntegerLiteral}	{ return symbol(sym.INTEGRAL, yytext()); }
{FloatLiteral} 		{ return symbol(sym.DECIMAL, yytext()); }

{WhiteSpace}        { /* ignore */ }
