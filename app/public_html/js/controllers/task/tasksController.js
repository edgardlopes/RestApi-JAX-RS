angular.module('app').controller('tasksController', function ($scope, tasks, user, taskService) {
	$scope.tasks = tasks.data;
	$scope.user = user.data;

	$scope.delete = function (task) {
		taskService.delete(task.id)
			.success(function () {
				$scope.tasks = $scope.tasks.filter(function (_task) {
					if(_task.id !== task.id) return _task;
				});

				$scope.showAlert = true;
				$scope.alertClass = 'alert-success';
				$scope.msg = {msg: 'Tarefa excluida com sucesso.'};
			})
			.error(function () {
				$scope.showAlert = true;
				$scope.alertClass = 'alert-danger';
				$scope.msg = {msg: 'OOPS, um erro ocorreu.'};	
			});
	};

	$scope.finishTask = function (task) {
		task.done = true;
		taskService.update(task)
			.success(function () {
				$scope.showAlert = true;
				$scope.alertClass = 'alert-success';
				$scope.msg = {msg: 'Tarefa atualizada.'};
			})
			.error(function () {
				$scope.showAlert = true;
				$scope.alertClass = 'alert-danger';
				$scope.msg = {msg: 'OOPS, um erro ocorreu.'};	
			});
	};
});