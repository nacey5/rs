window.addEventListener('load', function() {
    var wrap = this.document.querySelector('.wrap');
    var imgs = wrap.querySelectorAll('img'); //轮播图的图片
    var ol = document.querySelector('.slide_points'); //获取小圆点所在列表
    var points = ol.getElementsByTagName('li'); //获取小圆点
    //获取轮播图图片数据
    $.ajax({
            type: 'post',
            url: 'http://rsrs.nat300.top/FindMore/Picture',
            dataType: 'json',
            data: {
                action: "getMatchAndOrgPic"
            },
            success: function(result) {
                for (let i = 0; i < imgs.length; i++) {
                    imgs[i].src = result.datas.picList[i];

                }
            }
        })
        //轮播图
    var index = 0;
    var j = 0;
    for (j = 0; j < imgs.length; j++) {
        imgs[j].setAttribute('index', j); //给图片添加索引号
        points[j].setAttribute('index', j); //给小圆点添加索引
    }
    for (let i = 0; i < imgs.length; i++) {
        // 鼠标停留在图片上时
        imgs[i].addEventListener('mouseover', function() {
                for (let j = 0; j < imgs.length; j++) {
                    imgs[j].classList.remove('img-active'); //去除图片的img-active
                    points[j].classList.remove('slide_point_active'); //去除所有小圆点的.slide_point_active
                }
                this.classList.add('img-active');
                index = this.getAttribute('index'); //将图片和小圆点的索引号关联起来
                points[Number(index)].classList.add('slide_point_active'); //给当前小圆点添加slide_point_active
            })
            // 点击小圆点时
        points[i].addEventListener('click', function() {
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

    var timer = setInterval(function() {
        show();
    }, 4000);

    //查询用户
    $.post("", { action: "getUser", from: "login" }, function(data) {
        //返回的用户为空，即没有登录用户
        if (data.user == null) {
            $(".login").html("登录")
                .click(function() {
                    window.location.href = "login.html"
                });
            $(".login").html("注册")
                .click(function() {
                    window.location.href = "register.html"
                });
        } else {
            //返回用户不为空，展示用户头像
            //判断登录为个人用户时
            if () {
                $(".login").hide();
                $(".login-true1").show();
                $("#img").src() = "" //头像路径
            }
            //判断登录为社团组织时
            if () {
                $(".login").hide();
                $(".login-true2").show();
                $("#img").src() = "" //头像路径
            }
            $(".avatar").click(function() {
                window.location.href = "index.html"
            });
        }

        // 赛事活动
        var score = this.document.querySelector('.score');
        var imgs1 = score.querySelectorAll('img');
        $.ajax({
                type: "post",
                url: 'http://rsrs.nat300.top/FindMore/Picture',
                dataType: 'json',
                data: {
                    action: "getIndexMatchPic"
                },
                success: function(result) {
                    for (let i = 1; i < imgs.length; i++) {
                        imgs1[i].src = result.datas.picList[i];

                    }
                }
            })
            // 社团组织
        var club = this.document.querySelector('.club');
        var imgs2 = club.querySelectorAll('img');
        $.ajax({
                type: "post",
                url: 'http://rsrs.nat300.top/FindMore/Picture',
                dataType: 'json',
                data: {
                    action: "getIndexOrgPic"
                },
                success: function(result) {
                    for (let i = 1; i < imgs.length; i++) {
                        imgs2[i].src = result.datas.picList[i];

                    }
                }
            })
            // 模糊查询时动态创建提示框
        var searchA = this.document.querySelector('.searchA');
        // 如果需要创建多个就用for循环
        var li = searchA.createElement("li"); //动态创建li
        searchA.appendChild(li); //将创建的li添加到searchA中
    })
})