app.controller('indexController', function($scope, $http, $location, $compile) {

	$scope.count = {};
	
	$scope.getCount = function(){
		$http.get("/commun/rest/getCount").then(function (response) {
			$scope.count = response.data;
		}, function error(response) {

		});
	}

	
	$scope.init = function(){
		
		$scope.getCount();
		
	}
	
	 

});