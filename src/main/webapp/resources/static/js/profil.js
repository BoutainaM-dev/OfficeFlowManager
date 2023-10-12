app.controller('profilController', function($scope, $http, $location, $compile) {

	$scope.dto = {};
	
	$scope.loadCurrent = function(){
		$http.get("/administration/utilisateur/rest/getCurrent").then(function (response) {
			$scope.dto = response.data;
		}, function error(response) {

		});
	}
	
	$scope.init = function(){
		
		$scope.loadCurrent();
		
	}
	
	$scope.save = function(){
		$http.post("/administration/utilisateur/rest/save",$scope.dto).then(function (response) {
			$scope.loadCurrent();
			toastr.success('Opération effectuée avec succès !', 'Notification', { "closeButton": true });
		}, function error(response) {
			
		});
	}
	
	$scope.updateProfil = function(){
		$scope.profilForm.$setSubmitted();
		if ($scope.profilForm.$valid) {
			var formData = new FormData($("#profilForm")[0]);
			formData.append("id", $scope.dto.id);
			$http({
				url: "/administration/utilisateur/rest/updateProfil",
				method: 'POST',
				data: formData,
				headers: {'Content-Type': undefined},
				transformRequest: angular.identity  
			}).then(function (response) {
				toastr.success('Opération effectuée avec succès !', 'Notification', { "closeButton": true });
				location.reload();
			}, function error(response) {
				
			});
		}
	}
	
	$scope.changePassword = function(){
		$http.post("/administration/utilisateur/rest/changePassword",$scope.dto).then(function (response) {
			$scope.loadCurrent();
			toastr.success('Opération effectuée avec succès !', 'Notification', { "closeButton": true });
		}, function error(response) {
			
		});
	}
	
	$scope.cancel = function(){
		$scope.loadCurrent();
	};
	
	$scope.upload = function(){
		$('#document').click();
	};
	
	$('#document').on("change" ,function(){
		$scope.updateProfil();
	});
	
});