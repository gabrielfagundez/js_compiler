// Operaciones booleanas

console.log(true && true);       // t && t returns true
console.log(true && false);      // t && f returns false
console.log(false && true);      // f && t returns false
console.log(false && (3 == 4));  // f && f returns false
console.log("Cat" && "Dog");     // t && t returns Dog
console.log(false && "Cat");     // f && t returns false
console.log("Cat" && false);     // t && f returns false

console.log(true || true);       // t || t returns true
console.log(false || true);      // f || t returns true
console.log(true || false);     // t || f returns true
console.log(false || (3 == 4));  // f || f returns false
console.log("Cat" || "Dog");     // t || t returns Cat
console.log(false || "Cat");     // f || t returns Cat
console.log("Cat" || false);     // t || f returns Cat
