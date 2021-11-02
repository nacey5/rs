window.addEventListener('load', function () {
    var wrap = this.document.querySelector('.wrap');
    var imgs = wrap.querySelectorAll('img'); //轮播图的图片
    //获取轮播图图片数据
    $.ajax({
        type: 'post',
        // url: 'http://rsrs.nat300.top/FindMore/Picture',
        url: 'http://localhost:8080/FindMore/Picture',
        dataType: 'json',
        data: {
            action: "getMatchAndOrgPic"
        },
        success: function (result) {
            for (let i = 0; i < result.datas.picList.length; i++) {
                imgs[i].src = result.datas.picList[i];
            }
        }
    })

    //轮播图
    var index = 0;
    var j = 0;
    for (j = 0; j < imgs.length; j++) {
        imgs[j].setAttribute('index', j); //给图片添加索引号
    }
    for (let i = 0; i < imgs.length; i++) {
        imgs[i].addEventListener('mouseover', function () {
            for (let j = 0; j < imgs.length; j++) {
                imgs[j].classList.remove('img-active'); //去除图片的img-active
            }
            this.classList.add('img-active');
        })
    }

    //自动播放
    function show() {
        if (index < imgs.length - 1) {
            index++;
            imgs[Number(index - 1)].classList.remove('img-active'); //去除图片的img-active 
            imgs[Number(index)].classList.add('img-active'); //给当前图片添加img-active 
        } else {
            for (var j = 0; j < imgs.length; j++) {
                imgs[j].classList.remove('img-active'); //去除图片的img-active 
            }
            index = 0;
            imgs[Number(index)].classList.add('img-active'); //给当前图片添加img-active 
        }

    }
    var timer = setInterval(function () {
        show();
    }, 4000);


})