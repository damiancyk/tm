app.service("TableService", function($http, $filter, NgTableParams) {
	var service = {
		initStatic : function(data, searchCriteria) {
			var parameters = {
				page : 0,
				count : 1000
			};

			// angular.merge(parameters, searchCriteria);

			return new NgTableParams(parameters, {
				counts : [],
				total : 0,
				getData : function($defer, params) {
					service.getDataStatic($defer, params, data);
				}
			});
		},
		initAjax : function(url, searchCriteria) {
			var parameters = {
				page : 0,
				count : 10
			};

			angular.merge(parameters, searchCriteria);

			return new NgTableParams({
				page : 1,
				count : 200
			}, {
				getData : function($defer, params) {
					service.getDataAjax($defer, params, url);
				}
			});
		},
		clearFilter : function(filters) {
			var filterClear = {};
			for ( var key in filters) {
				var f = filters[key];
				if (f !== '') {
					filterClear[key] = f;
				}
			}
			return filterClear;
		},
		getDataStatic : function($defer, params, data) {
			// TODO pozostaja puste obiekty w modelu, zle dla statycznych danych
			// for (var propt in f) {
			// if (f[propt] === '') {
			// delete f[propt];
			// }
			// }

			var orderedData = params.sorting() ? $filter('orderBy')(data,
					params.orderBy()) : data;

			var filter = this.clearFilter(params.filter());

			orderedData = filter ? $filter('filter')(orderedData, filter)
					: data;

			// orderedData = orderedData.slice((params.page() - 1) *
			// params.count(),
			// params.page() * params.count());

			var length = typeof orderedData === 'undefined' ? 0
					: orderedData.length;
			params.total(length);

			$defer.resolve(orderedData);
		},
		getDataAjax : function($defer, params, url) {
			var paramsUrl = params.url();
			var searchCriteria = {
				pageSize : paramsUrl.count,
				pageNumber : paramsUrl.page - 1
			};
			// searchCriteria.filter = params.url().filter;
			// console.log(searchCriteria);
			paramsUrl.pageSize = paramsUrl.count;
			paramsUrl.pageNumber = paramsUrl.page - 1;
			delete paramsUrl.page;
			delete paramsUrl.count;

			var paramsFilter = params.filter();
			// var paramsSorting = params.sorting();

			var searchCriteria = {
				pageSize : params.url().count,
				pageNumber : params.url().page - 1
			};
			angular.merge(searchCriteria, paramsFilter);

			// console.log(url);
			// console.log(searchCriteria)

			// Data.post(url, searchCriteria).then(function (resp)
			// {
			// params.total(resp.size);
			// $defer.resolve(resp.results);
			// }, function (result) {
			// Data.toast({status: 'error', message: 'Błąd. Skontaktuj się z
			// administratorem.'});
			// });
		}
	};
	return service;
});
