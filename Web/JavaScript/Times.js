
-- 1 
var chelsea = {
  nome: 'Chelsea Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 5 },
    { desc: 'Continentais', qtd: 1 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var arsenal = {
  nome: 'Arsenal Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 13 },
    { desc: 'Continentais', qtd: 0 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var liverpool = {
  nome: 'Liverpool Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 18 },
    { desc: 'Continentais', qtd: 5 },
    { desc: 'Mundiais', qtd: 4 }
  ]
};

var manchester = {
  nome: 'Manchester United Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 20 },
    { desc: 'Continentais', qtd: 5 },
    { desc: 'Mundiais', qtd: 2 }
  ]
};

var array = [chelsea, arsenal, liverpool, manchester];


-- 2a

function ordenaPorNacionais(array){

	array.sort(function(a,b) { 
		return a.titulos[0].qtd < b.titulos[0].qtd;
		
	});
	
	return array;
}  

-- 2b  

function ordenaPorContinentais(array){

	array.sort(function(a,b) { 
		return a.titulos[1].qtd < b.titulos[1].qtd;
		
	});
	
	return array;
}    

-- 2c

function ordenaPorNacionais(array){

	array.sort(function(a,b) { 
		return a.titulos[2].qtd < b.titulos[2].qtd;
		
	});
	
	return array;
}   

-- 3  