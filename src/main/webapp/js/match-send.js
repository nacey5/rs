window.addEventListener('load', function () {
    var input = document.querySelector(".file"); // 获取选择文件的框
    // var count = document.querySelector(".count"); // 获取选择文件的框
    var activeBox = this.document.querySelector('#activeBox'); //获取报名相关form表单
    var button = document.querySelector('#sumbit'); //获取提交按钮
    var submit = document.querySelector('#file_submit'); //获取提交按钮
    //图片不经过服务器回显到页面
    input.onchange = function () {
        var file = this.files[0];
        var reader = new FileReader();
        // 图片文件转换为base64
        reader.readAsDataURL(file);
        reader.onload = function () {
            // 显示图片
            document.querySelector(".file_img").src = this.result;
        }
    }
    // 将用户上传的图片传输到服务器
    var formData1 = new FormData();
    function fileSubmit() {
        formData1.append('file', input.files[0]);
        alert(formData1);
        let a = new Promise((resolve, reject) => {
            let xhr = new XMLHttpRequest();
            xhr.open("post", "http://rsrs.nat300.top/FindMore/Upload", false);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && (xhr.status >= 200 && xhr.status < 300)) {
                    resolve(JSON.parse(xhr.response));
                } else {
                    reject(xhr.readyState);
                }
            }
            xhr.send(formData1);
        });
        a.then(value => {
            if (value.code) {
                alert("上传成功");
                window.location.href = "match.html";
            } else if(value.msg!='无图片上传'){
                alert("上传失败");
                window.location.reload();
            }
        }, reason => {
            console.log(reason);
        });
    }
    //赛事相关的信息上传到服务器
    button.addEventListener('click', function () {
        //赛事相关的信息上传到服务器
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
                //图片上传
                fileSubmit();
                if (data.code) {
                    window.location.href = 'match.html';
                }
            },
            error: function (data) {
            }
        })
    })
})