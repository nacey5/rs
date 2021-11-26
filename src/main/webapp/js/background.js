window.addEventListener('load', function () {
    // var hours = new Date().getHours();
    // var s = new Date().toLocaleTimeString();
    $.ajax({
        type: 'post',
        // url: 'http://rsrs.nat300.top/FindMore/Find',
        url: 'http://localhost:8080/FindMore/Find',
        dataType: 'json',
        data: {
            'action': "findTime",
        },
        success: function (result) {
            var hours = result.datas.hours;
            if (hours < 11 && hours > 5) {
                $(".loginBox").css("backgroundImage", "url(http://localhost:8080/FindMore/image/loginBg/morning.jpg)");
                $(".resignBox").css("backgroundImage", "url(http://localhost:8080/FindMore/image/loginBg/morning.jpg)");
            }
            if (hours < 18 && hours >= 11) {
                $(".loginBox").css("backgroundImage", "url(http://localhost:8080/FindMore/image/loginBg/noon.jpg)");
                $(".resignBox").css("backgroundImage", "url(http://localhost:8080/FindMore/image/loginBg/noon.jpg)");
            }
            if (hours >= 18 || hours <= 5) {
                $(".loginBox").css("backgroundImage", "url(http://localhost:8080/FindMore/image/loginBg/night.jpg)");
                $(".resignBox").css("backgroundImage", "url(http://localhost:8080/FindMore/image/loginBg/night.jpg)");
            }
        }
    });
})