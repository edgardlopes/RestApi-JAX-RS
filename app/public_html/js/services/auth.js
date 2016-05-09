angular.module('app').factory('auth', function ($http, $window, config) {
	var auth = {};

	auth.saveToken = function(token, localStorage) {
		if(localStorage) $window.localStorage['x-access-token'] = token;
		else $window.sessionStorage['x-access-token'] = token;	
	};

	auth.saveUserLogged = function(user, localStorage) {
		_user = JSON.stringify(user);
		if(localStorage) $window.localStorage['x-logged-user'] = _user;
		else $window.sessionStorage['x-logged-user'] = _user;
	};

	auth.getToken = function () {
		return $window.localStorage['x-access-token'] || $window.sessionStorage['x-access-token'];		
	};

	auth.getLoggedUser = function () {
		var _user = $window.localStorage['x-logged-user'] || $window.localStorage['x-logged-user'] || $window.sessionStorage['x-logged-user'];
		if(_user) return JSON.parse(_user);
		return _user;
	};

	auth.login = function (user) {
		return $http.post(config.baseUrl + '/users/login', user);
	};

	auth.logout = function () {
		$window.localStorage.removeItem('x-access-token');
		$window.localStorage.removeItem('x-logged-user');	
		$window.sessionStorage.removeItem('x-access-token');				
		$window.sessionStorage.removeItem('x-logged-user');
	};

	return auth;
});