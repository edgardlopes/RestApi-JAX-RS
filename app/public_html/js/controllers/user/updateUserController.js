angular.module('app').controller('updateUserController', function ($scope, user, updateUser) {
    $scope.user = user.data;
    $scope.update = true;
    $scope.alertClass = 'alert-danger';

    $scope.saveUser = function (user) {
        updateUser(user)
                .success(function () {
                    $scope.showAlert = true;
                    $scope.alertClass = 'alert-success';
                    $scope.msg = {msg: 'Usuario salvo com sucesso.'};
                });
    };
});
