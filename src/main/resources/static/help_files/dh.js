function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");

    if (arr = document.cookie.match(reg))

        return unescape(arr[2]);
    else
        return null;
}
var dqbm = getCookie("qd8home");
if (dqbm != "") {
    var dh = "<a href=\"http://" + dqbm + ".qd8.com.cn/fangwu/\" class=\"topdh\" target=\"_blank\">房产</a>";
    dh += "<a href=\"http://" + dqbm + ".qd8.com.cn/tongcheng/\" class=\"topdh\" target=\"_blank\">活动</a>";
    dh += "<a href=\"http://" + dqbm + ".qd8.com.cn/shenghuo/\" class=\"topdh\" target=\"_blank\">生活</a>";
    dh += "<a href=\"http://" + dqbm + ".qd8.com.cn/shangwu/\" class=\"topdh\" target=\"_blank\">商务</a>";
    dh += "<a href=\"http://" + dqbm + ".qd8.com.cn/qiuzhi/\" class=\"topdh\" target=\"_blank\">求职</a>";
    dh += "<a href=\"http://" + dqbm + ".qd8.com.cn/jianzhi/\" class=\"topdh\" target=\"_blank\">兼职</a>";
    dh += "<a href=\"http://" + dqbm + ".qd8.com.cn/zhaopin/\" class=\"topdh\" target=\"_blank\">招聘</a>";
    dh += "<a href=\"http://" + dqbm + ".qd8.com.cn/wupin/\" class=\"topdh\" target=\"_blank\">二手</a>";
    dh += "<a href=\"http://" + dqbm + ".qd8.com.cn/chongwu/\" class=\"topdh\" target=\"_blank\">宠物</a>";
    dh += "<a href=\"http://" + dqbm + ".qd8.com.cn/cheliang/\" class=\"topdh\" target=\"_blank\">车辆</a>";
    document.write(dh)
}
else {
    var dh = "<a href=\"/fangwu/\" class=\"topdh\" target=\"_blank\">房产</a>";
    dh += "<a href=\"/tongcheng/\" class=\"topdh\" target=\"_blank\">活动</a>";
    dh += "<a href=\"/shenghuo/\" class=\"topdh\" target=\"_blank\">生活</a>";
    dh += "<a href=\"/shangwu/\" class=\"topdh\" target=\"_blank\">商务</a>";
    dh += "<a href=\"/qiuzhi/\" class=\"topdh\" target=\"_blank\">求职</a>";
    dh += "<a href=\"/jianzhi/\" class=\"topdh\" target=\"_blank\">兼职</a>";
    dh += "<a href=\"/zhaopin/\" class=\"topdh\" target=\"_blank\">招聘</a>";
    dh += "<a href=\"/wupin/\" class=\"topdh\" target=\"_blank\">二手</a>";
    dh += "<a href=\"/chongwu/\" class=\"topdh\" target=\"_blank\">宠物</a>";
    dh += "<a href=\"/cheliang/\" class=\"topdh\" target=\"_blank\">车辆</a>";
    document.write(dh)
}