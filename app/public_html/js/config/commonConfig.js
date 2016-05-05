angular.module('app').config(function ($httpProvider) {
    $httpProvider.defaults.headers.post = {'Content-Type': 'application/json'};
    $httpProvider.defaults.headers.put = {'Content-Type': 'application/json'};
    $httpProvider.defaults.headers.commons = {'Origin': 'http://localhost:8383'};
    console.log('CONFIGURACOES FEITAS');
});

