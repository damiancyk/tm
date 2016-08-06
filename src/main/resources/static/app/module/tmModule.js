var app = angular.module('tm', [ 'ngRoute', 'ngTable' ]);

app.config([ '$routeProvider', '$locationProvider', '$httpProvider',
		function($routeProvider, $locationProvider, $httpProvider) {
//			$httpProvider.interceptors.push('httpErrorResponseInterceptor');
			$routeProvider.when('/item/list', {
				templateUrl : 'view/itemList.html',
				controller : 'itemListCtrl'
			}).when('/', {
				templateUrl : 'itemList.html',
				controller : 'itemListCtrl'
			}).when('/example-form', {
				templateUrl : 'view/exampleForm.html',
				controller : 'exampleFormCtrl'
			}).otherwise({
				redirectTo : '/'
			});
		} ]);
