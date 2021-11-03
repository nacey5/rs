
//______________________________________社团组织主页面——————————————————————————
//******************************************************轮播图
$.ajax({
    type: 'post',
    url: 'http://rsrs.nat300.top/rs/Picture',
    dataType: 'json',
    data: {
        'action': "getActPic",
    },
    success: function (result) {
      //返回的result.data.picList为数组，需要遍历使用

    }
})
//*******************************************************换一批
$.ajax({
    type: 'post',
    url: 'http://rsrs.nat300.top/rs/Activity',
    dataType: 'json',
    data: {
        'action': "getActList",
    },
    success: function (result) {

        //返回的result.data.actList为数组，需要遍历使用
        // 活动图片 result.data.actList[0].pic
        // 活动信息result.data.actList[0].info

    }
})
//****************************************************赛事发布
$.ajax({
    type: 'post',
    url: 'http://rsrs.nat300.top/rs/Activity',
    dataType: 'json',
    data: {
        'action': "addActivity",
    },
    success: function (result) {
        //发布成功
        if (result.code) {

        } else {
            //发布失败
        }
    }
})
//******************************************************我的活动
$.ajax({
    type: 'post',
    url: 'http://rsrs.nat300.top/rs/Activity',
    dataType: 'json',
    data: {
        'action': "getUserActList",
    },
    success: function (result) {
        //返回的result.data.actList为数组，需要遍历使用
        // 活动图片 result.data.actList[0].pic
        // 活动名称 result.data.actList[0].name
        // 活动时间 result.data.actList[0].time
        // 活动状态result.data.actList[0].status
    }
})
//*******************************************************搜索
//搜索框中的内容
var searchText;

$.ajax({
    type: 'post',
    url: 'http://rsrs.nat300.top/rs/Search',
    dataType: 'json',
    data: {
        'action': "search",
        'searchText': JSON.stringify(searchText),
    },
    success: function (result) {
        //返回活动数组
        if (result.searchType == "activity") {
//返回的result.data.actList为数组，需要遍历使用
            // 活动图片 result.data.actList[0].pic
            // 活动名称 result.data.actList[0].name
            // 活动时间 result.data.actList[0].time
            // 活动状态result.data.actList[0].status
        } else if (result.searchType == "organzier") {
//返回的result.data.orgList为数组，需要遍历使用
            // 组织图片 result.data.orgList[0].pic
            // 组织名称 result.data.orgList[0].name
        }
    }
})