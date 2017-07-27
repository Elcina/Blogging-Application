(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['UserService', 'HomeService','AuthenticationService', '$rootScope'];
    function HomeController(UserService, HomeService,AuthenticationService, $rootScope) {
        var vm = this;

        //vm.user = null;
        vm.allPosts = [];
        vm.logout = logout;
        vm.isLoggedIn = isLoggedIn;
        vm.addComment = addComment;
        initController();

        function initController() {
            loadCurrentUser();
            loadAllPosts();
        }

        function loadCurrentUser() {
            if($rootScope.globals.currentUser){
                vm.user = $rootScope.globals.currentUser.username;
                HomeService.setCurrentUser(vm.user);
            }
        }

        function loadAllPosts() {
            HomeService.GetAllPosts()
                .then(function (blogposts) {
                    var posts = blogposts.blogSpace;
                    for(var i=0;i<posts.length;i++){
                        if(posts[i].blogs.length>0){
                            for(var j=0;j<posts[i].blogs.length;j++){
                                posts[i].blogs[j].createdBy = posts[i].userName;
                            }
                            vm.allPosts = vm.allPosts.concat(blogposts.blogSpace[i].blogs);
                        }
                    }
                });
        }

        function addComment(post,comment,i){
            HomeService.addComment(post,comment,i)
                .then(function (res) {
                    if(res.status == "SUCCESS"){
                        vm.allPosts[i].comments.push({  "commenter": vm.user, "comment": vm.comment});
                        vm.comment = null;
                    }

                });
        }

        function logout() {
            AuthenticationService.ClearCredentials();
            $rootScope.globals = {};
        }

        function isLoggedIn() {
            if ($rootScope.globals.currentUser) {
                return true;
            } else {
                return false;
            }
        }

    }

})();
