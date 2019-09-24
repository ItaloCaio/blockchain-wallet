angular.module("appStefanini", []);

angular.module("appStefanini").controller("appAuthorCtrl", function ($scope, $http) {

    urlAuthor = 'http://localhost:8080/authors';

    var pathname = window.location.pathname.split( '/' );
    var urlAuthorById = 'http://localhost:8080/authors/' +  pathname[2];
    $scope.getAuthors = function () {

        $http.get(urlAuthor).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.authors = response.data;
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    };

    $scope.getArtworks = function () {
        urlArtwork = 'http://localhost:8080/artworks';
        $http.get(urlArtwork).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.artworks = response.data;
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    };

    $scope.getAuthorById = function (){


        $http.get(urlAuthorById).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.authorId = response.data;
            console.log('autor', response.data);
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    }

    $scope.addAuthor = function (author){


        $http.post(urlAuthor, author).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.stream = response.data;
            window.location.reload();

        }
        function errorCallback(error) {
            alert("erro ao adiciona o autor");
        }
    }

    $scope.removeAuthor = function(author){

        $http.delete(urlAuthorById, author).then(successCallback, errorCallback);

        function successCallback(response) {
            window.location.reload();

        }
        function errorCallback(error) {
            alert("erro ao atualizar o autor");
        }

    }

    $scope.updateAuthor = function(author){

        $http.put(urlAuthorById, author).then(successCallback, errorCallback);

        function successCallback(response) {
            window.location.reload();

        }
        function errorCallback(error) {
            alert("erro ao atualizar o autor");
        }
    }


    $scope.getAuthors();
    $scope.getArtworks();

    if(pathname.length > 2){
        console.log("if");
        $scope.getAuthorById();
    }


});
