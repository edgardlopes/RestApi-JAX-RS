angular.module('app').factory('apiInterceptor', function ($q, $location, $window) {
    
    return {
        request: function (config) {
            if(config.url.indexOf('views') > -1) return config;
            if(config.url.indexOf('login') > -1) return config;
            config.headers['x-access-token'] = $window.localStorage['x-access-token'];
            return config;
        },
        responseError: function (rejection) {
            var status = rejection.status;
            if(status === 401) {
                $location.path('/login?error=true');
            }else if(status === 404) {
                $location.path('/404');
            }else if(status === 500) {
                $location.path('/error');
            }
            $q.reject(rejection);
        }
    };
});