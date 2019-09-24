angular.module("appStefanini", []);

angular.module("appStefanini").controller("appArtworkCtrl", function ($scope, $http) {

    urlArtwork= 'http://localhost:8080/artworks';

    var pathname = window.location.pathname.split( '/' );
    var urlArtworkById = 'http://localhost:8080/artworks/' +  pathname[2];

    $scope.getArtworks = function () {

        $http.get(urlArtwork).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.artworks = response.data;
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    };

    $scope.getAuthors = function () {
        urlAuthor = 'http://localhost:8080/authors';
        $http.get(urlAuthor).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.authors = response.data;
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    };

    $scope.getArtworkById = function (){

        $http.get(urlArtworkById).then(successCallback, errorCallback);
        function successCallback(response) {
            $scope.artworkId = response.data;
            console.log('autor', response.data);
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    }

    $scope.addArtwork = function (artwork){

        $http.post(urlArtwork, artwork).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.artwork = response.data;
            window.location.reload();
        }
        function errorCallback(error) {
            alert("erro ao adiciona o obra");
        }
    }

    $scope.removeArtwork = function(artwork){
        console.log(urlArtworkById);
        $http.delete(urlArtworkById, artwork).then(successCallback, errorCallback);

        function successCallback(response) {
            window.location.reload();
        }
        function errorCallback(error) {
            alert("erro ao remover a obra");
        }

    }

    $scope.updateArtwork = function(artwork){
        $http.put(urlArtworkById, artwork).then(successCallback, errorCallback);

        function successCallback(response) {
            window.location.reload();
        }
        function errorCallback(error) {
            alert("erro ao atualizar a obra");
        }

    }

    $scope.getArtworks();
    $scope.getAuthors();

    if(pathname.length > 2){
        console.log("if");
        $scope.getArtworkById();
    }


});
