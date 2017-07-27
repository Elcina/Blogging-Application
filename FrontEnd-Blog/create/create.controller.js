(function () {
    'use strict';

    angular
        .module('app')
        .controller('CreateController', CreateController);

    CreateController.$inject = ['$location','UserService', 'HomeService','AuthenticationService', '$rootScope'];
    function CreateController($location,UserService, HomeService,AuthenticationService, $rootScope) {
        var vm = this;

        vm.allPosts = [];
        vm.createPost = createPost;

        function createPost() {
            vm.user = HomeService.loadCurrentUser();
            HomeService.createPost(vm.postname,vm.blogpost,vm.user);
            $location.path('/');
        }

    }

})();