angular.module('app').controller('createUserController', function ($scope, userService) {
    $scope.alertClass = 'alert-danger';

    $scope.saveUser = function (user) {

        userService.create(user)
                .success(function () {
                    $scope.showAlert = true;
                    $scope.msg = {msg: 'Usuario salvo com sucesso.'};
                    delete $scope.user;
                    $scope.alertClass = 'alert-success';
                });
    }
});