window.addEventListener('load', function () {

    var right = document.querySelector('.right');
    var alter = this.document.querySelector('.alter');
    var photo = this.document.querySelector('.photo');
    //-----------退出-----------

//发送请求查询当前用户信息
    $.ajax({
        type: 'post',
        url: "http://localhost:8080/FindMore/Find",
        // url: 'http://rsrs.nat300.top/FindMore/Find',
        dataType: "json",
        data: {
            action: 'findNowUser',
        },
        success: function (result) {
            var head=result.datas.nowUser.headPortrait;
            var defaultHead ="http://localhost:8080/FindMore/image/user.png";
            // alert( head== null ?defaultHead :head);
            var src= head== null ?defaultHead :head;
            // alert(src);
            //对应上面获取那些id名输入框的.value
            right.querySelector('#r_name').value=(result.datas.nowUser.username == null ? "··暂无" : result.datas.nowUser.username);
            right.querySelector('#r_count').value=(result.datas.nowUser.count == null ? "··暂无" : result.datas.nowUser.count);
            right.querySelector('#r_gender').value=(result.datas.nowUser.gender == null ? "··暂无" : result.datas.nowUser.gender);
            right.querySelector('#r_phone').value=(result.datas.nowUser.phone == null ? "··暂无" : result.datas.nowUser.phone);
            right.querySelector('#r_password').value=(result.datas.nowUser.password == null ? "··暂无" : result.datas.nowUser.password);
            right.querySelector('#r_collage').value=(result.datas.nowUser.collage == null ? "··暂无" : result.datas.nowUser.collage);
            right.querySelector('#r_email').value=(result.datas.nowUser.email == null ? "··暂无" : result.datas.nowUser.email);
            photo.querySelector("#r_photo").src=src;
        }
    })
    photo.onmouseover = function () {
        photo.querySelector('.cPhoto').style.display = 'block';
    }
        document.querySelector('.change').addEventListener('click',function () {

        })
    photo.onmouseleave = function () {
        photo.querySelector('.cPhoto').style.display = 'none';
    }
    var down = document.querySelector('.down');
    var btns = down.querySelectorAll('button');
    $('#alter').click(function () {
        $('.alter').show(); //显示修改信息页面
    })



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
            }, 200)

        })
    }
// 点击确定按钮，进行数据的提交，关闭模态框
    function confirm() {
        //发送请求
        sureChange();
        // 获取输入框的数据
        // 调用后台接口，进行数据的添加
        $('.alter').css("display", 'none')
        for (let j = 0; j < btns.length; j++) {
            btns[j].classList.remove('cur');
        }
    }
    function sureChange() {
        //发送修改用户信息Ajax请求
        $.ajax({
            type: 'post',
            // url: 'http://rsrs.nat300.top/FindMore/UserInfo',
            url: 'http://localhost:8080/FindMore/UserInfo',
            dataType: 'json',
            data: {
                'action': "setUserInfo",
                'username': alter.querySelector('#name').value,
                count: alter.querySelector('#count').value,
                gender: alter.querySelector('#gender').value,
                password: alter.querySelector('#password').value,
                collage: alter.querySelector('#collage').value,
                email: alter.querySelector('#email').value,
                phone: alter.querySelector('#phone').value,
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