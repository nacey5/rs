window.addEventListener('load', function () {
    var activeList = this.document.querySelector('.activeList');
    var type;
    //搜索结果
    $.ajax({
        type: 'post',
        // url: 'http://rsrs.nat300.top/FindMore/Search',
        url: 'http://localhost:8080/FindMore/Search',
        dataType: 'json',
        data: {
            'action': "findSearch",
        },
        success: function (result) {
            type = result.datas.searchType;
            if (!result.code) {
                alert("搜索内容不存在！")
                window.location.href = 'index.html';
            } else {
                for (let i = 0; i < result.datas.size; i++) {
                    //返回的result.data.objList,infoList和picList为数组，需要遍历使用
                    var title = result.datas.objList[i].name;
                    var src = result.datas.picList[i];
                    var info = result.datas.infoList[i];
                    if (info == null) {
                        info = "";
                    } else {
                        info = info ? (info.length > 20 ? (info.substring(0, 20)) + "..." : info) : info;
                    }
                    var li = "<li style=\"float: left\">\n" +
                        "     <img src=" + src + " alt=\"\" style=\"height: 80px;width: 80px\">\n" +
                        "     <div id='infoDiv'>\n" +
                        "     <p class=\"title\">" + title + "</p>\n" +
                        "     <p class=\"search-con\" id=\"content\">" + info + "</p>\n" +
                        "     </div>\n" +
                        "     </li>";

                    $("<ul></ul>").append(li).appendTo('.left');
                }
            }
        }
    })
    // $('ul').addEventListener('click', function (e) {
    $(document).on("click", ".left>ul", function (e) {
        var cls = e.target;//获取当前点击的对象
        // alert(cls.nodeName);
        // alert(cls.parentNode);
        // alert(cls.parentNode.querySelector('img').src);
        // var cls = target.className;//获取当前点击对象的class名
        var isP = cls.nodeName === 'P';
        var isIMG = cls.nodeName === 'IMG';
        if (isP || isIMG) {
            var src;
            if (isP) {
                src = cls.parentNode.parentNode.querySelector('img').src;
            } else {
                src = cls.parentNode.querySelector('img').src;
            }
            //点击图片跳转到组织详情页面
            // alert(src);
            if (type == 'act') {
                $.ajax({
                    type: 'post',
                    dataType: "json",
                    url: "http://localhost:8080/FindMore/Data",
                    // url: "http://rsrs.nat300.top/FindMore/Data",
                    data: {
                        action: 'setClickMatch',
                        clickMatch: src,
                    },
                    success: function (result) {
                        if (result.code) {
                            window.location.href = 'match-details.html';
                        }
                    }
                })
            } else {
                $.ajax({
                    type: 'post',
                    dataType: "json",
                    url: "http://localhost:8080/FindMore/Data",
                    // url: "http://rsrs.nat300.top/FindMore/Data",
                    data: {
                        action: 'setClickClub',
                        clickClub: src,
                    },
                    success: function (result) {
                        if (result.code) {
                            window.location.href = 'club-details.html';
                        }
                    }
                })
            }
        }
    })
})

//创建元素的页面
function create() {
    var li = ul.createElement("li"); //动态创建一个li
    ul.appendChild(li); //将li插入Ul中
    var img = li.createElement("img");
    li.appendChild(img);
    var p1 = li.createElement("p");
    li.appendChild(p1);
    var p2 = li.createElement("p");
    li.appendChild(p2);
    img.style.width = "60px";
    img.style.height = "40px";
    img.style.float = 'right';
    p1.style.float = 'right';
}