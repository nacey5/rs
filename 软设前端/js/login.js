window.addEventListener('load', function() {
    var login = document.querySelector('.login');
    var username = login.querySelector('.username'); //获取账号输入框
    var psd = login.querySelector('.password'); //获取密码输入框
    var loginBtn = login.querySelector('button'); //获取登录按钮
    // username.addEventListener('blur', function() {

    // })
    loginBtn.addEventListener('click', function() {
        $ajax({
            type: "post",
            url: "http://localhost:8080/rs/UserSignServlet",
            data: {
                'username': username,
                'password': password,
            },
            success: function(result) {
                console.log(result);
            }
        })

    })
})