function maestroTabarez(){
	console.log("Al ejecutar esta funcion, veremos con claridad el pensamiento del Maestro");
}

function transcribirConferencia(){
	var inicio = "En primer lugar, hago uso del derecho que tiene cualquier persona a opinar: ";
	console.log(inicio);

	var parte2 = "obviamente como seleccionador de Uruguay";
	var parte3 = parte2.concat(', ');
	var parte4 = parte3.concat('como un entrenador que se considera producto del futbol uruguayo');
	console.log(parte4);

	// Veo indices
	console.log('Primera aparicion de l: ');
	console.log(inicio.indexOf('l'));
	console.log('Ultima aparicion de l: ');
	console.log(inicio.lastIndexOf('l'));

	var tabarezEsCrack = true && true;
	if(tabarezEsCrack){
		console.log('Todos sabemos dónde está el poder.');
	};

	/* 
		Esto transcribe partes de su conferencia:

		“A Luis Suárez persona, que es la que ha convivido siempre con nosotros y 
		a quien conocemos más que nadie: que el camino ya recorrido lo debe recorrer 
		nuevamente, intentando ser mejor, pero ya adelantarle que jamás va a estar 
		solo en ese intento. Y a los aficionados uruguayos, que obviamente igual que 
		nosotros están conmovidos con la resonancia de esta sanción, decirles que 
		estamos heridos, pero con una fuerza increíble y con muchísima rebeldía. 

		Entonces, más que nunca para el partido de mañana, ¡vamos que vamos!”.
	*/

	return 'Vamo que vamo!';

	console.log("Imprimo esto?");
	console.log("Detras de camaras!");
}

if(true){
	maestroTabarez();
	transcribirConferencia();
};

var mensaje1 = "Mensaje 1"; 
var mensaje2 = "Mensaje 2"; 
var mensaje3 = "Mensaje 3"; 
 
function muestraMensaje1() { 
 console.log(mensaje1); 
} 
 
function muestraMensaje2() { 
 console.log(mensaje2); 
} 
 
function muestraMensaje3() { 
 console.log(mensaje3); 
} 
 
// Comienza el programa principal 
muestraMensaje1(); 
muestraMensaje2(); 
muestraMensaje3();

//for comun
for(var i=0;i<4;i++){
	console.log(i);
}
var j = 1;

//for sin el primer elemento
for(;j<4;j++){
	console.log(j);
}

var h = 2;
//for sin el primer elemento y el tercero
for(;h<4;){
	h++;
	console.log(h);
}

console.log(["bien shifteado en arrays","asdasd",[1,2,3]].shift());

var a = [1,2,3,[4,5,[6,7,8]],[9,10]];
console.log(a.concat("funciono bien el concat"));
console.log(a);

b = [1,2,3,[4,5,[6,7,8]],[9,10]];
console.log(b.join("bien join"));

var array = [1, 2, 3];
var ultimo = array.pop(); 
if (ultimo == 3){
	console.log("funciono bien el pop");
}else{
	console.log("no funciona bien el pop");
}

var push_arr = [1,2,3];
push_arr.push(4);
console.log(push_arr);
console.log("funciona bien el push");

var array_shift = [1, 2, 3];
var shift_num = array_shift.shift(); 
if (shift_num == 1){
	console.log(array_shift);
	console.log("funciono bien el shift");
}else{
	console.log("no funciona bien el shift");
}


var array_reverse = [1,2,3];
array_reverse.reverse();
console.log("funciona bien el reverse");
console.log(array_reverse);

