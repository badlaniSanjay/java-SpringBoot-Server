(function () {
    var userService = new UserService();
    var rowTemplate;
    var tbody;
    var createUserBtn;
    var editUserBtn;
    var updateUserBtn;
    var deleteUserBtn;
    var uniqueId = 001;

    jQuery(main);

    function main() {
        rowTemplate = jQuery('.wbdv-template');
        createUserBtn = jQuery('.wbdv-create');
        updateUserBtn = jQuery('.wbdv-update');
        tbody = jQuery('tbody');

        createUserBtn.click(createUser);
        updateUserBtn.click(updateUser);

        userService
            .findAllUsers()
            .then(renderUsers)
    }

    function createUser() {



        var user = getUserDetails();
        user.id = getUniqueId();
        userService
            .createUser(user)
            .then(renderUsers);
        emptyFileds();
    }

    function renderUsers(users) {
        tbody.empty()
        for(var u in users) {
            const user = users[u]
            const rowClone = rowTemplate.clone();
            rowClone.removeClass('wbdv-hidden');
            rowClone.find('.wbdv-username').html(user.username);
            rowClone.find('.wbdv-first-name').html(user.firstName);
            rowClone.find('.wbdv-last-name').html(user.lastName);
            rowClone.find('.wbdv-role').html(user.role);
            rowClone.attr("id", "user" + user.id);
            rowClone.on("click", ".wbdv-remove", function() {
                deleteUser(user.id);
            });
            rowClone.on("click", ".wbdv-edit", function() {
                findUserById(user.id);
            });
            tbody.append(rowClone);
        }
    }

    function renderUser(user){
        $("#idFld").val(user.id)
        $('#usernameFld').val(user.username);
        $('#passwordFld').val(user.password);
        $('#firstNameFld').val(user.firstName);
        $('#lastNameFld').val(user.lastName);
        $('#roleFld').val(user.role).change();
    }

    function findUserById(id){
            userService.findUserById(id).then(renderUser)
    }


    function deleteUser(id){
        userService.
            deleteUser(id).then(findAllUsers)
    }

    function findAllUsers() {

        tbody.find("tr:not(.wbdv-hidden)").remove();
        userService.findAllUsers().then(renderUsers);
    }

    function updateUser(){

        var user = getUserDetails();
        if ($('#idFld').val() == "") {
            alert(
                " This row does not exist already... Try adding it as a new row"
            );
            return;
        }
        userService.updateUser(user.id, user).then(findAllUsers);
        emptyFileds();
    }

    function getUserDetails(){
        var idFld = $('#idFld');
        var usernameFld = $('#usernameFld');
        var passwordFld = '';
        var firstNameFld = $('#firstNameFld');
        var lastNameFld = $('#lastNameFld');
        var roleFld = $('#roleFld');


        var id = idFld.val();
        var username = usernameFld.val();
        var password = 'boggus';
        var firstName = firstNameFld.val();
        var lastName = lastNameFld.val();
        var role = roleFld.val();


        if (
            username == null || password == null || firstName == null || lastName == null ||
            role == null || username == "" || password == "" ||
            firstName == "" || lastName == "" || role == ""
        ) {
            alert("Please Enter the data of the user");
            return;
        }


        var user = {
            id:id,
            username: username,
            password: password,
            firstName: firstName,
            lastname: lastName,
            role: role
        }

        return user;
    }

    function emptyFileds(){
        $("#idFld").val('')
        $('#usernameFld').val('');
        $('#passwordFld').val('');
        $('#firstNameFld').val('');
        $('#lastNameFld').val('');
    }

    function getUniqueId(){
        var temp = uniqueId;
        uniqueId = uniqueId + 1;
        return temp;
    }

})()