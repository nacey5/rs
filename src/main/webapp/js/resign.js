window.addEventListener('load', function () {
    var resign = this.document.querySelector('.resign');
    var phone = resign.querySelector('.phone');
    var no = resign.querySelector('.userno'); //学号
    var psd = resign.querySelector('.password');
    var psdA = resign.querySelector('.passwordAgain');
    var code = resign.querySelector('.code');
    var vcode = resign.querySelector('.vcode'); //获取验证码图片
    var man = resign.querySelectorAll('.resign-man'); //注册类型输入框
    var button = resign.querySelector('button'); //注册按钮
    var resignbox = resign.querySelectorAll('.resignbox');
    var name = resign.querySelector('.name');
    var college = resign.querySelector('.college');
    vcode.addEventListener('click', function (e) {
        //验证码单击事件
        vcode.src = "http://rsrs.nat300.top/FindMore/kaptcha.jpg?d=" + new Date();
        alert("点击验证码成功！");
    });

//检查用户信息是否为空
    function checkUserMsg() {
        if (phone.value == "" || psd.value == "" || code.value == "" || no.value == "") {
            alert("请输入完整信息");
            return false;
        }
        return true;
    }

//检查组织信息是否为空
    function checkOrgMsg() {
        if (phone.value == "" || psd.value == "" || college.value == "" || no.value == "") {
            alert("请输入完整信息");
            return false;
        }
        return true;
    }

//检查密码是否一致
    function checkPsd() {
        if (psd.value != psdA.value) {
            alert("两次密码不一致！");
            return false;
        }
        return true;
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

    //当选择社团组织时,页面中需要出现社团组织名称和社团组织归属学院的框
    for (let i = 0; i < man.length; i++) {
        man[i].addEventListener('click', function () {

            if (i == 1) {
                for (let i = 0; i < resignbox.length; i++) {
                    resignbox[i].style.display = "block";
                    resign.style.height = "500px";
                }
            } else {
                for (let i = 0; i < resignbox.length; i++) {
                    resignbox[i].style.display = "none";
                    resign.style.height = "425px";
                }
            }
        })
    }

    //点击注册的时候，判断注册者选择的注册类型（个人注册/社团组织注册）
    button.addEventListener('click', function () {
        //当选择个人注册时
        if (man[0]) {
            alert("个人");
            //检查信息
            if (checkUserMsg() && checkPsd()) {
                $.ajax({
                    type: 'post',
                    url: 'http://rsrs.nat300.top/FindMore/UserSignServlet',
                    data: {
                        action: "register",
                        phone: JSON.stringify(phone.value),
                        count: JSON.stringify(no.value),
                        password: JSON.stringify(psd.value),
                        vcode: JSON.stringify(code.value)
                    },
                    success: function (result) {
                        console.log(result);
                    }
                })
            }
        }
        //选择社团组织注册时
        else {
            alert("社团");
            //检查信息
            if (checkOrgMsg() && checkPsd()) {
                $.ajax({
                    type: 'post',
                    url: 'http://rsrs.nat300.top/FindMore/Organizer',
                    data: {
                        action: "register",
                        name: JSON.stringify(name.value),
                        managercount: JSON.stringify(no.value),
                        phone: JSON.stringify(phone.value),
                        password: JSON.stringify(psd.value),
                        college: JSON.stringify(college.value),
                        vcode: JSON.stringify(code.value)
                    },
                    success: function (result) {
                        console.log(result);
                    }
                })
            }
        }
    })
    //注册成功之后跳转到登录页面
})