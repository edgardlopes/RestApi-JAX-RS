angular.module('app').controller('createTaskController', function ($scope, user, createTask) {
	$scope.user = user.data;
	$scope.task = {user: $scope.user};
	$scope.showAlert = false;
	$scope.alertClass = 'alert-danger';

	$scope.save = function (task) {
		task.done = task.done || false;
		createTask(task)
			.success(function () {
				$scope.showAlert = true;
				$scope.alertClass = 'alert-success';
				$scope.msg = {msg: 'Tarefa salva com sucesso.'};
			})
			.error(function () {
				$scope.showAlert = true;
				$scope.msg = {msg: 'Um erro ocorreu'};
			});
	};
});