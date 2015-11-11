var module = angular.module('myapp', ['ngResource']);

module.factory('Todo', function($resource) {
    return $resource(':login/todos', { login: '@login' });
})

    module.filter('filter', function () {
        return function (todos, word) {
            var filtered = [];
            for (var i = 0; i < todos.length; i++) {
                var todo = todos[i];
                if (word == 'all') {
                    filtered.push(todo);
                }
                else if (word == 'done' && todo.closed == true){
                        filtered.push(todo);
                }
                else if (word == 'act' && todo.closed == false){
                    filtered.push(todo);
                }
            }
            return filtered;
        };
    });

    module.controller('TodosController', function($scope, Todo) {
        var url = function() {
            return {login:$scope.login||'empty'};
        }

        var update = function() {
            console.log(url());
            $scope.todos = Todo.query(url());
        };

        $scope.update = update;

        $scope.switch = function(todo){
            todo.closed = !todo.closed
            todo.$save(url(), function() {update();});

        };


        $scope.delete = function(todo) {

            Todo.delete(angular.extend(url(), todo), function(){update();});
        }

        $scope.add = function() {
            var todo = new Todo();
            todo.text = $scope.text;
            todo.$save(url(), function() {
                $scope.text = "";
                update();
            });
        };

        $scope.edit = function(todo) {
            $scope.activeTodo = todo;
        };
        $scope.confirm = function(todo) {
            $scope.activeTodo = null;
            todo.$save(url());
        };

        update();
    });
