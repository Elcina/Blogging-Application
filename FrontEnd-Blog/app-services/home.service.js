(function () {
    'use strict';

    angular
        .module('app')
        .factory('HomeService', HomeService);

    HomeService.$inject = ['$http'];
    function HomeService($http) {
        var service = {};
        var currentUser;

        service.GetAllPosts = GetAllPosts;
        service.createPost = createPost;
        service.loadCurrentUser = loadCurrentUser;
        service.setCurrentUser = setCurrentUser;
        service.addComment = addComment;

        return service;

        function GetAllPosts() {
            return $http.get('http://localhost:8090/blogspace')
                .then(handleSuccess, handleError('Error Getting Posts'));
        }

        function createPost(title,desc,user) {
            return $http.post('http://localhost:8090/blogspace/'+user+'/blog/create',{"title":title,"blogDescription":desc})
                .then(handleSuccess, handleError('Error creating Post'));
        }

        function loadCurrentUser() {
            return currentUser;
        }

        function setCurrentUser(user) {
            currentUser = user;
        }

        function addComment(post,comment){
            return $http.post('http://192.168.2.4:8090/blogspace/'+post.createdBy+'/blog/'+post.blogId+'/comment',{"commenter":currentUser,"comment":comment})
                .then(handleSuccess, handleError('Error adding Comment'));
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