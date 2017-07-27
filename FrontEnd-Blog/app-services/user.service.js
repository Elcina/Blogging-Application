(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};

        service.GetByUsername = GetByUsername;
        service.Create = Create;

        return service;

         function GetByUsername(username,password) {
            return $http.post('http://192.168.2.4:8090/blogspace/create',{"name":username,"password":password})
                .then(handleSuccess, handleError('Error Getting user'));
        }

        function Create(user) {
            return $http.post('http://192.168.2.4:8090/blogspace/create',{"name":user.username,"password":user.password})
                .then(handleSuccess, handleError('Error creating user'));
        }

        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();