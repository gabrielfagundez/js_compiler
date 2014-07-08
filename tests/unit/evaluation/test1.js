var a1 = true && true;       // t && t returns true
var a2 = true && false;      // t && f returns false
var a3 = false && true;      // f && t returns false
var a4 = false && (3 == 4);  // f && f returns false
var a5 = "Cat" && "Dog";     // t && t returns Dog
var a6 = false && "Cat";     // f && t returns false
var a7 = "Cat" && false;     // t && f returns false

var o1 = true || true;       // t || t returns true
var o2 = false || true;      // f || t returns true
var o3 = true || false ;     // t || f returns true
var o4 = false || (3 == 4);  // f || f returns false
var o5 = "Cat" || "Dog";     // t || t returns Cat
var o6 = false || "Cat";     // f || t returns Cat
var o7 = "Cat" || false;     // t || f returns Cat

var c1 = 1 + 2; // 3
var c6 =true + 1; // 2
var c5 =false + false; // 0
var c4 =5 + "foo" ;// "5foo"
var c3 ="foo" + false; // "foofalse"
var c2 ="foo" + "bar" ;// "foobar"

var problem = "hola\'n and hola\\n";