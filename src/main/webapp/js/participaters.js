window.addEventListener('load', function () {
    //参赛者
    $.ajax({
        type: 'post',
        url: 'http://rsrs.nat300.top/FindMore/Find',
        // url: 'http://localhost:8080/FindMore/Find',
        dataType: 'json',
        data: {
            'action': "findParticipaters",
        },
        success: function (result) {
            if (result.code) {
                for (let i = 0; i < result.datas.parList.length; i++) {
                    let src = result.datas.userList[i].headPortrait;
                    let name = result.datas.userList[i].username;
                    let major = result.datas.userList[i].major;
                    let count = result.datas.userList[i].count;
                    let parDiv = "<div style=\"height: 70px;background-color:rgb(116, 203, 191);border-radius:15px 15px 15px 15px;\n\">\n" +
                        "<img src= " + src + " alt='' height='60px' width='60px' style='float:left;padding-left: 80px'>\n" +
                        "<p style=\"height: 70px;padding-top:15px;float:left;padding-left: 130px;font-size: 28px;width: 280px\">" + name + "</p>\n" +
                        "<p style=\"width:288px;height: 70px;padding-top:15px;float:left;padding-left: 40px;font-size: 24px\">" + major + "</p>\n" +
                        "<p style=\"height: 70px;padding-top:15px;float:left;padding-left: 100px;color: #31baee;font-size: 24px\">" + count + "</p>\n" +
                        "</div>";
                    $("<div id='par'></div>").append(parDiv).appendTo("#parDiv");
                }
            } else {
                alert("当前活动还没有参赛者！")
            }
        }
    })
    //参赛者单击事件
    // $("#par").live("click", function () {
    //     $.post("http://localhost:8080/FindMore/", {
    //         action: "findBlog",
    //         title: $(this).val()
    //     }, function () {
    //         window.location.href = "person_center.html"
    //     });
    // });
})