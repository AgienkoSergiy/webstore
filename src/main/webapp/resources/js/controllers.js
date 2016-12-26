
var cartApp = angular.module('cartApp', []);
cartApp.controller('cartCtrl', function ($scope, $http) {

    $scope.refreshCart = function(cartId) {
        $http.get('/webstore/rest/cart/'+$scope.cartId).success(function(data) {
                $scope.cart = data;
            });
    };

    $scope.clearCart = function() {
        $http.delete('/webstore/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));

    };

    $scope.initCartId = function(cartId) {
        $scope.cartId=cartId;
        $scope.refreshCart($scope.cartId);
    };

    $scope.addToCart = function(productId) {
        $http.put('/webstore/rest/cart/add/'+productId).success(function(data) {
                $scope.refreshCart($http.get('/webstore/rest/cart/get/cartId'/*+$scope.cartId*/));
                alert("Product Successfully added to the Cart!");
            });
    };
    $scope.removeFromCart = function(productId) {
        $http.put('/webstore/rest/cart/remove/'+productId).success(function(data) {
                $scope.refreshCart($http.get('/webstore/rest/cart/get/cartId'/*+$scope.cartId*/));
            });
    };

    $scope.getMatrixRequest = function () {
        var query = window.location.search.substring(1);
        alert(query);
        var result = '/webstore/products/byCriteria/';
        var vars = query.split('&');
        for (var i = 0; i < vars.length; i++) {
            result+=vars[i];
        }
        alert(result);
        console.log('Query variable %s not found', result);
        return result;

    };
    $scope.queryToMatrix= function () {
        var fields = $( 'form' ).serializeArray();
        var result = '/webstore/products/byCriteria/';
        jQuery.each( fields, function( i, field ) {
            result.append( field.key + "=" + field.value + ";");
        });
        alert(result);
    }
});