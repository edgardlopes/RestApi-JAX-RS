angular.module('app').factory('taskService', function ($http, config) {
    var _getTasks = function (params) {
        params = params || {};
        var _params = {};

        if(params.id) _params.userFK = params.id;

        return $http.get(config.baseUrl + '/tasks', {params: _params});
    };

    var _readById = function (_id) {
        return $http.get(config.baseUrl + '/tasks/' + _id);
    };

    var _create = function (task) {
        return $http.post(config.baseUrl + '/tasks', task);
    };

    var _update = function (task) {
        return $http.put(config.baseUrl + '/tasks', task);
    };

    var _delete = function (_id) {
        return $http.delete(config.baseUrl + '/tasks/' + _id);
    };

    return {
        getTasks: _getTasks,
        readById: _readById,
        create: _create,
        update: _update,
        delete: _delete
    };
});
