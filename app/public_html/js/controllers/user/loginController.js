angular.module('app').controller('loginController', function($scope, auth, $location, $rootScope){
	$scope.user = {};
	$scope.error = $location.search().error || false;
	
	var _user = auth.getLoggedUser();
	var _token = auth.getToken();
	if(_user && _token){
		$location.path('/usuario/' + _user.id + '/tasks');
	}
	
	$scope.login = function (user) {
		auth.login(user)
			.success(function (data) {
				auth.saveToken(data.token);
				auth.saveUserLogged(data.user);
				$rootScope.user = data.user;
				$location.path('/usuario/' + data.user.id + '/tasks');
			})
			.error(function (error) {
				console.log(error);
			});
	};
});