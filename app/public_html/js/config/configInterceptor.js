angular.module('app').config(function ($httpProvider) {
    $httpProvider.interceptors.push('apiInterceptor');
    $httpProvider.interceptors.push('loadingInterceptor');
    
});