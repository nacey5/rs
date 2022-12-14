window.addEventListener('load', function() {
    var h2 = document.querySelector('h2'); //获取活动标题
    var act_content = document.querySelector('.act-content'); //获取活动介绍的文本框
    var act_time = document.querySelector('.act-time');
    var ps = act_time.querySelectorAll('p'); //获取时间安排里所有的P
    var sign_method = document.querySelector('.sign-method');
    var code = sign_method.querySelector('img'); //获取二维码图片框
    //查询当前赛事活动的Ajax请求
    $.ajax({
            type: 'post',
            // url: 'http://rsrs.nat300.top/FindMore/Find',
            url: 'http://localhost:8080/FindMore/Find',
            dataType: 'json',
            data: {
                action: "findNowAct",
            },
            success: function(result) {
                // 活动图片 ——>点击的活动图片url
                // 活动名称 result.data.nowAct.name
                h2.innerHTML = result.datas.nowAct.name;
                // 活动时间 result.data.nowAct.time
                // for (let i = 0; i < ps.length; i++) {
                // }
                ps[0].innerHTML = result.datas.nowAct.time;
                act_content.innerHTML = result.datas.nowAct.info;
                // 获取图片
                code.src = result.datas.nowActPic;
            }
        })
        //参赛详情点击事件
    // 点击我要报名之后弹出框
    $('.list').click(function() {
        $('.alter').show(); //显示修改信息页面
    })
    var down = document.querySelector('.down');
    var btns = down.querySelectorAll('button');

    // 点击确定按钮，进行数据的提交，关闭模态框
    function confirm() {
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
        btns[i].addEventListener('click', function() {
            for (let j = 0; j < btns.length; j++) {
                btns[j].classList.remove('cur');
            }
            this.classList.add('cur');

            var timer = setInterval(function() {
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
})