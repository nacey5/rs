window.addEventListener('load', function() {
    var login = document.querySelector('.login');
    var phone = login.querySelector('.phoneNo'); //获取账号输入框
    var psd = login.querySelector('.password'); //获取密码输入框
    var code = login.querySelector('.code'); //获取验证码输入框
    var loginBtn = login.querySelector('button'); //获取登录按钮
    var curBox = login.querySelector('.curBox');
    phone.addEventListener('blur', function() {
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
    // 判断密码输入正不正确
    // psd.addEventListener('blur', function() {

    //     })

    loginBtn.addEventListener('click', function() {

        $.ajax({
            type: 'post',
            url: 'http://rsrs.nat300.top/rs/UserSignServlet',
            dataType: "json",
            processData: false,
            contentType: false,
            data: {
                'action': login,
                'phone': phone,
                'pwd': psd
            },
            success: function(result) {
                console.log(result);
            }
        })
        var datas = JSON.parse(success());
    })

    // 判断验证码输入正不正确
    code.addEventListener('blur', function() {
        if (datas.code == false) {
            curBox.classList.add('cur');
        } else {
            curBox.classList.remove('cur');
        }
    })
})