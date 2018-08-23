function createTeacher() {
    let url = '/api/teacher';
    let wrap = {
        firstName: $('#firstname').val(),
        lastName: $('#lastname').val(),
        patronymic: $('#patronymic').val(),
        login: $('#login').val(),
        password: $('#password').val(),
        age: $('#age').val(),
        sex: $('#sex').val(),
        phone: $('#phone').val(),
        email: $('#email').val(),
        country: $('#country').val(),
        address: $('#address').val()
    };
    let data = JSON.stringify(wrap);

    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json; charset=utf-8",
        data: data,
        success: function () {

        },
        error: function (e) {

        }
    });


}