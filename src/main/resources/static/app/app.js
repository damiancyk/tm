var app = angular.module('myApp', [ 'ngRoute', 'toaster' ]);

app.config([ '$routeProvider', '$locationProvider', '$httpProvider',
		function($routeProvider, $locationProvider, $httpProvider) {
			$httpProvider.interceptors.push('httpErrorResponseInterceptor');
			$routeProvider.when('/', {
				title : 'Modules',
				templateUrl : 'templates/modules.html',
				controller : 'modulesCtrl',
				access : {
					public : false
				}
			}).when('/error', {
				title : 'error',
				templateUrl : 'templates/errors/error.html',
				controller : 'modulesCtrl',
				access : {
					public : false
				}
			}).otherwise({
				redirectTo : '/logout'
			});
		} ]);
