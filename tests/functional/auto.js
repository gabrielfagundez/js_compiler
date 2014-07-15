// Funcion para mostrar como console.log
function mostrame1p(nombreMostrar){
	console.log(nombreMostrar);
}
mostrame1p('prueba');

// Funcion para imprimir la suma
function suma2(sum1, sum2){
	console.log(sum1 + sum2);
}
suma2(1, 2);

// Funcion para imprimir la suma de 3
function suma3(sum1, sum2, sum3){
	console.log(sum1 + sum2 + sum3);
}
suma3(1, 2, 3);

// Funcion que RETORNA el producto
function mult(a, b){
	return a * b;
}
console.log(mult(4, 6));

// Muchos concat juntos
console.log("Auto ".concat("rojo, ").concat("lindo, ").concat("y chico."));

// Chequeo el for
for(i = 0; i < 4; i++){
	console.log(i);
}

// Chequeo el for con dos statements
for(o = 0; o < 4; o++){
	console.log("> ");
	console.log("Auto ".concat("rojo, ").concat("lindo, ").concat("y chico."));
}

if(true)
	console.log("correcto if sin { }");

if(true)
	console.log("correcto el if en if-else sin { }");
else
	console.log("error en el else del if-else sin {}");

if(false)
	console.log("error en el if en if-else sin { }");
else
	console.log("correcto el else del if-else sin {}");

if(false){
	console.log("esto esta mal");
}else{
	console.log("esto esta bien!!!");
}

if(1+2){
	console.log("esto esta bien");
}else{
	console.log("esto esta mal!!!");
}

if(true){
	console.log("esto esta bien");
}else{
	console.log("esto esta mal!!!");
}

if(true){
	console.log("correcto if");
	if(true){
		console.log("correcto doble if");
		if(false){
			console.log("error en el triple if");
		}else{
			console.log("correcto triple if");
		}
	}else{
		console.log("error en el doble if");
		if(true){
			console.log("error else y luego if");
		}
	}

	console.log("muy bien");

}

if(((1+4)*5)+4){
	console.log("1");
	console.log("2");
	console.log("3");
	console.log("4");
	console.log("5");
	if (true){
		console.log("6");
	}
	if (false){
		console.log("NOT");
	}else{
		console.log("YESSS!!!!");
	}
}


if(true){
	console.log("esto deberia estar");
}

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
