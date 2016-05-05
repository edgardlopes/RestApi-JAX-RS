angular.module('app').controller('loginController', function($scope, auth){
	$scope.user = {};

	$scope.login = function (user) {
		auth.login(user)
			.success(function (data) {
				console.log(data);
			})
			.error(function (error) {
				console.log('Um erro ocorreu: ' + error);
			});
	};
});