angular.module("appStefanini", []);

angular.module("appStefanini").controller("appRegisterCtrl", function ($scope, $http) {

    urlRegister = 'http://localhost:8080/user';


    $scope.salvar = function (user) {
        $http.post(urlRegister, user).then(function (response) {
            console.log("salvou", user);
            delete $scope.user;
        });
    }


});
