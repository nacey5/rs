window.addEventListener('load', function () {

    // var institute = document.querySelector('#institute');
    // var submit = document.querySelector('.submit');
    // var btn = submit.querySelector('button');
    //当前用户信息
    // $.ajax({
    //     type: 'post',
    //     // url: "http://localhost:8080/FindMore/Find",
    //     url: "http://rsrs.nat300.top/FindMore/Find",
    //     dataType: "json",
    //     data: {
    //         action: 'findNowUser',
    //     },
    //     success: function(result) {
    //         //对应上面获取那些id名输入框的.value
    //         name.innerHTML = "姓名：" + result.datas.nowUser.username;
    //         number.innerHTML = "学号：" + result.datas.nowUser.count;
    //         phone.innerHTML = "手机号码：" + result.datas.nowUser.phone;
    //         // photo.src = result.datas.nowUser.headPortrait;
    //         photo.src = "/image/user.png";
    //         institute.innerHTML = "学院：" + result.datas.nowUser.collage;
    //     }
    // })
    //-----------退出-----------
    // var sign_out = document.querySelector('#out');
    // sign_out.addEventListener('click', function() {
    //     $.ajax({
    //         type: "post",
    //         // url: "http://localhost:8080/FindMore/LoginOut",
    //         url: 'http://rsrs.nat300.top/FindMore/LoginOut',
    //         dataType: "json",
    //         data: {
    //             action: "loginOut",
    //         },
    //         success: function(result) {
    //             alert(result.msg);
    //             if (result.code) {
    //                 window.location.href = "index.html";
    //             }
    //         }
    //     })
    // })
//发送请求查询当前用户信息
    $.ajax({
        type: 'post',
        url: "http://localhost:8080/FindMore/Find",
        dataType: "json",
        data: {
            action: 'findNowUser',
        },
        success: function (result) {
            alert(result.datas.nowUser);
            //对应上面获取那些id名输入框的.value
            // name = result.datas.nowUser.name;
            // number = result.datas.nowUser.count;
            // photo.src = result.datas.nowUser.headPortrait;
            // institute = result.datas.nowUser.collage;
        }
    })
    var down = document.querySelector('.down');
    var btns = down.querySelectorAll('button');
    $('#alter').click(function () {
        $('.alter').show(); //显示修改信息页面
    })

    // 点击确定按钮，进行数据的提交，关闭模态框
    function confirm() {
        //发送请求
        right();
        // 获取输入框的数据
        // 调用后台接口，进行数据的添加
        $('.alter').css("display", 'none')
        for (let j = 0; j < btns.length; j++) {
            btns[j].classList.remove('cur');
        }
    }

    // 点击取消按钮，关闭模态框，将输入框置空
    function cancel() {
        // 将将输入框置空
        //关闭模态框
        $('.alter').css("display", 'none')
        for (let j = 0; j < btns.length; j++) {
            btns[j].classList.remove('cur');
        }
    }

    //点击按钮之后背景色变色

    for (let i = 0; i < btns.length; i++) {
        btns[i].addEventListener('click', function () {
            for (let j = 0; j < btns.length; j++) {
                btns[j].classList.remove('cur');
            }
            this.classList.add('cur');

            var timer = setInterval(function () {
                clearInterval(timer);
                // 判断点击了哪个按钮
                if (btns[i].innerHTML == '确定') {
                    confirm();
                } else {
                    cancel();
                }
            }, 2000)

        })
    }

    function right() {
        //发送修改用户信息Ajax请求
        $.ajax({
            type: 'post',
            url: 'http://rsrs.nat300.top/FindMore/UserInfo',
            // url: 'http://localhost:8080/FindMore/UserInfo',
            dataType: 'json',
            data: {
                'action': "setUserInfo",
                name: document.querySelector('#name').value,
                count: document.querySelector('#count').value,
                gender: document.querySelector('#gender').value,
                collage: document.querySelector('#collage').value,
                email: document.querySelector('#email').value,
                phone: document.querySelector('#phone').value,
            },
            success: function (result) {
                alert(result.msg);
                if (result.code) {
                    window.location.href = "person_center.html";
                } else {
                    window.location.reload();
                }
            },
            error: function (aa) {
                window.location.reload();
            }
        })
    }
})