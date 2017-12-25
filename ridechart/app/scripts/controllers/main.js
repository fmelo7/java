'use strict';

/**
 * @ngdoc function
 * @name myAppYoApp.controller:MainCtrl
 * @description # MainCtrl Controller of the myAppYoApp
 */
angular.module('myAppYoApp').controller('MainCtrl', function($scope, $http) {
	
	Chart.defaults.global.colors = [ '#006622', '#3366cc', '#803690', '#00ADF9', '#DCDCDC', '#46BFBD', '#FDB45C' ];
	
	$scope.activities = [];
	
	$scope.vm = {
		title : 'Activities',
		description : 'This are your activities.',
		selected : {},
		activities : $scope.activities
	};
	
	function init() {
		
		//var DATA_SERVICE = "/data-service";
		var DATA_SERVICE = "";
		
		$http.get(DATA_SERVICE + '/datamodel/list').then(function(response) {
			$scope.activities = response.data;
		});
		
		$scope.showActivity = function(item) {
			
			$scope.vm.selected = item;
			
			$scope.activeId = item.id;
			
			$http.get(DATA_SERVICE + '/datamodel/read?id=' + item.id).then(function(response) {
				
				// converter string to numeric
				var json = JSON.parse(JSON.stringify(response.data), function(k, v) {
					return (typeof v === "object" || isNaN(v)) ? v : Number(v);
				});
				
				var labels = [];
				for (var i = 0; i <= json.data1[json.data1.length - 1].x; i++) {
					labels.push(i);
				}
				
				var altitude = [];
				for (var i = 0; i < json.data1.length; i++) {
					altitude.push(json.data1[i].y);
				}
				
				var speed = [];
				for (var i = 0; i < json.data2.length; i++) {
					speed.push(json.data2[i].y);
				}
				
				$scope.activity = JSON.stringify(json);
				
				$scope.labels = labels;
				$scope.series = [ 'Elevation', 'Speed' ];
				$scope.data = [ altitude, speed ];
				$scope.multiAxis = [ 'y-axis-1', 'y-axis-2' ];
				$scope.options = {
					scales : {
						yAxes : [ {
							id : 'y-axis-1',
							type : 'linear',
							display : true,
							position : 'left'
						}, {
							id : 'y-axis-2',
							type : 'linear',
							display : true,
							position : 'right'
						} ]
					}
				};
				
				$scope.isActive = function(item) {
					
					console.log("activeId: " + [ item.id, $scope.activeId, item.id === $scope.activeId ]);
					
					return item.id === $scope.activeId;
				};
			});
		};
	}
	
	init();
});
