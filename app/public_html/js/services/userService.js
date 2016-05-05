angular.module('app').factory('userService', function ($http, config) {
    var _getUsers = function () {
        return $http.get(config.baseUrl + '/users');
    };

    var _readById = function (_id) {
        return $http.get(config.baseUrl + '/users/' + _id);
    };

    var _create = function (user) {
        return $http.post(config.baseUrl + '/users', user);
    };

    var _update = function (user) {
        return $http.put(config.baseUrl + '/users', user);
    };

    var _delete = function (_id) {
        return $http.delete(config.baseUrl + '/users/' + _id);
    };

    return {
        getUsers: _getUsers,
        readById: _readById,
        create: _create,
        update: _update,
        delete: _delete
    };
});
