app.controller('demandeController', function($scope, $http, $location, $compile) {

	$scope.table = null;
	$scope.dto = {};
	$scope.filtre = {};
	
	var language = {
			"sProcessing":     "Traitement en cours...",
			"sSearch":         "Rechercher&nbsp;:",
			"sLengthMenu":     "Afficher _MENU_ &eacute;l&eacute;ments",
			"sInfo":           "Affichage de l'&eacute;l&eacute;ment _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
			"sInfoEmpty":      "Affichage de l'&eacute;l&eacute;ment 0 &agrave; 0 sur 0 &eacute;l&eacute;ment",
			"sInfoSelected":   "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
			"sInfoFiltered":   "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
			"sInfoPostFix":    "",
			"sLoadingRecords": "Chargement en cours...",
			"sZeroRecords":    "Aucun &eacute;l&eacute;ment &agrave; afficher",
			"sEmptyTable":     "Aucune donn&eacute;e disponible",
			"oPaginate": {
				"sFirst":      "Premier",
				"sPrevious":   "Pr&eacute;c&eacute;dent",
				"sNext":       "Suivant",
				"sLast":       "Dernier"
			}
	};
	
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
	
	$scope.init = function(editAuthority){
		$scope.table = $('#demandeTable').DataTable( {
			"oLanguage" : language,
			"ajax": "/gestion/demande/rest/list",
			"columns": [
				{ "data": "id", visible: false},
				{ "data": "utilisateurLibelle"},
				{ "data": "dateDemande"},
				{ "data": "projetLibelle"},
				{ "data": "nombreNuits"},
				{ "data": "moyenneTransLibelle"},
				{ "data": "statut"},
				{ "width": 200, "render": function ( data, type, row ) {
					var resultat = '<button type="button" class="btn btn-icon btn-outline-primary btn-sm waves-effect waves-light ml-1" ng-click="preview('+row.id+')"><i class="feather icon-eye"></i></button>';
					if(row.statut == 'Nouvelle') {
						resultat += '<button type="button" class="btn btn-icon btn-outline-success btn-sm waves-effect waves-light ml-1" ng-click="validate('+row.id+')" ng-show="'+editAuthority+'"><i class="feather icon-check"></i></button>'
						+'<button type="button" class="btn btn-icon btn-outline-danger btn-sm waves-effect waves-light ml-1" ng-click="cancel('+row.id+')"><i class="feather icon-x"></i></button>';
					}
                    return resultat;
                    }
				}
			],
			"pageLength": 5,
			"createdRow": function( row, data, dataIndex ) {
				$compile(angular.element(row).contents())($scope);
			}
		} );
		
		
		$scope.initListProjet();
		$scope.initListVille();
		$scope.initListMoyenneTrans();
	}

	$scope.add = function(){
		$scope.dto = {};
		$('#demandeModal').modal('show');
	}
	
	$scope.preview = function(id){
		$http.get("/gestion/demande/rest/load/"+id).then(function (response) {
			$scope.dto = response.data;
			$('#demandeModal').modal('show');
		}, function error(response) {

		});
	}
	
	$scope.save = function(){
		$scope.dto.groupeId = $scope.filtre.groupe;
		$http.post("/gestion/demande/rest/save",$scope.dto).then(function (response) {
			$('#demandeModal').modal('hide');
			$scope.dto = {};
			$scope.table.ajax.reload();
			toastr.success('Opération effectuée avec succès !', 'Notification', { "closeButton": true });
		}, function error(response) {
			
		});
	}

	$scope.validate = function(id) {
		window.open("/gestion/ordreMission/add/"+id, '_blank');
	}
	
	$scope.cancel = function(id) {
		Swal.fire({
		      title: 'Avertissement',
		      type: 'error',
		      html: 'Êtes-vous sûr de vouloir annuler ?',
		      showCloseButton: true,
		      showCancelButton: true,
		      focusConfirm: false,
		      confirmButtonText: 'Confirmer',
		      cancelButtonText: 'Annuler',
		      confirmButtonClass: 'btn btn-danger',
		      cancelButtonClass: 'btn btn-default',
		    }).then(function (result) {
		        if (result.value) {
		        	$scope.confirmCancel(id);
		        }
		    })
	}
	
	$scope.confirmCancel = function(id) {
		$http.get("/gestion/demande/rest/cancel/"+id).then(function (response) {
			$scope.table.ajax.reload();
		}, function error(response) {
			
		});
	}
	
	$scope.showValidation = function(id){
		$http.get("/gestion/demande/rest/load/"+id).then(function (response) {
			$scope.dto = response.data;
			$('#validationModal').modal('show');
		}, function error(response) {

		});
	}
	
	/*$scope.validate = function(){
		$http.post("/gestion/demande/rest/validate",$scope.dto).then(function (response) {
			$('#validationModal').modal('hide');
			$scope.dto = {};
			$scope.table.ajax.reload();
			toastr.success('Opération effectuée avec succès !', 'Notification', { "closeButton": true });
		}, function error(response) {
			
		});
	}*/

});