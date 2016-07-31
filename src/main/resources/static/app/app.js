var app = angular.module('dmc', [ 'ngRoute']);

app.config([ '$routeProvider',
		function($routeProvider) {
// $httpProvider.interceptors.push('httpErrorResponseInterceptor');
			$routeProvider.when('/', {
				templateUrl : 'templates/modules.html',
				controller : 'modulesCtrl'
			}).when('/error', {
				templateUrl : 'templates/errors/error.html',
				controller : 'modulesCtrl'
			}).otherwise({
				redirectTo : '/logout'
			});
		} ]);
