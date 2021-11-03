window.addEventListener('load', function() {
    var input = document.querySelector(".file"); // 获取选择文件的框
    var scoreBox = this.document.querySelector('#scoreBox'); //获取赛事相关form表单
    var activeBox = this.document.querySelector('#activeBox'); //获取报名相关form表单
    var button = activeBox.querySelector('button'); //获取提交按钮
    //图片不经过服务器回显到页面
    input.onchange = function() {
            var file = this.files[0];
            var reader = new FileReader();
            // 图片文件转换为base64
            reader.readAsDataURL(file);
            reader.onload = function() {
                // 显示图片
                document.querySelector(".file_img").src = this.result;
            }
        }
        //赛事相关的信息上传到服务器
    var formData = new FormData();
    formData.append('file', $("#scoreBox").input);
    $.ajax({
            url: "http://rsrs.nat300.top/FindMore/addActivity",
            type: "post",
            data: formData,
            processData: false, // 告诉jQuery不要去处理发送的数据
            contentType: false, // 告诉jQuery不要去设置Content-Type请求头
            dataType: 'text',
            success: function(data) {
                console.log(data);
            },
            error: function(data) {}
        })
        // 将用户上传的文字介绍和图片介绍传输到服务器
    var formData1 = new FormData();
    formData1.append('file', $(".textarea").files);
    formData1.append('file', input.files[0]);
    $.ajax({
        url: "http://rsrs.nat300.top/FindMore/addActivity",
        type: "post",
        data: formData1,
        processData: false, // 告诉jQuery不要去处理发送的数据
        contentType: false, // 告诉jQuery不要去设置Content-Type请求头
        dataType: 'text',
        success: function(data) {
            console.log(data);
        },
        error: function(data) {}
    })

})