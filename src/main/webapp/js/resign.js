window.addEventListener('load', function() {
    var resign = this.document.querySelector('.resign');
    var phone = resign.querySelector('.phone');
    var no = resign.querySelector('.userno'); //学号
    var psd = resign.querySelector('.password');
    var psdA = resign.querySelector('.passwordAgain');
    var code = resign.querySelector('.code');
    var man = resign.querySelectorAll('.resign-man'); //注册类型输入框
    var button = resign.querySelector('button'); //注册按钮
    var resignbox = resign.querySelectorAll('.resignbox');
    var name = resign.querySelector('.name');
    var college = resign.querySelector('.college');

    //当选择社团组织时,页面中需要出现社团组织名称和社团组织归属学院的框
    for (let i = 0; i < man.length; i++) {
        man[i].addEventListener('click', function() {

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
    button.addEventListener('click', function() {
            //当选择个人注册时
            if (man[0]) {
                $.ajax({
                    type: 'post',
                    // url: 'http://rsrs.nat300.top/rs/UserSignServlet',
                    url: 'http://localhost:8080/rs/UserSignServlet',
                    data: {
                        action: "register",
                        phone: JSON.stringify(phone),
                        count: JSON.stringify(no),
                        pwd: JSON.stringify(psd),
                        vcode: JSON.stringify(code)
                    },
                    success: function(result) {
                        alert(result.code);
                        console.log(result);
                    }
                })
            }
            //选择社团组织注册时
            else {
                $.ajax({
                    type: 'post',
                    // url: 'http://rsrs.nat300.top/rs/OrganizerSignController',
                    url: 'http://localhost:8080/rs/OrganizerSignController',
                    data: {
                        action: "register",
                        name: JSON.stringify(name),
                        managercount: JSON.stringify(no),
                        phone: JSON.stringify(phone),
                        pwd: JSON.stringify(psd),
                        college: JSON.stringify(college),
                        vcode: JSON.stringify(code)
                    },
                    success: function(result) {
                        alert(result.code);
                        console.log(result);
                    }
                })
            }
        })
        //注册成功之后跳转到登录页面
})