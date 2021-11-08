window.addEventListener('load', function () {
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
            action: "findNowOrg",
        },
        success: function (result) {
            // 活动图片 ——>点击的活动图片url
            // 活动名称 result.data.nowAct.name
            h2.innerHTML = result.datas.nowOrg.name;
            // 活动时间 result.data.nowAct.time
            // for (let i = 0; i < ps.length; i++) {
            // }
            act_content.innerHTML = result.datas.nowOrgInfo;
            // 获取图片
            code.src = result.datas.nowOrgPic;
        }
    })
})