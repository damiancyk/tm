app.controller('itemListCtrl', [ '$scope', 'TableService',
		function($scope, TableService) {

			var data = [ {
				id : 1,
				'title' : 'title123',
				'description' : 'description123'
			}, {
				id : 2,
				'title' : 'title1234356',
				'description' : 'description1344523'
			} ];

			// $scope.tableParams = TableService.initStatic(data);
		} ]);