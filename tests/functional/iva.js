function $iva(){
	var preString = "El iva actualmente es del: ";
	var iva = '18.03'; 
	var complete = preString.concat(iva);
	
	return complete;
}

function $prodValueMessage(){
	var presentation = "Usted quiere calcular el ";
	return presentation.concat("precio del producto?");
}

function _underscore(){
	var ss = "|";
	return "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _".concat(ss);
}

function imprimirLargoIva(){
	console.log("iva".length);
}


//  Main
var mensaje = "Bienvenido a nuestro sitio web"; 
var nombreProducto = 'Producto ABC'; 

console.log(mensaje);
console.log(nombreProducto);
console.log($prodValueMessage());

console.log(_underscore());
console.log($iva());

console.log(_underscore());
var aumento = "Que pasa si aumenta el precio?";
console.log(aumento);

_nuevo_iva = 19.03;
console.log(_nuevo_iva);

console.log("Hablando de iva, cuantas letras tiene el string?");
imprimirLargoIva();

// Mayus y minus
var mensaje1 = "Hola"; 
var mensaje2 = mensaje1.concat(" Mundo, calculamos IVA?");
console.log("EN MAYUS");
console.log(mensaje1.toUpperCase());
console.log("en minus");
console.log(mensaje1.toLowerCase());

// Calculamos las posiciones en la palabra IVA
console.log(_underscore());
var _ivaString = "IVA"; 
var _primeraLetra = _ivaString.charAt(0);
console.log(_primeraLetra);

_ultimaLetra = _ivaString.charAt(2); 
console.log(_ultimaLetra);
console.log(_underscore());

var posicionDeA = _ivaString.indexOf('A'); 
posicionDeI = _ivaString.indexOf('I'); 
posicionDeIA = _ivaString.indexOf('IA'); 
console.log(posicionDeI);
console.log(posicionDeA);
console.log(posicionDeIA);
console.log(_underscore());

// Secuencia de control
if (true) {
	console.log("Si es true, esta bien, imprimo el iva");
	console.log($iva());
	if(3 == 4){
		console.log("Hay algo mal... no deberia imprimir esto.");
	} else {
		console.log("Bien! Imprimo dentro del else");
		if(6 == 6){
			console.log(6 == 6);
		} else {
			console.log("Hay algo mal... no deberia imprimir esto.");
		}
	}
}



console.log("Hola, esta es una prueba".substring(10));
console.log("Hola, esta es una prueba".substring(10, 15));

console.log("Hola, esta es una prueba".substring(0));
console.log("Hola, esta es una prueba".substring(1, 15));

console.log("Hola, esta es una prueba".substring(600));
console.log("Hola, esta es una prueba".substring(10, 5));
console.log("Hola, esta es una prueba".substring(5, 10));

console.log('hola'.substring(3));
console.log('hola'.substring(4));
console.log('hola'.substring(5));

console.log('hola'.substring(0, 3));
console.log('hola'.substring(0, 4));
console.log('hola'.substring(0, 5));

console.log('hola'.substring(3, 0));
console.log('hola'.substring(4, 0));
console.log('hola'.substring(5, 0));

for(i = 0;i<5;i++){
	break;
	console.log(5);
}

var some_array = [1,2,3,4];
console.log(some_array[1]);

