window.addEventListener('load', function () {
//搜索框中的内容
    var searchText = document.querySelector('#searchInput');
// 模糊查询时动态创建提示框
    var searchA = this.document.querySelector('#searchA');
// 如果需要创建多个就用for循环
    var li = document.createElement("li"); //动态创建li
    searchText.oninput = function () {
        tip();
    }

    //隐藏提示框
    function searchDivOff() {
        $('#searchA').css('display', 'none');
    }

    function tip() {
        let keyVal = $.trim(searchText.value);
        //如果搜索框输入为空
        if (keyVal == null || keyVal == "") {
            searchDivOff();
        } else {
            //显示搜索提示框
            $('#searchA').css('display', 'block');
            //清空搜索提示框中的内容
            $('#searchA').html("");
            $.ajax({
                type: 'post',
                // url: 'http://rsrs.nat300.top/FindMore/Search',
                url: 'http://localhost:8080/FindMore/Search',
                dataType: 'json',
                data: {
                    action: 'findSearchTips',
                    'searchText': keyVal,
                },
                success: function (result) {
                    // alert(result.code);
                    if (result.code) {
                        // result.datas.strings 就是查询到的字符数组
                        for (let i = 0; i < result.datas.strings.length; i++) {
                            $('#searchA').append("<li>" + result.datas.strings[i] + "</li>");
                        }
                    }
                }
            })
        }

        //点击提示框自动填充到搜索框
        $(document).on("click", "#searchA>li", function () {
            $('#searchInput').val($(this).text());
            searchDivOff();
        })
//         $("#sl").click(function () {
//             alert("1");
//             $('#searchInput').val($(this).text());
//             searchDivOff();
//         })
    }

    $('#search').click(function () {
        $.ajax({
            type: 'post',
            // url: 'http://rsrs.nat300.top/FindMore/Search',
            url: 'http://localhost:8080/FindMore/Search',
            dataType: 'json',
            data: {
                'action': "search",
                'searchText': searchText.value,
            },
            success: function (result) {
                if (result.code) {
                    window.location.href = ('search.html');
                }
            }
        })
    })
})
