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
    public void errorMsg(String msg, java_cup.runtime.Symbol info) {
        String syntaxMessage = "Error de sintaxis detectado cerca de la linea ";
        syntaxMessage = syntaxMessage + yyline;
        if(info.value != null){
            syntaxMessage = syntaxMessage + " antes del token \"" + info.value + "\""; 
        }

        num_errors++;
        throw new SyntaxError(syntaxMessage);
    }
    private int num_errors = 0;
    public int numErrors() { return num_errors; }
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
%state COMMENT_BLOCK_1
%state COMMENT_BLOCK_2

%%

<YYINITIAL> "null"              { return symbol(sym.NULL, "null"); }
<YYINITIAL> "return"            { return symbol(sym.RETURN, "return"); }
<YYINITIAL> "function"          { return symbol(sym.FUNCTION, "function"); }
<YYINITIAL> "console.log"       { return symbol(sym.CONSOLE_LOG, "console.log"); }
<YYINITIAL> "alert"             { return symbol(sym.ALERT, "alert"); }

<YYINITIAL> "." 				{ return symbol(sym.POINT, "."); }
<YYINITIAL> ";"					{ return symbol(sym.SEMICOLON, ";"); }
<YYINITIAL> ","					{ return symbol(sym.COMMA, ","); }
<YYINITIAL> "("					{ return symbol(sym.LEFT_ROUND_BRACKET, "("); }
<YYINITIAL> ")"					{ return symbol(sym.RIGHT_ROUND_BRACKET, ")"); }
<YYINITIAL> "\""				{ return symbol(sym.DOUBLE_QUOTE, "\""); }
<YYINITIAL> "'"					{ return symbol(sym.SINGLE_QUOTE, "'"); }
<YYINITIAL> "["					{ return symbol(sym.LEFT_SQUARE_BRACKET, "["); }
<YYINITIAL> "]"					{ return symbol(sym.RIGHT_SQUARE_BRACKET, "]"); }
<YYINITIAL> "var"				{ return symbol(sym.VAR, "var"); }

<YYINITIAL> "\n" 				{ /* Ignore */ }
<YYINITIAL> "\t" 				{ /* Ignore */ }
<YYINITIAL> "\\" 				{ return symbol(sym.ESCAPE, "\\"); }

<YYINITIAL> "+" 				{ return symbol(sym.PLUS, "+"); }
<YYINITIAL> "-" 				{ return symbol(sym.MINUS, "-"); }
<YYINITIAL> "*" 				{ return symbol(sym.TIMES, "*"); }
<YYINITIAL> "/" 				{ return symbol(sym.DIV, "/"); }
<YYINITIAL> "=" 				{ return symbol(sym.EQUAL, "="); }
<YYINITIAL> "?"                 { return symbol(sym.QUEST, "?"); }
<YYINITIAL> ":"                 { return symbol(sym.COLON, ":"); }
<YYINITIAL> "new"                 { return symbol(sym.NEW, "new"); }

<YYINITIAL> "++" 				{ return symbol(sym.INCREMENT, "++"); }
<YYINITIAL> "--" 				{ return symbol(sym.DECREMENT, "--"); }

<YYINITIAL> "true"				{ return symbol(sym.TRUE, "true"); }
<YYINITIAL> "false"				{ return symbol(sym.FALSE, "false"); }

<YYINITIAL> "&&"				{ return symbol(sym.AND, "&&"); }
<YYINITIAL> "||"				{ return symbol(sym.OR, "||"); }
<YYINITIAL> "!" 				{ return symbol(sym.NOT, "!"); }

<YYINITIAL> ">" 				{ return symbol(sym.GREATER, ">"); }
<YYINITIAL> "<"	 				{ return symbol(sym.LESS, "<"); }
<YYINITIAL> ">=" 				{ return symbol(sym.GREATER_EQUAL, ">="); }
<YYINITIAL> "<=" 				{ return symbol(sym.LESS_EQUAL, "<="); }
<YYINITIAL> "==" 				{ return symbol(sym.EQUAL_EQUAL, "=="); }
<YYINITIAL> "!=" 				{ return symbol(sym.NOT_EQUAL, "!="); }

<YYINITIAL> 	"//" 		{ yybegin(COMMENT_LINE); }
<COMMENT_LINE> 	[^\n] 		{ }
<COMMENT_LINE> 	[\n] 		{ yybegin(YYINITIAL); }

<YYINITIAL>         "/*"    { yybegin(COMMENT_BLOCK_1); }
<COMMENT_BLOCK_1>   [^\*]   { }
<COMMENT_BLOCK_1>   "\*"    { yybegin(COMMENT_BLOCK_2); }
<COMMENT_BLOCK_2>   [^\/]   { yybegin(COMMENT_BLOCK_1); }
<COMMENT_BLOCK_2>   "\/"    { yybegin(YYINITIAL); }

<YYINITIAL> "{" 				{ return symbol(sym.BLOCK_BEGIN, "{"); }
<YYINITIAL> "}" 				{ return symbol(sym.BLOCK_END, "}"); }
<YYINITIAL> "if" 				{ return symbol(sym.IF, "if"); }
<YYINITIAL> "while"             { return symbol(sym.WHILE, "while"); }
<YYINITIAL> "else" 				{ return symbol(sym.ELSE, "else"); }
<YYINITIAL> "for" 				{ return symbol(sym.FOR, "for"); }
<YYINITIAL> "break" 			{ return symbol(sym.BREAK, "break"); }
<YYINITIAL> "continue" 			{ return symbol(sym.CONTINUE, "continue"); }

<YYINITIAL> "length" 			{return symbol(sym.LENGTH_FUNCT, "length"); }
<YYINITIAL> "typeof"            {return symbol(sym.TYPEOF_FUNCT, "typeof"); }
<YYINITIAL> "concat" 			{return symbol(sym.CONCAT_FUNCT, "concat"); }
<YYINITIAL> "toUpperCase" 		{return symbol(sym.TO_UPPER_CASE_FUNCT, "toUpperCase"); }
<YYINITIAL> "toLowerCase" 		{return symbol(sym.TO_LOWER_CASE_FUNCT, "toLowerCase"); }
<YYINITIAL> "charAt" 			{return symbol(sym.CHAR_AT_FUNCT, "charAt"); }
<YYINITIAL> "indexOf" 			{return symbol(sym.INDEX_OF_FUNCT, "indexOf"); }
<YYINITIAL> "lastIndexOf" 		{return symbol(sym.LAST_INDEX_OF_FUNCT, "lastIndexOf"); }
<YYINITIAL> "substring" 		{return symbol(sym.SUBSTRING_FUNCT, "substring"); }
<YYINITIAL> "split" 			{return symbol(sym.SPLIT_FUNCT, "split"); }

<YYINITIAL> "join" 				{return symbol(sym.JOIN_FUNCT, "join"); }
<YYINITIAL> "pop" 				{return symbol(sym.POP_FUNCT, "pop"); }
<YYINITIAL> "push" 				{return symbol(sym.PUSH_FUNCT, "push"); }
<YYINITIAL> "shift" 			{return symbol(sym.SHIFT_FUNCT, "shift"); }
<YYINITIAL> "reverse"	 		{return symbol(sym.REVERSE_FUNCT, "reverse"); }

<YYINITIAL> "NaN" 				{return symbol(sym.NAN, "NaN"); }
<YYINITIAL> "isNaN" 			{return symbol(sym.IS_NAN, "isNaN"); }
<YYINITIAL> "parse" 			{return symbol(sym.PARSE_FUNCT, "parse"); }

<YYINITIAL> \"([^\"\r\n\t]*)\"	{ return symbol(sym.STRING, yytext()); }
<YYINITIAL> '([^\"\r\n\t]*)'	{ return symbol(sym.STRING, yytext()); }

<YYINITIAL> {Identifier}		{ return symbol(sym.ID, yytext()); }
<YYINITIAL> {IntegerLiteral}	{ return symbol(sym.INTEGRAL, yytext()); }
<YYINITIAL> {FloatLiteral} 		{ return symbol(sym.DECIMAL, yytext()); }

<YYINITIAL> {WhiteSpace}        { /* Ignore */ }
