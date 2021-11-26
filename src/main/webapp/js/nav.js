window.addEventListener('load', function () {
    var nav = this.document.querySelector('.nav');
    var lis = nav.querySelectorAll('li');
    // for (let i = 0; i < lis.length; i++) {
    //     lis[i].addEventListener('click', function () {
    //         for (let j = 0; j < lis.length; j++) {
    //             lis[j].classList.remove ('cur') ;//去除图片的img-active
    //         }
    //         this.classList.add('cur');
    //     })
    // }
    //获取div下面所有的a标签（返回节点对象）
    var myNav =nav.querySelectorAll("a");
    //获取当前窗口的url
    var myURL = document.location.href;
    //循环div下面所有的链接，
    for(var i=1;i<myNav.length;i++){
        //获取每一个a标签的herf属性
        var links = myNav[i].getAttribute("href");
        // var myURL = document.location.href;
        //查看div下的链接是否包含当前窗口，如果存在，则给其添加样式
        if(myURL.indexOf(links) !== -1){
            myNav[i].className="active";
            myNav[0].className="";
        }
    }
    //退出
    var sign_out = this.document.querySelector('.avatar');
    sign_out.addEventListener('click', function() {
        $.ajax({
            type: "post",
            url: "http://localhost:8080/FindMore/LoginOut",
            // url: 'http://rsrs.nat300.top/FindMore/LoginOut',
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
                    var src= result.datas.nowUser.headPortrait == null ? "http://localhost:8080/FindMore/image/user.png" : result.datas.nowUser.headPortrait;
                    $("#img1").src = result.datas.nowUser.headPortrait == null ? "http://localhost:8080/FindMore/image/user.png" : result.datas.nowUser.headPortrait;//头像路径
                    // $('#img1').src = "http://localhost:8080/FindMore/image/user.png";//头像路径
                } else if (result.datas.nowOrg != null) {
                    //否则为社团组织时
                    $(".login").hide();
                    $(".login-true1").show();
                    var src= result.datas.nowOrg.headPortrait == null ? "http://localhost:8080/FindMore/image/org.png" : result.datas.nowOrg.headPortrait;
                    $('#img1').src = result.datas.nowOrg.headPortrait == null ? "http://localhost:8080/FindMore/image/org.png" : result.datas.nowOrg.headPortrait;//头像路径
                }
            }
        },
    })
})