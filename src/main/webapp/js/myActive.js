window.addEventListener('load', function () {
    //我的活动
    $.ajax({
        type: 'post',
        // url: 'http://rsrs.nat300.top/FindMore/Find',
        url: 'http://localhost:8080/FindMore/Find',
        dataType: 'json',
        data: {
            'action': "findMyAct",
        },
        success: function (result) {
            if (result.code) {
                //返回的result.data.actList和picList为数组，需要遍历使用
                for (let i = 0; i < result.datas.actList.length; i++) {
                    // 活动图片 result.data.picList[0]
                    var src = result.datas.picList[i];
                    // 活动名称 result.data.actList[0].name
                    var name = result.datas.actList[i].name;
                    var time = result.datas.actList[i].time
                    var status;
                    var color;
                    // 活动状态result.data.actList[0].status
                    if (result.datas.actList[i].status ==='true') {
                        status = "进行中";
                        color = "green";
                    } else {
                        status = "已结束";
                        color = "#31baee";
                    }
                    var activeDiv = " <li style='margin-top: 20px;height: 70px;background-color: rgb(116, 203, 191)'  id='act'>\n" +
                        "            <img src=" + src +" alt='' height='60px' width='60px' style='float:left;padding-left: 80px'>\n" +
                        "            <p style=\"float:left;padding-left: 150px;font-size: 28px;width: 280px\">" + name + "</p>\n" +
                        "            <p style=\"float:left;padding-left: 150px\">&nbsp;&nbsp;开始时间<br>" + time + "</p>\n" +
                        "            <p style=\"float:left;padding-left: 200px;font-size: 24px;color:" + color + "\">" + status + "</p>\n" +
                        "        </li>";
                    $("<li></li>").append(activeDiv).appendTo("#activeDiv");
                }
            } else {
                alert("当前用户还没有活动！")
            }
        }
    })
    //某个活动点击事件
    $("#act").click(function () {
        $.post("http://localhost:8080/FindMore/Find", {
            action: "findNowAct",
            title: $(this).val()
        }, function () {
            window.location.href = "match_details.html"
        });
    });
})