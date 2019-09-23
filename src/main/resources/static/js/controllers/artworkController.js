angular.module("appStefanini", []);

angular.module("appStefanini").controller("appArtworkCtrl", function ($scope, $http) {

    urlArtwork= 'http://localhost:8080/artworks';

    var pathname = window.location.pathname.split( '/' );

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
        urlArtworkById = urlArtwork +  pathname[2];

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

        console.log(artwork);
        console.log(artwork.authors);
        //$http.post(urlArtwork, artwork).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.stream = response.data;
            window.location.reload();

        }
        function errorCallback(error) {
            alert("erro ao adiciona o autor");
        }
    }

    $scope.removeArtwork = function(author){

    }

    $scope.updateArtwork = function(author){

    }

    $scope.getArtworks();
    $scope.getAuthors();


});
