angular.module("appStefanini", []);

angular.module("appStefanini").controller("appAuthorCtrl", function ($scope, $http) {

    urlAuthor = 'http://localhost:8080/authors';

    var pathname = window.location.pathname.split( '/' );

    $scope.getAuthors = function () {

        $http.get(urlAuthor).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.authors = response.data;
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    };

    $scope.getAuthorById = function (){
        urlAuthorById = urlAuthor +  pathname[2];

        $http.get(urlClassById).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.authorId = response.data;
            console.log('autor', response.data);
        }
        function errorCallback(error) {
            alert("erro no get");
        }
    }

    $scope.addAuthor = function (stream){

        stream.user = $scope.userLogado;
        stream.aClass = $scope.classId;
        $http.post(urlAuthor, stream).then(successCallback, errorCallback);

        function successCallback(response) {
            $scope.stream = response.data;
            window.location.reload();

        }
        function errorCallback(error) {
            alert("erro ao adiciona o autor");
        }
    }

    $scope.removeAuthor = function(author){

    }

    $scope.updateAuthor = function(author){

    }

    $scope.getAuthors();


});
