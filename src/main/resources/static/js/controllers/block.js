angular.module("appBlockchain", []);

angular.module("appBlockchain").controller("appBlockCtrl", function ($scope, $http) {

    var urlBlock = 'http://localhost:8080/block';

    $scope.getWalletA = function () {
        var walletA = 'http://localhost:8080/block/walletA';
        $http.get(walletA).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.walletA = response.data;
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    };

    $scope.getWalletB = function () {
        var walletB = 'http://localhost:8080/block/walletB';
        $http.get(walletB).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.walletB = response.data;
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    };


    $scope.addValue = function (value){

        $http.post(urlBlock, value).then(successCallback, errorCallback);

        function successCallback(response) {
            window.location.reload();
        }
        function errorCallback(error) {
            alert("erro ao adiciona o obra");
        }
    }




    $scope.getWalletA();
    $scope.getWalletB();



});
