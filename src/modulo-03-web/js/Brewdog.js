function brewdog (a, b){

  var maior = Math.max(a.length, b.length);
  var cont = 0;

  for (i = 0; i < maior; i++){

    if (a[i] !== b[i]){
      cont ++;
    }
  }

  return cont;
}

 console.log(brewdog('bacon', 'beico')); 

  [
    { params: ['american ipa','american ipa'],                        esperado: 0 },
    { params: ['russian imperial stout','russian imperial vodka'],    esperado: 5 },
    { params: ['1002012','dfgdf12'],                                  esperado: 5 },
    { params: ['k4rol1n','k4thr1n'],                                  esperado: 3 },
    { params: ['a1df222266%334op;','ssdfjfdkjgsdfgofdgudf9g8dufsg'],  esperado: 26 },
  ].forEach(
    function(ct) {
      var res = brewdog(ct.params[0], ct.params[1]);
      console.assert(res === ct.esperado, 'Errooooou! CT:', ct.params, 'Esperado:', ct.esperado, 'Obtido:', res);
    }
  );