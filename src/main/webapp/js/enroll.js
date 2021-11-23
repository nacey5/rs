window.addEventListener('load', function () {

    //报名
    button.addEventListener('click', function () {
        //报名相关的信息上传到服务器
        $.ajax({
            type: "post",
            url: "http://rsrs.nat300.top/FindMore/Activity",
            // url: "http://localhost:8080/FindMore/Activity",
            dataType: "json",
            data: {
                action: "addActivity",
                name: $('#Title').val(),
                time: $('#time').val(),
                organizer: $('#count').val(),
                adress: $('#adress').val(),
                joinWay: $('#joinWay').val(),
                level: $('#textSelect option:selected').text(),
                info: $('.textarea').val(),
            },
            success: function (data) {
                if (data.code) {
                    alert("报名成功！");
                    window.location.reload();
                }
            },
            error: function (data) {
            }
        })
    })
})