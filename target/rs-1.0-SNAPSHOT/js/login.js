window.addEventListener('load', function () {
    var login = document.querySelector('.login');
    var username = login.querySelector('.username'); //获取账号输入框
    var psd = login.querySelector('.password'); //获取密码输入框
    var loginBtn = login.querySelector('button'); //获取登录按钮
    // var code = login.querySelector('img'); //获取验证码输入框
    // var vcode = login.querySelector('.vcode'); //获取验证码图片

    // vcode.addEventListener('click', function () {
    //     //验证码单击事件
    //     document.getElementsByTagName("vcode").src = "http://localhost:8080/rs/kaptcha.jpg?d=" + new Date();
    // })
    loginBtn.addEventListener('click', function () {
        $.ajax({
            type: "post",
            url: "http://rsrs.nat300.top/rs/UserSignServlet",
            // url: "http://localhost:8080/rs/UserSignServlet",
            dataType:"json",
            // processData:false,
            // contentType:false,
            contentType:"application/x-www-form- urlencoded, charset=UTF-8",
            data: {
                'action': "login",
                'username': username,
                'password': psd,
                // 'vcode':code,
            },
            dataType: "json",
            success: function (result) {
                alert(result.msg);
            }
        })

    })
})