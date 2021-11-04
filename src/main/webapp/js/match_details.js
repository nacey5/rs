//查询当前赛事活动的Ajax请求
$.ajax({
    type: 'post',
    url: 'http://rsrs.nat300.top/FindMore/Find',
    dataType: 'json',
    data: {
        'action': "findNowAct",
        'nowActUrl':'',//点击的活动图片的url
    },
    success: function (result) {
        // 活动图片 ——>点击的活动图片url
        // 活动名称 result.data.nowAct.name
        // 活动时间 result.data.nowAct.time
        // 活动状态result.data.nowAct.status
    }
})