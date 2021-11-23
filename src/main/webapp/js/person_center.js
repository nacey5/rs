window.addEventListener('load', function() {
    var name = document.querySelector('#name');
    var number = document.querySelector('#number');
    var phone = document.querySelector('#phone');
    var photo = document.querySelector('.img_change');
    // var nickname = document.querySelector("#nickname");
    var institute = document.querySelector('#institute');
    var submit = document.querySelector('.submit');
    var btn = submit.querySelector('button');
    当前用户信息
    $.ajax({
        type: 'post',
        // url: "http://localhost:8080/FindMore/Find",
        url: "http://rsrs.nat300.top/FindMore/Find",
        dataType: "json",
        data: {
            action: 'findNowUser',
        },
        success: function(result) {
            //对应上面获取那些id名输入框的.value
            name.innerHTML = "姓名：" + result.datas.nowUser.username;
            number.innerHTML = "学号：" + result.datas.nowUser.count;
            phone.innerHTML = "手机号码：" + result.datas.nowUser.phone;
            // photo.src = result.datas.nowUser.headPortrait;
            photo.src = "/image/user.png";
            institute.innerHTML = "学院：" + result.datas.nowUser.collage;
        }
    })
    var sign_out = document.querySelector('#out');
    sign_out.addEventListener('click', function() {
        $.ajax({
            type: "post",
            // url: "http://localhost:8080/FindMore/LoginOut",
            url: 'http://rsrs.nat300.top/FindMore/LoginOut',
            dataType: "json",
            data: {
                action: "loginOut",
            },
            success: function(result) {
                alert(result.msg);
                if (result.code) {
                    window.location.href = "index.html";
                }
            }
        })
    })

    btn.addEventListener('click', function() {
        $.ajax({
            type: 'post',
            url: "http://localhost:8080/FindMore/Find",
            dataType: "json",
            data: {
                action: 'findNowUser',
            },
            success: function(result) {
                //对应上面获取那些id名输入框的.value
                name = result.datas.nowUser.name;
                number = result.datas.nowUser.count;
                photo.src = result.datas.nowUser.headPortrait;
                institute = result.datas.nowUser.collage;
            }
        })
    })

    // 弹出框
    $('#alter').click(function() {
        $('.alter').show(); //显示修改信息页面
    })

    //点击按钮之后背景色变色
    var down = document.querySelector('.down');
    var btns = down.querySelectorAll('button');
    console.log(btns);
    for (let i = 0; i < btns.length; i++) {
        btns[i].addEventListener('click', function() {
            for (let j = 0; j < btns.length; j++) {
                btns[j].classList.remove('cur');
            }
            this.classList.add('cur');
        })
    }
})