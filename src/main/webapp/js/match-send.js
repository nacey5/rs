window.addEventListener('load', function() {
    var input = document.querySelector(".file"); // 获取选择文件的框
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
        // 将用户上传的图片传输到服务器

})