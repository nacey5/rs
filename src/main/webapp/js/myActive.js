//我的活动
$.ajax({
    type: 'post',
    url: 'http://rsrs.nat300.top/FindMore/Find',
    dataType: 'json',
    data: {
        'action': "findMyAct",
    },
    success: function (result) {
        //返回的result.data.actList和picList为数组，需要遍历使用

        // 活动图片 result.data.picList[0]
        // 活动名称 result.data.actList[0].name
        // 活动时间 result.data.actList[0].time
        // 活动状态result.data.actList[0].status
    }
})