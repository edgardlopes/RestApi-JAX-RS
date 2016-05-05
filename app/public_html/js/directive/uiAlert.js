angular.module('app').directive('uiAlert', function(){
	return {
		templateUrl: 'views/directive/alert.html',
		replace: true,
		restrict: 'E',
		scope: {
			alertClass: '@',
			show: '@'
		},
		transclude: true
	};
});