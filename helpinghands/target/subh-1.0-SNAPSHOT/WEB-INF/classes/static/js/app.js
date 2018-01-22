var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/signup',{
            templateUrl: '/view/signup.html',
            controller: 'signupController'
        })
        .when('/login',{
            templateUrl: '/view/login.html',
            controller: 'loginController'
        })
        .when('/users',{
            templateUrl: '/view/users.html',
            controller: 'usersController'
        })
        .when('/show',{
            templateUrl: '/view/show.html',
            controller: 'showController'
        })
        /*
        .when('/success',{
            templateUrl: '/view/success.html',
            controller: 'successController'
        })
        .otherwise(
            { redirectTo: '/'}
        );*/
        
});

