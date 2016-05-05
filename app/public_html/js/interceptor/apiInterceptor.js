angular.module('app').factory('apiInterceptor', function($location){
	return {
		responseError: function (error) {
			$location.path('/login');
			console.log(error);
			//return error;
		},
		response: function(response) {
			console.log(response);
			return response;
		}
	};
});

angular.module('app').config(function($httpProvider) {
	$httpProvider.interceptors.push('apiInterceptor');
});