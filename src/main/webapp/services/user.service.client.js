function UserService() {

    this.findAllUsers = findAllUsers
    this.createUser = createUser
    this.findUserById = findUserById
    this.deleteUser = deleteUser
    this.updateUser = updateUser

    // POST - Create
    function createUser(user) {
        return fetch('http://localhost:8080/users', {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response){
            return response.json()
        })
    }

    // GET - Read
    function findAllUsers() {
        return fetch('http://localhost:8080/users')
            .then(function(response){
                return response.json()
            })
    }



    function findUserById(id) {
        return fetch('http://localhost:8080/users/'+id
          ).then(function(response) {
            return response.json();
        });
    }

    function deleteUser(id) {
        return fetch('http://localhost:8080/users/'+id, {
            method: "delete"
        }).then(function(response) {});
    }

    function updateUser(id, user) {
        return fetch('http://localhost:8080/users/'+id, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response){
            // return response.json()
        })
    }


}