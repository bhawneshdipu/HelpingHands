app.controller('usersController', function($scope) {
    $scope.headingTitle = "User List";
});

app.controller('signupController', function($scope) {
    $scope.headingTitle = "Signup Page";
});
app.controller('loginController', function($scope) {
    $scope.headingTitle = "Login Page";
});

app.controller('errorController', function($scope) {
    $scope.headingTitle = "Error Page";
});
app.controller('successController', function($scope) {
    $scope.headingTitle = "Success Page";
});
app.controller('showController', function($scope, $http) {
    $http.get("/showusers")
    .then(function(response) {
    	console.log(response.data);
    	$scope.responseData=response.data;
    	console.log($scope.responseData);
        $scope.userList=$scope.responseData;
    });
});
