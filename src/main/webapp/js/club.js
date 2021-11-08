window.addEventListener('load', function () {
    var wrap = this.document.querySelector('.wrap');
    var imgs = wrap.querySelectorAll('img'); //轮播图的图片
    var ol = document.querySelector('.slide_points'); //获取小圆点所在列表
    var points = ol.getElementsByTagName('li'); //获取小圆点
    //获取轮播图图片数据
    $.ajax({
        type: 'post',
        url: "http://localhost:8080/FindMore/Picture",
        // url: "http://rsrs.nat300.top/FindMore/Picture",
        dataType: 'json',
        sync: false,
        data: {
            action: "getOrgPicList",
        },
        success: function (result) {
            for (let i = 0; i < imgs.length; i++) {
                imgs[i].src = result.datas.picList[i];
            }
        }
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
                $("#login").html("登录")
                    .click(function () {
                        window.location.href = "login.html"
                    });
                $("#resign").html("注册")
                    .click(function () {
                        window.location.href = "register.html"
                    });
            } else {
                //否则，展示用户头像
                //判断登录为个人用户时
                if (result.datas.nowUser != null) {
                    $(".login").hide();
                    $(".login-true1").show();
                    // $("#img1").src = result.datas.nowUser.headPortrait;//头像路径
                    $('#img1').src = "http://localhost:8080/FindMore/image/user.png";//头像路径
                } else if (result.datas.nowOrg != null) {
                    //否则为社团组织时
                    $(".login").hide();
                    $(".login-true1").show();
                    $('#img1').src = result.datas.nowOrg.headPortrait;//头像路径
                }

            }
        },
    })
    $(".avatar").click(function () {
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/FindMore/LoginOut',
            action: 'loginOut',
            success: function (result) {
                alert(result.msg);
                if (result.code) {
                    window.location.href = "index.html";
                }
            }
        })
    });
    //轮播图
    var index = 0;
    var j = 0;
    for (j = 0; j < imgs.length; j++) {
        imgs[j].setAttribute('index', j); //给图片添加索引号
        points[j].setAttribute('index', j); //给小圆点添加索引
    }
    for (let i = 0; i < imgs.length; i++) {
        // 鼠标停留在图片上时
        imgs[i].addEventListener('mouseover', function () {
            for (let j = 0; j < imgs.length; j++) {
                imgs[j].classList.remove('img-active'); //去除图片的img-active
                points[j].classList.remove('slide_point_active'); //去除所有小圆点的.slide_point_active
            }
            this.classList.add('img-active');
            index = this.getAttribute('index'); //将图片和小圆点的索引号关联起来
            points[Number(index)].classList.add('slide_point_active'); //给当前小圆点添加slide_point_active
        })
        // 点击小圆点时
        points[i].addEventListener('click', function () {
            for (let j = 0; j < imgs.length; j++) {
                imgs[j].classList.remove('img-active'); //去除图片的img-active
                points[j].classList.remove('slide_point_active'); //去除所有小圆点的.slide_point_active
            }
            this.classList.add('slide_point_active');
            index = this.getAttribute('index'); //将图片和小圆点的索引号关联起来
            imgs[Number(index)].classList.add('img-active'); //给当前小圆点添加slide_point_active
        })
    }

    //自动播放
    function show() {
        if (index < imgs.length - 1) {
            index++;
            imgs[Number(index - 1)].classList.remove('img-active'); //去除图片的img-active
            points[Number(index - 1)].classList.remove('slide_point_active'); //去除所有小圆点的.slide_point_active 
            imgs[Number(index)].classList.add('img-active'); //给当前图片添加img-active
            points[Number(index)].classList.add('slide_point_active'); //给当前小圆点添加slide_point_active 
        } else {
            for (var j = 0; j < imgs.length; j++) {
                imgs[j].classList.remove('img-active'); //去除图片的img-active 
                points[j].classList.remove('slide_point_active'); //去除所有小圆点的.slide_point_active
            }
            index = 0;
            imgs[Number(index)].classList.add('img-active'); //给当前图片添加img-active
            points[Number(index)].classList.add('slide_point_active'); //给当前小圆点添加slide_point_active 
        }
    }

    var timer = setInterval(function () {
        show();
    }, 4000);

    //获取社团的图片
    var club = this.document.querySelector('.club-activity');
    var imgs1 = club.querySelectorAll('img');
    var p = document.querySelector('.p');
    var ps = club.querySelectorAll('.p2');
    var change = club.querySelector('.change');
    //获取轮播图下方图片数据
    $.ajax({
        type: 'post',
        url: "http://localhost:8080/FindMore/Picture",
        // url: "http://rsrs.nat300.top/FindMore/Picture",
        dataType: 'json',
        sync:false,
        data: {
            action: "getOrgList",
        },
        success: function (result) {
            for (let i = 0; i < imgs1.length; i++) {
                imgs1[i].src = result.datas.picList[i]; //图片渲染
                ps[i].innerHTML = result.datas.infoList[i];  //补充完整文字渲染
            }
        }
    })
    //点击“换一批”
    change.addEventListener('click', function () {
        $.ajax({
            type: 'post',
            url: "http://localhost:8080/FindMore/Picture",
            dataType: 'json',
            data: {
                action: "getOrgList",
            },
            success: function (result) {
                for (let i = 0; i < imgs1.length; i++) {
                    imgs1[i].src = result.datas.picList[i]; //图片渲染
                    ps[i].innerHTML = result.datas.infoList[i];  //补充完整文字渲染
                }
            }
        })
    })
    //点击图片跳转到组织详情页面
    var imgList = document.querySelectorAll('img');
    for (let i = 0; i < imgList.length; i++) {
        imgList[i].addEventListener('click', function () {
            $.ajax({
                type: 'post',
                dataType: "json",
                url: "http://localhost:8080/FindMore/Data",
                // url: "http://rsrs.nat300.top/FindMore/Data",
                data: {
                    action: "setClickClub",
                    clickClub: imgList[i].src,
                },
                success: function (result) {
                    if (result.code) {
                        window.location.href = 'club-details.html';
                    }
                }
            })
        })
    }

})