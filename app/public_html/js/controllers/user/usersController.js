angular.module('app').controller('usersController', function ($scope, users, deleteUser) {
    $scope.users = users.data;
    $scope.alertClass = 'alert-success';
    $scope.delete = function (user) {
        deleteUser(user.id)
                .success(function () {
                    $scope.showAlert = true;
                    $scope.msg = {msg: 'Usuario excluido com sucesso.'};
                    $scope.users = $scope.users.filter(function (_user) {
                        if (user.id !== _user.id)
                            return _user;
                    });
                });

    };
});