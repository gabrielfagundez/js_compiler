function initialMsg(){
	console.log("La idea de este tests es verificar si la fifa es o no corrupta");
}

function newSection(){
	return "------------ * ------------";
}

initialMsg();

console.log('Verifiquemos segun un algoritmo, si la fifa es o no corrupta');
console.log(newSection());

var indice = 0.5;
var fifaCorrupta = indice + 50 * 20 / 20 + (2 + 3 + 4 - 8 * 46.6);
fifaCorrupta = fifaCorrupta * 10;
fifaCorrupta = fifaCorrupta / 2;
console.log(fifaCorrupta); 

if(fifaCorrupta < 252){
 	console.log("La fifa..".concat(" NO es corrupta"));
 	console.log("Esta bien, por ahora.");
} else {
 	console.log("La fifa..".concat(" es corrupta"));
 	console.log("Ooops, esto no deberia aparecer");
}

sumemosSuarez = "Sumemos a suarez";
console.log(sumemosSuarez);	
console.log(newSection());

// Vamos sumando seguidores de a poco
var seguidores = 0;
seguidores++;
seguidores++;
console.log(seguidores++);
console.log(seguidores++);

// A veces restamos
console.log(seguidores--);

seguidores++;
seguidores++;
seguidores++;
console.log(seguidores);

console.log(newSection());

// Los hacemos a la inversa?
var seguidores_p = 0;
++seguidores_p;
++seguidores_p;
console.log(++seguidores_p);
console.log(++seguidores_p);

// A veces restamos
console.log(--seguidores_p);

++seguidores_p;
++seguidores_p;
++seguidores_p;
console.log(seguidores_p);

// Finalicemos..
if(fifaCorrupta == fifaCorrupta){
 	console.log("La fifa..".concat(" SI es corrupta"));
 	console.log("Y si...".concat(" MIRA LO QUE LE PASO A SUAREZ"));
 	console.log("Esta bien, por ahora.");
} else {
 	console.log("La fifa..".concat(" NO es corrupta"));
 	console.log("Ooops, esto no deberia aparecer");
}

var fifaEsCorrupta = true;
seguidoresSuarez = 20000000 - 10;
console.log("Digamos que la fifa es corrupta hasta que Suarez llegue a 20000000 seguidores, y hasta el momento tiene");
console.log(seguidoresSuarez);
for(;fifaEsCorrupta==true&&seguidoresSuarez<20000000;seguidoresSuarez++){
	console.log("Fifa corrupta!");
	console.log("seguidores: ");
	console.log(seguidoresSuarez);
}


// Para llamar a fifa...
console.log("004-034556".split('-'));
console.log("099 244 875 222".split(' '));

var listaTelefonos = "122,128,222,345,667,999,000";
console.log(listaTelefonos.split(","));

var listaSuscriptos = "";
console.log(listaSuscriptos.split(";"));

console.log(parse("123123"));
console.log(parse("1"));
console.log(parse("12.0"));
console.log(parse("12.1"));

console.log(parseInt("123123"));
console.log(parseInt("1"));
console.log(parseInt("12.0"));
console.log(parseInt("12.1"));


var a = ["pepe","hole","lalas"];
{
	var b = a[0];
	console.log(b);
	console.log(a[2]);
}