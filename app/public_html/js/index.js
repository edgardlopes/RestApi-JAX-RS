angular.module('app', ['ngRoute']);

angular.module('app').config(function ($routeProvider) {
    $routeProvider.when('/login', {
        templateUrl: 'views/user/login.html',
        controller: 'loginController'
    });

    $routeProvider.when('/usuarios', {
        templateUrl: 'views/user/users.html',
        controller: 'usersController',
        resolve: {
            users: function (userService) {
                return userService.getUsers();
            },
            deleteUser: function (userService) {
                return userService.delete;
            }
        }
    });

    $routeProvider.when('/novoUsuario', {
        templateUrl: 'views/user/form.html',
        controller: 'createUserController'
    });

    $routeProvider.when('/usuario/:id', {
        templateUrl: 'views/user/form.html',
        controller: 'updateUserController',
        resolve: {
            user: function (userService, $route) {
                return userService.readById($route.current.params.id);
            },
            updateUser: function (userService) {
                return userService.update;
            }
        }
    });

    $routeProvider.when('/usuario/:id/tasks', {
        templateUrl: 'views/task/list.html',
        controller: 'tasksController',
        resolve: {
            tasks: function(taskService, $route) {
                return taskService.getTasks({id: $route.current.params.id});
            },
            user: function(userService, $route) {
                return userService.readById($route.current.params.id);
            }
        }
    });

    $routeProvider.when('/usuario/:id/novaTarefa', {
        templateUrl: 'views/task/form.html',
        controller: 'createTaskController',
        resolve: {
            user: function(userService, $route) {
                return userService.readById($route.current.params.id);
            },
            createTask: function (taskService) {
                return taskService.create;
            }
        }
    });

    $routeProvider.when('/usuario/:id/tarefa/:tarefaId', {
        templateUrl: 'views/task/form.html',
        controller: 'updateTaskController',
        resolve: {
            task: function (taskService, $route) {
                return taskService.readById($route.current.params.tarefaId);
            },
            updateTask: function (taskService) {
                return taskService.update;
            }
        }
    });
    
    $routeProvider.when('/404', {
        templateUrl: 'views/404.html',
    });

    $routeProvider.when('/error', {
        templateUrl: 'views/error.html',
    });

    $routeProvider.otherwise({redirectTo: '/login'});
});