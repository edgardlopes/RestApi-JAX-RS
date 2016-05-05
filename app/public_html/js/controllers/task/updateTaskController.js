angular.module('app').controller('updateTaskController', function ($scope, task, updateTask) {
	$scope.task = task.data;
	$scope.user = $scope.task.user;

	$scope.save = function (task) {
		task.done = task.done || false;
		updateTask(task)
			.success(function () {
				$scope.showAlert = true;
				$scope.alertClass = 'alert-success';
				$scope.msg = {msg: 'Tarefa salva com sucesso.'};
			})
			.error(function (error) {
				$scope.showAlert = true;
				$scope.alertClass = 'alert-danger';
				$scope.msg = {msg: 'OOPS, um erro ocorreu.'};
			});
	};
});