var app = angular.module('tm', [ 'ngRoute' ]);

app.config([ '$routeProvider', function($routeProvider) {
	// $httpProvider.interceptors.push('httpErrorResponseInterceptor');
	$routeProvider.when('/item/list', {
		templateUrl : 'itemList.html',
		controller : 'itemListCtrl'
	}).when('/', {
		templateUrl : 'itemList.html',
		controller : 'itemListCtrl'
	}).when('/example-form', {
		templateUrl : 'exampleForm.html',
		controller : 'exampleFormCtrl'
	}).otherwise({
		redirectTo : '/'
	});
} ]);
