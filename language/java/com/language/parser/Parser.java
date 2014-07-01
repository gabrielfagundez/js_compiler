
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Tue Jul 01 19:48:33 UYT 2014
//----------------------------------------------------

package com.language.parser;

import java.util.*;
import java_cup.runtime.*;
import com.language.model.*;
import com.language.exceptions.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Tue Jul 01 19:48:33 UYT 2014
  */
public class Parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\052\000\002\002\004\000\002\002\004\000\002\002" +
    "\003\000\002\003\006\000\002\024\003\000\002\022\003" +
    "\000\002\022\004\000\002\022\004\000\002\022\004\000" +
    "\002\022\003\000\002\022\003\000\002\022\003\000\002" +
    "\022\003\000\002\022\004\000\002\022\003\000\002\022" +
    "\003\000\002\022\003\000\002\022\004\000\002\022\004" +
    "\000\002\022\004\000\002\022\004\000\002\022\003\000" +
    "\002\026\003\000\002\025\003\000\002\010\003\000\002" +
    "\010\005\000\002\004\004\000\002\005\003\000\002\005" +
    "\005\000\002\006\003\000\002\006\005\000\002\006\005" +
    "\000\002\006\005\000\002\012\003\000\002\012\003\000" +
    "\002\012\003\000\002\012\005\000\002\012\005\000\002" +
    "\012\005\000\002\012\005\000\002\012\003\000\002\012" +
    "\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\101\000\006\016\030\064\007\001\002\000\010\002" +
    "\uffff\016\030\064\007\001\002\000\006\006\uffe9\007\uffe9" +
    "\001\002\000\010\002\ufff6\016\ufff6\064\ufff6\001\002\000" +
    "\004\010\100\001\002\000\010\002\ufff3\016\ufff3\064\ufff3" +
    "\001\002\000\004\002\077\001\002\000\004\006\034\001" +
    "\002\000\010\002\ufff8\016\ufff8\064\ufff8\001\002\000\010" +
    "\002\ufff2\016\ufff2\064\ufff2\001\002\000\004\006\034\001" +
    "\002\000\010\002\ufff7\016\ufff7\064\ufff7\001\002\000\004" +
    "\006\034\001\002\000\004\006\034\001\002\000\006\006" +
    "\uffea\007\071\001\002\000\004\006\034\001\002\000\004" +
    "\006\ufffd\001\002\000\010\002\uffec\016\uffec\064\uffec\001" +
    "\002\000\010\002\ufff5\016\ufff5\064\ufff5\001\002\000\010" +
    "\002\ufff1\016\ufff1\064\ufff1\001\002\000\004\006\034\001" +
    "\002\000\004\075\040\001\002\000\004\006\034\001\002" +
    "\000\004\006\034\001\002\000\010\002\ufffc\016\ufffc\064" +
    "\ufffc\001\002\000\010\002\uffeb\016\uffeb\064\uffeb\001\002" +
    "\000\010\002\ufff0\016\ufff0\064\ufff0\001\002\000\010\002" +
    "\ufffb\016\ufffb\064\ufffb\001\002\000\006\006\uffe7\007\065" +
    "\001\002\000\010\006\uffe4\007\uffe4\026\042\001\002\000" +
    "\006\006\uffe6\007\uffe6\001\002\000\020\010\050\031\046" +
    "\032\047\074\044\075\043\076\045\077\052\001\002\000" +
    "\020\006\uffd9\007\uffd9\011\uffd9\022\uffd9\023\uffd9\024\uffd9" +
    "\025\uffd9\001\002\000\020\006\uffde\007\uffde\011\uffde\022" +
    "\uffde\023\uffde\024\uffde\025\uffde\001\002\000\020\006\uffe0" +
    "\007\uffe0\011\uffe0\022\uffe0\023\uffe0\024\uffe0\025\uffe0\001" +
    "\002\000\006\006\uffe3\007\uffe3\001\002\000\006\006\uffe2" +
    "\007\uffe2\001\002\000\014\010\050\074\044\075\043\076" +
    "\045\077\052\001\002\000\016\006\uffe1\007\uffe1\022\053" +
    "\023\054\024\056\025\055\001\002\000\020\006\uffdf\007" +
    "\uffdf\011\uffdf\022\uffdf\023\uffdf\024\uffdf\025\uffdf\001\002" +
    "\000\014\010\050\074\044\075\043\076\045\077\052\001" +
    "\002\000\014\010\050\074\044\075\043\076\045\077\052" +
    "\001\002\000\014\010\050\074\044\075\043\076\045\077" +
    "\052\001\002\000\014\010\050\074\044\075\043\076\045" +
    "\077\052\001\002\000\020\006\uffdb\007\uffdb\011\uffdb\022" +
    "\uffdb\023\uffdb\024\uffdb\025\uffdb\001\002\000\020\006\uffda" +
    "\007\uffda\011\uffda\022\uffda\023\uffda\024\uffda\025\uffda\001" +
    "\002\000\020\006\uffdc\007\uffdc\011\uffdc\022\uffdc\023\uffdc" +
    "\024\056\025\055\001\002\000\020\006\uffdd\007\uffdd\011" +
    "\uffdd\022\uffdd\023\uffdd\024\056\025\055\001\002\000\014" +
    "\011\064\022\053\023\054\024\056\025\055\001\002\000" +
    "\020\006\uffd8\007\uffd8\011\uffd8\022\uffd8\023\uffd8\024\uffd8" +
    "\025\uffd8\001\002\000\004\075\040\001\002\000\006\006" +
    "\uffe5\007\uffe5\001\002\000\010\002\uffee\016\uffee\064\uffee" +
    "\001\002\000\010\002\uffef\016\uffef\064\uffef\001\002\000" +
    "\002\001\002\000\006\006\uffe8\007\uffe8\001\002\000\010" +
    "\002\ufffa\016\ufffa\064\ufffa\001\002\000\010\002\uffed\016" +
    "\uffed\064\uffed\001\002\000\010\002\ufff4\016\ufff4\064\ufff4" +
    "\001\002\000\010\002\ufff9\016\ufff9\064\ufff9\001\002\000" +
    "\004\002\000\001\002\000\004\075\101\001\002\000\004" +
    "\011\102\001\002\000\004\006\ufffe\001\002\000\004\002" +
    "\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\101\000\056\002\010\003\022\004\011\010\020\015" +
    "\004\022\003\023\032\024\030\025\017\027\012\030\015" +
    "\031\005\032\024\033\014\034\007\035\013\036\025\037" +
    "\031\040\021\041\026\042\016\043\023\001\001\000\056" +
    "\002\102\003\022\004\011\010\020\015\004\022\003\023" +
    "\032\024\030\025\017\027\012\030\015\031\005\032\024" +
    "\033\014\034\007\035\013\036\025\037\031\040\021\041" +
    "\026\042\016\043\023\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\026\075\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\026\074\001\001\000\002\001\001\000" +
    "\004\026\073\001\001\000\004\026\072\001\001\000\002" +
    "\001\001\000\004\026\067\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\026\066\001\001\000\006\005\036\006\040\001\001\000" +
    "\004\026\035\001\001\000\004\026\034\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\012\050\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\012\062\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\012\061\001\001\000\004\012\060\001\001" +
    "\000\004\012\057\001\001\000\004\012\056\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\006" +
    "\065\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\015\071\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // simple_expression ::= LEFT_ROUND_BRACKET simple_expression RIGHT_ROUND_BRACKET 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		
            RESULT = e;
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simple_expression",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // simple_expression ::= ID 
            {
              Expression RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            RESULT = new Expression(i);
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simple_expression",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // simple_expression ::= simple_expression DIV simple_expression 
            {
              Expression RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Expression l = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Expression r = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            RESULT = new Expression("/", l, r);
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simple_expression",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // simple_expression ::= simple_expression TIMES simple_expression 
            {
              Expression RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Expression l = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Expression r = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            RESULT = new Expression("*", l, r);
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simple_expression",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // simple_expression ::= simple_expression MINUS simple_expression 
            {
              Expression RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Expression l = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Expression r = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            RESULT = new Expression("-", l, r);
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simple_expression",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // simple_expression ::= simple_expression PLUS simple_expression 
            {
              Expression RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Expression l = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Expression r = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            RESULT = new Expression("+", l, r);
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simple_expression",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // simple_expression ::= STRING 
            {
              Expression RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            RESULT = new Expression(s);
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simple_expression",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // simple_expression ::= DECIMAL 
            {
              Expression RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String d = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            RESULT = new Expression(d);
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simple_expression",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // simple_expression ::= INTEGRAL 
            {
              Expression RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
            RESULT = new Expression(i);
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("simple_expression",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // variable_declaration ::= ID EQUAL simple_expression 
            {
              Object RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Expression s = (Expression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		  
            Variables variables = Variables.getInstance();
            String type = s.evaluateType();
            Object value = s.evaluate();
            Var var = new Var(value, id, type);
            variables.addVariable(var); 
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("variable_declaration",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // variable_declaration ::= ID EQUAL FALSE 
            {
              Object RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String f = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		  
            Variables variables = Variables.getInstance();
            Var var = new Var(f, id, "boolean");
            variables.addVariable(var); 
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("variable_declaration",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // variable_declaration ::= ID EQUAL TRUE 
            {
              Object RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		  
            Variables variables = Variables.getInstance();
            Var var = new Var(t, id, "boolean");
            variables.addVariable(var); 
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("variable_declaration",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // variable_declaration ::= ID 
            {
              Object RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		  
            Variables variables = Variables.getInstance();
            Var var = new Var(null, id, null);
            variables.addVariable(var); 
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("variable_declaration",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // variable_declaration_list ::= variable_declaration_list COMMA variable_declaration 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("variable_declaration_list",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // variable_declaration_list ::= variable_declaration 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("variable_declaration_list",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // variable_definition ::= VAR variable_declaration_list 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("variable_definition",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // expression ::= expression COMMA assignment_expression 
            {
              Object RESULT =null;
		 System.out.println("Detecte un expression COMMA assignment_expression"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expression",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // expression ::= assignment_expression 
            {
              Object RESULT =null;
		 System.out.println("Detecte un assignment_expression"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expression",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // expression_statement ::= expression 
            {
              Object RESULT =null;
		 System.out.println("Detecte un expression"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expression_statement",19, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // optional_semicolon ::= SEMICOLON 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("optional_semicolon",20, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // statement ::= try_statement 
            {
              Object RESULT =null;
		 System.out.println("Detecte un try_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // statement ::= throw_statement optional_semicolon 
            {
              Object RESULT =null;
		 System.out.println("Detecte un throw_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // statement ::= return_statement optional_semicolon 
            {
              Object RESULT =null;
		 System.out.println("Detecte un return_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // statement ::= break_statement optional_semicolon 
            {
              Object RESULT =null;
		 System.out.println("Detecte un break_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // statement ::= continue_statement optional_semicolon 
            {
              Object RESULT =null;
		 System.out.println("Detecte un continue_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // statement ::= with_statement 
            {
              Object RESULT =null;
		 System.out.println("Detecte un with_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // statement ::= for_statement 
            {
              Object RESULT =null;
		 System.out.println("Detecte un for_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // statement ::= while_statement 
            {
              Object RESULT =null;
		 System.out.println("Detecte un while_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // statement ::= do_statement optional_semicolon 
            {
              Object RESULT =null;
		 System.out.println("Detecte un do_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // statement ::= switch_statemente 
            {
              Object RESULT =null;
		 System.out.println("Detecte un switch_statemente"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // statement ::= if_statement 
            {
              Object RESULT =null;
		 System.out.println("Detecte un if_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // statement ::= labeled_statement 
            {
              Object RESULT =null;
		 System.out.println("Detecte un labeled_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // statement ::= block 
            {
              Object RESULT =null;
		 System.out.println("Detecte un block"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // statement ::= variable_definition optional_semicolon 
            {
              Object RESULT =null;
		 /* System.out.println("Detecte un variable_definition"); */ 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // statement ::= expression_statement optional_semicolon 
            {
              Object RESULT =null;
		 System.out.println("Detecte un expression_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // statement ::= known_function optional_semicolon 
            {
              Object RESULT =null;
		 /* System.out.println("Detecte un known_function"); */ 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // statement ::= empty_statement 
            {
              Object RESULT =null;
		 System.out.println("Detecte un empty_statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // known_function ::= console_log 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("known_function",18, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // console_log ::= CONSOLE_LOG LEFT_ROUND_BRACKET ID RIGHT_ROUND_BRACKET 
            {
              Object RESULT =null;
		int var_nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int var_nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String var_name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 
            Variables variables = Variables.getInstance();
            Var var = variables.getVariableByName(var_name);
            ConsoleLog cl = new ConsoleLog((String)var.getValue());
            cl.execute();
            
        
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("console_log",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // main ::= statement 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("main",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= main EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // main ::= statement main 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("main",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

