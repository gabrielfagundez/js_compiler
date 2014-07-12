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