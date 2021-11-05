window.addEventListener('load', function () {
    var wrap = this.document.querySelector('.wrap');
    var imgs = wrap.querySelectorAll('img'); //轮播图的图片
    var ol = document.querySelector('.slide_points'); //获取小圆点所在列表
    var points = ol.getElementsByTagName('li'); //获取小圆点
    //获取轮播图图片数据
    $.ajax({
        type: 'post',
        url: "http://localhost8080/FindMore/Picture",
        // url: "http://rsrs.nat300.top/FindMore/Picture",
        dataType: 'json',
        sync:false,
        data: {
            action: "getMatchPicList"
        },
        success: function (result) {
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
    // 体育赛事获取数据
    var sports = this.document.querySelector('.sports');
    var imgs1 = sports.querySelectorAll('img');
    $.ajax({
        type: 'post',
        // url: "http://localhost8080/FindMore/Picture",
        url: "http://rsrs.nat300.top/FindMore/Picture",
        dataType: 'json',
        sync:false,
        data: {
            action: "getMatchList",
            matchType:"sport"
        },
        success: function (result) {
            for (let i = 0; i < imgs1.length; i++) {
                imgs1[i].src = result.datas.picList[i];
                ps[i].innerHTML = result.datas.infoList[i];  //补充完整文字渲染
                // text=result.datas.infoList[i];//文字渲染，text可更改
            }
        }
    })
    // 学术活动获取数据
    var academic = this.document.querySelector('.academic');
    var imgs2 = academic.querySelectorAll('img');
    var ps = club.querySelectorAll('p');
    $.ajax({
        type: 'post',
        // url: "http://localhost8080/FindMore/Picture",
        url: "http://rsrs.nat300.top/FindMore/Picture",
        dataType: 'json',
        sync:false,
        data: {
            action: "getMatchList",
            matchType:"knowledge"
        },
        success: function (result) {
            for (let i = 0; i < imgs2.length; i++) {
                imgs2[i].src = result.datas.picList[i];
                // text=result.datas.infoList[i];//文字渲染，text可更改
                ps[i].innerHTML = result.datas.infoList[i];
            }
        }
    })
    // 志愿活动获取数据
    var voluntary = this.document.querySelector('.voluntary');
    var imgs3 = voluntary.querySelectorAll('img');
    $.ajax({
        type: 'post',
        // url: "http://localhost8080/FindMore/Picture",
        url: "http://rsrs.nat300.top/FindMore/Picture",
        dataType: 'json',
        sync:false,
        data: {
            action: "getMatchList",
            matchType:"volunteering"
        },
        success: function (result) {
            for (let i = 0; i < imgs3.length; i++) {
                imgs3[i].src = result.datas.picList[i];
                ps[i].innerHTML = result.datas.infoList[i];  //补充完整文字渲染
                // text=result.datas.infoList[i];//文字渲染，text可更改
            }
        }
    })
})