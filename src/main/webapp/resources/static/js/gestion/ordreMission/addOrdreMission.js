app.controller('ordreMissionController', function($scope, $http, $location, $compile) {


	$scope.dto = {};
	$scope.dtoDemande = {};
	
	
	$('.pickadate').pickadate();
	
	$scope.initListProjet = function(){
		$http.get("/gestion/projet/rest/getAll").then(function (response) {
			$scope.projets = response.data;
		}, function error(response) {

		});
	}
	
	$scope.initListVille = function(){
		$http.get("/gestion/ville/rest/getAll").then(function (response) {
			$scope.villes = response.data;
		}, function error(response) {

		});
	}
	
	$scope.initListMoyenneTrans = function(){
		$http.get("/gestion/moyenneTrans/rest/getAll").then(function (response) {
			$scope.moyenneTrans = response.data;
		}, function error(response) {

		});
	}
	
	$scope.init = function(demandeId){
		
		$scope.loadDemande(demandeId);
		
		$scope.initListProjet();
		$scope.initListVille();
		$scope.initListMoyenneTrans();
	}

	
	$scope.loadDemande = function(demandeId){
		$http.get("/gestion/demande/rest/load/"+demandeId).then(function (response) {
			$scope.dtoDemande = response.data;
		}, function error(response) { });
		
		$http.get("/gestion/demande/rest/load/"+demandeId).then(function (response) {
			$scope.dto = response.data;
		}, function error(response) {});
	}
	
	$scope.save = function(){
		$scope.dto.id = null;
		$scope.dto.demandeId = $scope.dtoDemande.id;
		$http.post("/gestion/ordreMission/rest/save",$scope.dto).then(function (response) {
			toastr.success('Opération effectuée avec succès !', 'Notification', { "closeButton": true });
			window.open("/gestion/ordreMission", '_self');
		}, function error(response) {
			
		});
	}
	

});