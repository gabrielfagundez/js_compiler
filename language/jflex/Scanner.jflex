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

%%

";" 				{ return symbol(sym.SEMICOLON, ";"); }

"var" 				{ return symbol(sym.VAR, "var"); }

"+" 				{ return symbol(sym.PLUS, "+"); }
"-" 				{ return symbol(sym.MINUS, "-"); }
"*" 				{ return symbol(sym.TIMES, "*"); }
"/" 				{ return symbol(sym.DIV, "/"); }

"var" 				{ System.out.println("*var* identificado" + " - " + yychar + " - " + yyline);
                      return symbol(sym.VAR, "var"); 
                    }
                    
"true" 				{ System.out.println("*true* identificado" + " - " + yychar + " - " + yyline);
                      return symbol(sym.TRUE, "true"); 
                    }

"false" 			{ System.out.println("*false* identificado" + " - " + yychar + " - " + yyline);
                      return symbol(sym.FALSE, "false"); 
                    }
                    
"<=" 				{ System.out.println("*<=* identificado" + " - " + yychar + " - " + yyline);
                      return symbol(sym.LOWER_EQ, "<="); 
                    }

">=" 				{ System.out.println("*>=* identificado" + " - " + yychar + " - " + yyline);
                      return symbol(sym.GREATER_EQ, ">="); 
                    }

"||" 				{ System.out.println("*||* identificado" + " - " + yychar + " - " + yyline);
                      return symbol(sym.OR, "||"); 
                    }
                    
"&&" 				{ System.out.println("*&&* identificado" + " - " + yychar + " - " + yyline);
                      return symbol(sym.AND, "&&"); 
                    }

"==" 				{ System.out.println("*==* identificado" + " - " + yychar + " - " + yyline);
                      return symbol(sym.EQ_EQ, "=="); 
                    }

"!=" 				{ System.out.println("*!=* identificado" + " - " + yychar + " - " + yyline);
                      return symbol(sym.NOT_EQ, "!="); 
                    }
                    
">" 				{ System.out.println("*>* identificado" + " - " + yychar + " - " + yyline);
                      return symbol(sym.GREATER, ">"); 
                    }
"<" 				{ System.out.println("*<* identificado" + " - " + yychar + " - " + yyline);
                      return symbol(sym.LOWER, "<"); 
                    }

"(" 				{ return symbol(sym.LPAREN, "("); }
")" 				{ return symbol(sym.RPAREN, ")"); }


\"([^\"\r\n\t]*)\"	{ return symbol(sym.STRING, yytext()); }

'([^\"\r\n\t]*)'	{ return symbol(sym.STRING, yytext()); }

{Identifier}		{ return symbol(sym.ID, yytext()); }

{IntegerLiteral}	{ return symbol(sym.INTEGRAL, yytext()); }
					
{FloatLiteral} 		{ return symbol(sym.DECIMAL, yytext()); }

{WhiteSpace}        { /* ignore */ }

<YYINITIAL> "//" { yybegin(COMMENT_LINE); } 
<COMMENT_LINE> [^\n] { }
<COMMENT_LINE> [\n] { yybegin(YYINITIAL); }

<YYINITIAL> "/*" { yybegin(COMMENT_BLOCK); } 
<COMMENT_BLOCK> [^(\*\/)] { }
<COMMENT_BLOCK> \*\/ { yybegin(YYINITIAL); }
