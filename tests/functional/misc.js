var a = 3 + 5;
console.log(a);

var string = "Llamando a la funcion..";
string = string.concat('+ esto');
pos = string.indexOf('+');
console.log(string);
console.log(pos);


function sum(a, b){
	var principio = "este es el principio";
	final = " y este es el final";
	return principio + final;
	console.log('no deberia salir');
}

console.log(sum(1,2));

// if (true) {
// 	var llamando = "Llamando a la funcion..";
// 	console.log(llamando);
// }

// function funcion(){
// 	if(2 == 2){
// 		var llamando = "Llamando a la funcion..".concat(" dentro de la funcion.");
// 		console.log(llamando);
// 	} else {
// 		var otraVar = "No deberia".concat(" estar llamando..");
// 		console.log(otraVar);
// 	}
// }

// funcion();


// Desde la letra del obligatorio

// a continuación se muestra un mensaje 
alert("mensaje de prueba"); 

/* Los comentarios de varias líneas son muy útiles 
cuando se necesita incluir bastante información 
en los comentarios */ 
alert("mensaje de prueba"); 

var numero_1 = 3; 
var numero_2 = 1; 
var resultado = numero_1 + numero_2; 
 
console.log(resultado);

function $iva(){
	var preString = "El iva actualmente es del: "
	var iva = 18.03; // variable tipo entero 
	return preString.concat(iva);
}

console.log($iva());

