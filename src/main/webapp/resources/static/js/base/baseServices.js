var app = angular.module('app', []);

//app.directive("datepicker", function () {
//	return {
//		restrict: "A",
//		require: "ngModel",
//		link: function (scope, elem, attrs, ngModelCtrl) {
//			var updateModel = function (dateText) {
//				scope.$apply(function () {
//					ngModelCtrl.$setViewValue(dateText);
//				});
//			};
//			var options = {
//					orientation: "bottom auto",
//					autoclose:true,
//					format: 'dd/mm/yyyy',
//					language: 'fr'
//			};
//			$(elem).datepicker(options).on('changeDate', function(e) {
//				updateModel(e.date);
//			});
//		}
//	}
//});