window.addEventListener('load', function () {
    var login = document.querySelector('.login');
    var phone = login.querySelector('.phoneNo'); //获取账号输入框
    var psd = login.querySelector('.password'); //获取密码输入框
    var code = login.querySelector('.code'); //获取验证码输入框
    var vcode = login.querySelector('.vcode'); //获取验证码图片
    var loginBtn = login.querySelector('button'); //获取登录按钮
    var curBox = login.querySelector('.curBox');
    vcode.addEventListener('click', function (e) {
        //验证码单击事件
        vcode.src = "http://localhost:8080/FindMore/kaptcha.jpg?d=" + new Date();
    });
    loginBtn.addEventListener('click', function (e) {
        if (phone.value == "" || psd.value == "" || code.value == "") {
            alert("请输入完整信息");
            return false;
        }
        phone.addEventListener('blur', function () {
            var results = phoneFun(phone.value);
            if (results == false) {
                curBox.classList.add('cur');
            } else {
                curBox.classList.remove('cur');
            }
        })

        // 判断手机号码输入是否正确
        function phoneFun(phone) {
            var myreg = /^[1][3,4,5,7,8,9][0-9]{9}$/;
            if (!myreg.test(phone)) {
                return false;
            } else {
                return true;
            }
        }
        $.ajax({
            type: 'post',
            // url: 'http://rsrs.nat300.top/FindMore/UserSignServlet',
            url: 'http://localhost:8080/FindMore/UserSignServlet',
            dataType: 'json',
            data: {
                'action': "login",
                'phone': phone.value,
                'password': psd.value,
                'vcode': code.value
            },
            success: function (result) {
                alert(result.msg);
                if (result.code) {
                    window.location.href = "index.html";
                } else {
                   window.location.reload();
                }
            },
            error: function (aa) {
                console.log(aa);
            }
        })
    })
})