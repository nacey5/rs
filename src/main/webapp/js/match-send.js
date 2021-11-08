window.addEventListener('load', function () {
    var input = document.querySelector(".file"); // 获取选择文件的框
    // var count = document.querySelector(".count"); // 获取选择文件的框
    var activeBox = this.document.querySelector('#activeBox'); //获取报名相关form表单
    var button = document.querySelector('#sumbit'); //获取提交按钮
    //图片不经过服务器回显到页面
    // input.onchange = function () {
    //     var file = this.files[0];
    //     var reader = new FileReader();
    //     // 图片文件转换为base64
    //     reader.readAsDataURL(file);
    //     reader.onload = function () {
    //         // 显示图片
    //         document.querySelector(".file_img").src = this.result;
    //     }
    // }
    //赛事相关的信息上传到服务器
    button.addEventListener('click', function () {
        //赛事相关的信息上传到服务器
        $.ajax({
            type: "post",
            // url: "http://rsrs.nat300.top/FindMore/Activity",
            url: "http://localhost:8080/FindMore/Activity",
            dataType: "json",
            data: {
                action: "addActivity",
                name: $('#Title').val(),
                time: $('#time').val(),
                organizer: $('#count').val(),
                adress: $('#adress').val(),
                joinWay: $('#joinWay').val(),
                level:$('#textSelect option:selected').text(),
                info: $('.textarea').val(),
            },
            success: function(data) {
                alert(data.msg);
                if(data.code){
                    window.location.href='match.html';
                }
            },
            error: function(data) {}
        })
    })
})