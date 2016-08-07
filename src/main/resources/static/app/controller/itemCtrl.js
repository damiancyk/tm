app.controller('itemListCtrl', [ '$scope', 'Data', function($scope, Data) {

	$scope.list = function() {
		Data.get('item/1/0/10000000000000').then(function(data) {
			$scope.rows = data;
		});
	}

	$scope.create = function() {
		var form = {
			idUser : 1,
			start : new Date().getTime()
		};

		Data.post('item', form).then(function(data) {
			console.log('successfully added');
			$scope.list();
		});
	};

	$scope.update = function(form) {
		Data.put('item/' + form.id, form).then(function(data) {
			console.log('successfully edited');
			console.log(form)
			$scope.list();
		});
	}

	$scope.del = function(form) {
		Data.del('item/' + form.id).then(function(data) {
			console.log('successfully deleted');
			$scope.list();
		});
	}

	$scope.list();
} ]);