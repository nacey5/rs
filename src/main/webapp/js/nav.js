window.addEventListener('load', function () {
    var nav = this.document.querySelector('.nav');
    var lis = nav.querySelectorAll('li');
    for (let i = 0; i < lis.length; i++) {
        lis[i].addEventListener('click', function () {
            for (let j = 0; j < lis.length; j++) {
                lis[j].classList.remove ('cur') ;//去除图片的img-active
            }
            this.classList.add('cur');
        })
    }
    //查询用户
    $.ajax({
        type: "post",
        url: "http://localhost:8080/FindMore/Find",
        // url: "http://rsrs.nat300.top/FindMore/Find",
        dataType: "json",
        sync: false,
        data: {action: "findUserOrOrg"},
        success: function (result) {
            //返回的code为false，即没有登录用户
            if (!result.code) {
                $(".login").show();
                $(".login-true1").hide();
                $("#login").html("个人入口")
                    .click(function () {
                        window.location.href = "personResign.html"
                    });
                $("#resign").html("社团入口")
                    .click(function () {
                        window.location.href = "clubResign.html"
                    });
                // <span><a href="personResign.html" target=“_parent”>个人入口</a>&nbsp;|</span>
            // <span><a href="clubResign.html" target=“_parent”>社团入口</a></span>
            } else {
                //否则，展示用户头像
                //判断登录为个人用户时
                if (result.datas.nowUser != null) {
                    $(".login").hide();
                    $(".login-true1").show();
                    $("#img1").src = result.datas.nowUser.headPortrait == null ? "http://localhost:8080/FindMore/image/user.png" : result.datas.nowUser.headPortrait;//头像路径
                    // $('#img1').src = "http://localhost:8080/FindMore/image/user.png";//头像路径
                } else if (result.datas.nowOrg != null) {
                    //否则为社团组织时
                    $(".login").hide();
                    $(".login-true1").show();
                    $('#img1').src = result.datas.nowOrg.headPortrait == null ? "http://localhost:8080/FindMore/image/org.png" : result.datas.nowOrg.headPortrait;//头像路径
                }

            }
        },
    })
})