window.addEventListener('load', function () {
    var activeList = this.document.querySelector('.activeList');
    var ul = activeList.querySelector('ul');
    var  type;
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
            type=result.datas.searchType;
            if (!result.code) {
                alert("搜索内容不存在！")
                window.location.href = 'index.html';
            } else {
                if (result.datas.searchType == "act") {
                    for (let i = 0; i < result.datas.size; i++) {
                        //返回的result.data.actList和picList为数组，需要遍历使用
                        var li = document.createElement("li"); //动态创建一个li
                        ul.appendChild(li); //将li插入Ul中
                        var img = document.createElement("img");
                        li.appendChild(img);
                        var p3 = document.createElement("p");
                        li.appendChild(p3);
                        var p1 = document.createElement("p");
                        li.appendChild(p1);
                        var p2 = document.createElement("p");
                        li.appendChild(p2);
                        li.style.float = 'left';
                        li.style.marginLeft = '100px';
                        li.style.marginTop = '100px';
                        img.style.width = "225px";
                        img.style.height = "160px";
                        img.src = result.datas.actPicList[i];
                        p1.innerHTML = result.datas.actList[i].name;
                        if (result.datas.actList[i].status) {
                            p2.innerHTML = "进行中";
                        } else {
                            p2.innerHTML = "已结束";
                        }
                        p2.style.float = 'right';
                    }
                } else {
                    if (result.datas.searchType == 'org') {
                        for (let i = 0; i < result.datas.size; i++) {
                            var li = document.createElement("li"); //动态创建一个li
                            ul.appendChild(li); //将li插入Ul中
                            var img = document.createElement("img");
                            li.appendChild(img);
                            var p3 = document.createElement("p");
                            li.appendChild(p3);
                            var p1 = document.createElement("p");
                            li.appendChild(p1);
                            li.style.float = 'left';
                            li.style.marginLeft = '100px';
                            li.style.marginTop = '100px';
                            img.style.width = "225px";
                            img.style.height = "160px";
                            p1.innerHTML = result.datas.orgList[i].name;
                            img.src = result.datas.orgPicList[i];
                        }
                    }
                }
            }
        }
    })
    ul.addEventListener('click', function (e) {
        var cls = e.target || e.srcElement;//获取当前点击的对象
        // alert(cls.nodeName);
        // var cls = target.className;//获取当前点击对象的class名
        if (cls.nodeName==='IMG') {//如果点击的是加入购物车
            //点击图片跳转到组织详情页面
            // alert(cls.src);
            if(type=='act'){
                $.ajax({
                    type: 'post',
                    dataType: "json",
                    url: "http://localhost:8080/FindMore/Data",
                    // url: "http://rsrs.nat300.top/FindMore/Data",
                    data: {
                        action: 'setClickMatch',
                        clickMatch: cls.src,
                    },
                    success: function (result) {
                        if (result.code) {
                            window.location.href = 'match-details.html';
                        }
                    }
                })
            }else {
            $.ajax({
                type: 'post',
                dataType: "json",
                url: "http://localhost:8080/FindMore/Data",
                // url: "http://rsrs.nat300.top/FindMore/Data",
                data: {
                    action: 'setClickClub',
                    clickClub: cls.src,
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