
// 1
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
// 2 
    function ordenarPor (array, indice){
        array.sort(function(a, b) { 
            return a.titulos[indice].qtd < b.titulos[indice].qtd;
    
    }
    );
        somssss
    }

    function ordenarPorNacionais (array){
      return ordenarPor(array, 0);
    }

    function ordenarPorContinentais (array){
      return ordenarPor(array, 1);
    }

    function ordenarPorMundiais (array){
      return ordenarPor(array, 2);
    }
//3
    function somatorio (array, indice) {
      var soma = 0;
       array.map(function(a) { 
         soma = soma + a.titulos[indice].qtd;
    });
       return soma;
    }
    
    function somarPorNacionais(array){
     return somatorio (array, 0);
    }

    function somarPorContinentais (array){
     return somatorio (array, 1);
    }

    function somarPorMundiais (array){
     return somatorio (array, 2);
    }

// 4

    function apenasOsMelhores (array) {
     return array.filter(function(a) {
      return a.titulos[0].qtd > 18;
    });
    }

// 5 

    function apenasOsMelhoresParaJSON (array) {
      return JSON.stringify(apenasOsMelhores(array));
    }

     function apenasOsMelhoresRecebendoJSON(string){
      return JSON.parse(apenasOsMelhoresParaJSON (string));
    }