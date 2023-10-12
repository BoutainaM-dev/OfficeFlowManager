app.controller('forgotPasswordController', function($scope, $http, $location, $compile) {

	
	$scope.send = function(){
		$http.post("/utilisateur/rest/password",$scope.dto).then(function (response) {
		toastr.success('Opération effectuée avec succès !', 'Notification', { "closeButton": true });
		}, function error(response) {
			
		});
	}
	
});