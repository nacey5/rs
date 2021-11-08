window.addEventListener('load', function () {
    //我的活动
    $.ajax({
        type: 'post',
        url: 'http://rsrs.nat300.top/FindMore/Find',
        // url: 'http://localhost:8080/FindMore/Find',
        dataType: 'json',
        data: {
            'action': "findMyAct",
        },
        success: function (result) {
            if (result.code) {
                //返回的result.data.actList和picList为数组，需要遍历使用
                for (let i = 0; i < result.datas.actList.length; i++) {
                    create();
                    // 活动图片 result.data.picList[0]
                    img.src = result.datas.picList[i];
                    // 活动名称 result.data.actList[0].name
                    p1= result.datas.actList[i].name;
                    // 活动时间 result.data.actList[0].time
                    // 活动状态result.data.actList[0].status
                    if (result.datas.actList[0].status) {
                        p2.innerHTML = "进行中";
                    } else {
                        p2.innerHTML = "已结束";
                    }
                }
            } else {
                alert("当前用户还没有活动！")
            }
        }
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
    }
})