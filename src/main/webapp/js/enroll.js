window.addEventListener('load', function () {

    //报名
    button.addEventListener('click', function () {
        //报名相关的信息上传到服务器
        $.ajax({
            type: "post",
            // url: "http://rsrs.nat300.top/FindMore/Activity",
            url: "http://localhost:8080/FindMore/Activity",
            dataType: "json",
            data: {
                action: "enroll",
                name: $('#name').val(),
                num: $('#count').val(),
                phone: $('#phone').val(),
                collage: $('#collage').val(),
                major: $('#major').val(),
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