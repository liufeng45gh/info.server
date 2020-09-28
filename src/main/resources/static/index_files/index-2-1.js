var c = 0;
show1 = function (id, name) {
    $("#sel").html("").html(name);
    c = id;
};
show = function () {
    $("#category_list").slideToggle(300);
};
hid = function () {
    $("#category_list").slideUp(300);
};
var timeCount = 200;
s = function () {
    document.getElementById("xx").className = 'xxlock';
    if (timeCount == 200) {
        $.post("/ajax/liebiao.ashx", {
                caozuotype: "getLiShiJiLu"
            },
            function(result) {
                if (result == "") $("#xx").html("<ul><li>&nbsp;&nbsp;&nbsp;暂无记录</li></ul>");
                else $("#xx").html("<ul>" + result + "</ul>");
            });
    }
    timeCount = 5000;
};
h = function () {
    document.getElementById("xx").className = 'xx';
};
$(document).ready(function () {
    $("#menu,#history").css("display", "block");
    $("#div0,#div1,#div2,#div4").hover(function () {
        $(this).css({
            "border": "solid 1px #D4D3D3"
        });
    },
    function () {
        $(this).css({
            "border": "solid 1px #ffffff",
            "border-right": "solid 1px #D8F8C8"
        });
    });
    $("#div3").hover(function () {
        $(this).css({
            "border": "solid 1px #D4D3D3"
        });
    },
    function () {
        $(this).css({
            "border": "solid 1px #ffffff"
        });
    });
    $("#history").hover(function () {
        $(this).css({
            "border": "solid 1px #D4D3D3",
            "border-bottom-width": "0px",
            "background-color": "#ffffff"
        });
        if (navigator.appName == "Microsoft Internet Explorer") {
            if (navigator.appVersion.match(/7./i) == '7.') {
                $("#category_list").css("left", document.getElementById("sel").getBoundingClientRect().left + 68);
            } else {
                $("#category_list").css("left", document.getElementById("sel").getBoundingClientRect().left + 70);
            }
        } else {
            
            var w123 = screen.width;
            if (w123 <= 1024) {
                $("#xx").css("left", document.getElementById("history").getBoundingClientRect().left + 262);
            } else {
                switch (w123) {
                    case 1024:
                        $("#xx").css("left", document.getElementById("history").getBoundingClientRect().left + 262);
                        break;
                    default:
                        $("#xx").css("left", document.getElementById("history").getBoundingClientRect().left + 70);
                }
            }
            
        }
        s();
    },
    function () {
        $(this).css({
            "border": "solid 0px #f4f4f4",
            "background-color": "#f4f4f4",
            "border-bottom": "solid 1px #ffffff"
        });
        h();
    });
    $("#xx").hover(function () {
        if (navigator.appName == "Microsoft Internet Explorer") {
            if (navigator.appVersion.match(/7./i) == '7.') {
                $("#category_list").css("left", document.getElementById("sel").getBoundingClientRect().left + 68);
            } else {
                $("#category_list").css("left", document.getElementById("sel").getBoundingClientRect().left + 70);
            }
        } else {
            var w123 = screen.width;
            if (w123 <= 1024) {
                $("#xx").css("left", document.getElementById("history").getBoundingClientRect().left + 260);
            } else {
                switch (w123) {
                    case 1024:
                        $("#xx").css("left", document.getElementById("history").getBoundingClientRect().left + 260);
                        break;
                    default:
                        $("#xx").css("left", document.getElementById("history").getBoundingClientRect().left + 70);
                }
            }
        }
        $("#history").css({
            "border": "solid 1px #f4f4f4",
            "border-bottom-width": "0px",
            "background-color": "#ffffff"
        });
        s();
    },
    function () {
        $("#history").css({
            "border-width": "0px",
            "background-color": "#f4f4f4",
            "border-bottom": "solid 1px #ffffff"
        });
        h();
    });
    if (navigator.appName == "Microsoft Internet Explorer") {
        if (navigator.appVersion.match(/7./i) == '7.') {
            $("#category_list").css("left", document.getElementById("sel").getBoundingClientRect().left + 68);
        } else {
            $("#category_list").css("left", document.getElementById("sel").getBoundingClientRect().left + 70);
        }
    } else {
        $("#category_list").css("left", document.getElementById("sel").getBoundingClientRect().left + 70);
    }
    var w = screen.width;
    if (w == 1024) {
        //$(".city").css("width", "33%");
        $("#key").css("width", "65%");
        //$(".logo").css("width", "25.5%");
        //$("#xx").css("margin-right", "10px");
    } else if (w == 1280) {
        //$(".city").css("width", "33%");
        $("#key").css("width", "68%");
        //$(".logo").css("width", "22%");
    } else {
        //$(".city").css("width", "33%");
        //$(".logo").css("width", "20%");
        $("#key").css("width", "67%");
    }
    cklg();
});
cklg = function () {
    var url = "/users/ajax.ashx";
    $.post(url, {
            "_type": "cklg"
        },
        function(data) {
            var jd = eval("(" + data + ")");
            if (document.getElementById("ctl00_topline1_1")) {
                $("#ctl00_topline1_1").html(jd.rtnmsg);
            }
            if (document.getElementById("topline1_1")) {
                $("#topline1_1").html(jd.rtnmsg);
            }
            if (document.getElementById("login")) {
                $("#login").html(jd.rtnindex);
            }
        },
        "text");
};
subkey = function () {
    var result = c;
    var keywords = $("#key").val();
    if (keywords == '') {
        alert('请输入查询内容');
    } else {
        $.pub.ajaxs.p("/search/search.ashx", keywords, c, '');
    }
};
flnull = function () {
    alert('请选择分类');
    return false;
};
flok = function () {
    return true;
};
function nofind(img) {
    img.src = "/images/wutu_big.gif";
    img.onerror = null;
};
var _bx = [],
_html = '<style>textarea{color:#F43939}</style><div style="right: -350px;" class="fixedBtn noprint" id="loginForm">';
_html += '<a rel="nofollow" href="###" class="feedback" title="欢迎给快点8提问题和提建议～"></a>';
_html += '<a style="display: none;" href="#top" class="top" title="回到顶部"></a>';
_html += '<div style="display: none;" class="feedbackTips fb-open hide green">';
_html += '反馈已发送！';
_html += '</div>';
_html += '<div class="feedbackCnt">';
_html += '<h3><cite class="red">* </cite>您对快点8的意见和建议：</h3>';
_html += '<textarea name="feedbackCnt" placeholder="请在此输入内容。"></textarea>';
_html += '<span id="submsg" class="button button-green button-medium">提交反馈</span>&nbsp;&nbsp<span id="ts"></span>';
_html += '</div>';
_html += '</div>';
var dom1 = $(".foot");
var dom2 = $("#foot");
if (dom1.length > 0) {
    $(_html).appendTo($(".foot"));
}
if (dom2.length > 0) {
    $(_html).appendTo($("#foot"));
}; (function () {
    var b = document,
    _do = function (a) {
        if (typeof (a) == 'function') return a.call();
        if (typeof (a[0]) == 'function') return a[0].call();
        if (a.length) _load(a.shift(), a);
    }
    this.bx = function (a) {
        a.push = _do;
        _do([function() {
            if (a.length) for (var i = 0; i < a.length; i++) _do(a[i]);
        }]);
    }
})();
bx(_bx);
_bx.push([function () {
    $body = (window.opera) ? (document.compatMode == "CSS1Compat" ? jQuery('html') : jQuery('body')) : jQuery('html,body');
    $animating = false;
    jQuery('.fixedBtn .top').click(function () {
        if ($animating == false) {
            $body.animate({
                scrollTop: 0
            },
            500);
            $animating = true;
        }
        return false;
    });
    jQuery(window).scroll(function () {
        if (jQuery('.fixedBtn').offset().top > 500) {
            jQuery('.fixedBtn .top').css('display', 'inline-block');
        } else {
            jQuery('.fixedBtn .top').css('display', 'none');
            $animating = false;
        }
    });
    var $ = jQuery,
    fixedBtn = $('.fixedBtn'),
    feedback = $('.feedback', fixedBtn),
    feedbackCnt = $('.feedbackCnt'),
    sendBtn = $('.button', fixedBtn),
    content = $('textarea', fixedBtn),
    feedbackTips = $('.feedbackTips', fixedBtn),
    FBCLASS = 'fb-open',
    close = function () {
        $("#ts").html("");
        content.val("");
        fixedBtn.animate({
            right: '-=350'
        });
        feedbackCnt.removeClass(FBCLASS);
    },
    open = function () {
        feedbackTips.hide();
        $("#submsg").css({
            "display": "block",
            "width": "55px"
        });
        feedbackCnt.show();
        fixedBtn.animate({
            right: '+=350'
        });
        feedbackCnt.addClass(FBCLASS);
    };
    feedback.length && feedback.on('click',
    function (e) {
        e.preventDefault();
        feedbackCnt.hasClass(FBCLASS) ? close() : open();
    });
    sendBtn.on('click',
        function() {
            if (content.val() == "") return;
            var a = content.val();
            $.post('/users/ajax.ashx', {
                    _type: '_jy',
                    c: a
                },
                function(data) {
                    $("#submsg").css("display", "none");
                    $("#ts").html("<font color=#ff0000>提交成功，感谢您的参与！</font>");
                    setTimeout(function() {
                        close();
                    },
                        2000);
                });
        });
}]);
function scrollx(p) {
    var d = document,
    dd = d.documentElement,
    db = d.body,
    w = window,
    o = d.getElementById(p.id),
    ie6 = /msie 6/i.test(navigator.userAgent),
    timer;
    if (o) {
        cssPub = ";position:" + (p.f && !ie6 ? 'fixed' : 'absolute') + ";" + (p.t != undefined ? 'top:' + p.t + 'px;' : 'bottom:0;');
        if (p.r != undefined && p.l == undefined) {
            o.style.cssText += cssPub + ('right:' + p.r + 'px;');
        } else if (p.r == undefined && p.l != undefined) {
            o.style.cssText += cssPub + ('left:' + p.l + 'px;');
        }
        if (p.f && ie6) {
            cssTop = ';top:expression(documentElement.scrollTop +' + (p.t == undefined ? dd.clientHeight - o.offsetHeight : p.t) + '+ "px" );';
            cssRight = ';right:expression(documentElement.scrollright + ' + (p.r == undefined ? dd.clientWidth - o.offsetWidth : p.r) + ' + "px")';
            if (p.r != undefined && p.l == undefined) {
                o.style.cssText += cssRight + cssTop;
            } else {
                o.style.cssText += cssTop;
            }
            dd.style.cssText += ';background-image: url(about:blank);background-attachment:fixed;';
        } else {
            if (!p.f) {
                w.onresize = w.onscroll = function () {
                    clearInterval(timer);
                    timer = setInterval(function() {
                        var st = (dd.scrollTop || db.scrollTop),
                            c;
                        c = st - o.offsetTop + (p.t != undefined ? p.t : (w.innerHeight || dd.clientHeight) - o.offsetHeight);
                        if (c != 0) {
                            o.style.top = o.offsetTop + Math.ceil(Math.abs(c) / 10) * (c < 0 ? -1 : 1) + 'px';
                        } else {
                            clearInterval(timer);
                        }
                    },
                        10);
                }
            }
        }
    }
};
div_x = -350,
div_y = 180;
scrollx({
    id: 'loginForm',
    r: div_x,
    t: div_y,
    f: 1
});
document.getElementById("key").onkeydown = function (e) {
    if (!e) e = window.event; //火狐中是 window.event
    if ((e.keyCode || e.which) == 13) {
        subkey();
    }
}

function SetCookies(value)
    {
    	var Days = 30; //此 cookie 将被保存 30 天
    	var exp  = new Date();    //new Date("December 31, 9998");
    	exp.setTime(exp.getTime() + Days*24*60*60*1000);
    	document.cookie = "qd8home="+ escape (value) + ";domain=.qd8.com.cn;expires=" + exp.toGMTString();
    }

function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");

    if (arr = document.cookie.match(reg))

        return unescape(arr[2]);
    else
        return null;
}