angular.module('app').factory('auth', function ($http, $window, config) {
	var auth = {};

	auth.saveToken = function(token) {
		$window.localStorage['x-access-token'] = token;
	};

	auth.saveUserLogged = function(user) {
		$window.localStorage['x-logged-user'] = user;
	};

	auth.getToken = function () {
		return $window.localStorage['x-access-token'];		
	};

	auth.getLoggedUser = function () {
		return $window.localStorage['x-logged-user'];
	};

	auth.login = function (user) {
		return $http.post(config.baseUrl + '/users/login', user);
	};

	auth.logout = function () {
		$window.localStorage.removeItem('x-access-token');
		$window.localStorage.removeItem('x-logged-user');	
	};

	return auth;
});