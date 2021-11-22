//搜索框中的内容
var searchText = document.querySelector('#searchInput');
// 模糊查询时动态创建提示框
var searchA = this.document.querySelector('.searchA');
// 如果需要创建多个就用for循环
// var li = document.createElement("li"); //动态创建li

function tip(){
    $.ajax({
        type: 'post',
        url: 'http://rsrs.nat300.top/FindMore/Search',
        // url: 'http://localhost:8080/FindMore/Search',
        dataType: 'json',
        data: {
            action: 'findSearchTips',
            'searchText': $("#searchText").val(),
        }, success: function (result) {
            alert($("#searchText").val());
            alert(result.datas.strings);
            if (result.code) {
                // result.datas.strings 就是查询到的字符数组
                for (let s in result.datas.strings) {
                    // s 就是查询到的字符
                    var p = document.createElement("p"); //动态创建li
                    p.innerHTML = s;
                    searchA.append(p);
                }
            }
        }
    })
}
document.querySelector('#search').addEventListener("click", function () {
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