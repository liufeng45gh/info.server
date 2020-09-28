submitkeyword = function(flid, url, keyword) {

    $.get("/ajax/searchkw.ashx?flid=" + flid + "&url=" + window.location.href + "&keyword=" + escape(keyword), function(data) {
    });
};

var jsPara=(function()
{
    var obj={},
    scriptSrc=window.location.href,
    arr=scriptSrc.split("?");
    if(arr.length>1)
    {
    paras=arr[1].split("&");
    for (var i = 0, len = paras.length; i < len; i++)
    {
         var tempPara = paras[i].split("="),
         name = tempPara[0],
         value = tempPara[1];
         obj[name] = value;
     }
     }   
     return obj;
  })();

$(document).ready(function() {
    (function($) {
        $.pub = {
            ajaxs: {
                p: function(url, key, fltype, flUrl) {
		     submitkeyword(0, url, key);
                    //alert(url+"    "+key+"    "+fltype+"    "+flUrl);
                    $.post(url, { "keywords": key, "flType": fltype, "flUrl": flUrl, "c": window.win.cityid, "fid": window.win.flid, "ftp": window.win.fltp }, function(data) {
                        var obj = $("#key");
                        if (obj.attr("url")) {
                            window.location.href = obj.attr("url");
                        }
                        else {
                            window.location.href = data.url;
                        }

                    }, "json")
                },
                /*
                cklg:function(){
                var url="/users/ajax.ashx";
                $.post(url,{"_type":"cklg"},function(data){
                var jd = eval("("+data+")");
                if(document.getElementById("ctl00_topline1_1"))
                {
                $("#ctl00_topline1_1").html(jd.rtnmsg);
                }
                if(document.getElementById("topline1_1"))
                {
                $("#topline1_1").html(jd.rtnmsg);
                }
                if(document.getElementById("login"))
                {
                $("#login").html(jd.rtnindex);
                }
                },"string")
                },
                */ 		
                linksadd: function(linkid, linkurl, linktitle, typeid) {
                    //alert(linkid+"--"+linkurl+"--"+linktitle);
                    var comingUrl = window.location.href;
                    var url = "/ajax/AjaxForm.ashx";
                    $.post(url, { "_type": "_LinksClickAdd", "linkid": linkid, "linkurl": linkurl, "linktitle": linktitle, "comingUrl": comingUrl, "typeid": typeid }, function(data) {
                        return data;
                    }, "string")
                },
                check: function() {
                    var url = "/users/ajax.ashx";
                    $.post(url, { "_type": "ckLogin" }, function(data) {
                        if (data.sta == 0) {
                            showid('smallLay');
                        }
                        else {
                            //获取地区/小类/标签列表
                            var linkurl = document.location.search.replace("?","");
                            var city = jsPara["pdqbm"];
                            if(city=="" || city==null)
                            {
                            city= window.location.host;
                            city = city.substring(0, city.indexOf("."));
                            }
                            $.ajax({
                                type: "post",
                                async: false,
                                cache: false,
                                url: "/users/ajax.ashx",
                                dataType: "text",
                                data: "_type=_GetCityList&" + linkurl + "&ctname=" + city,
                                beforeSend: function() {
                                    //jscode
                                },
                                success: function(data) {
                                    var args1 = String(data).split('$');
                                    if (args1[0] == "null")
                                        $("#sel_city").css("display", "none");
                                    else {
                                        $("#sel_city").empty();
                                        $("#sel_city").html(args1[0]);
                                    }
                                    $("#sel_district").empty();
                                    $("#sel_district").html(args1[1]);
                                    $("#sfenlei").html(args1[2]);
                                },
                                complete: function() {
                                }
                            })

                            //获取街道列表
                            var cid = $("#sel_district option:selected").val();
                            var linkurl = document.location.search;
                            $.ajax({
                                type: "post",
                                async: false,
                                cache: false,
                                url: "/users/ajax.ashx",
                                dataType: "text",
                                data: "_type=_GetDistrict&" + linkurl + "&cid=" + cid,
                                beforeSend: function() {

                                },
                                success: function(data) {
                                    $("#sel_road").empty();
                                    $("#sel_road").html(data);
                                },
                                complete: function() {
                                    biaojiditu();
                                }
                            })
                            //城市下区列表
                        }
                    }, "json");
                }
            },
            search: {
                mouseups: function(id, keyword, msg) {
                    var _flag = keyword == "" ? true : false;
                    if (_flag)
                        $("#" + id).val(msg);
                    else
                        return true;
                },
                mousedowns: function(id, keyword, msg) {
                    var _flag = keyword == msg ? true : false;
                    if (_flag)
                        $("#" + id).val("");
                    else
                        return true;
                }
            },
            tousu: function(flid, newsid, dm, url) {
                window.location.href = "http://" + dm + "/webinfo/xinxitousu_add.aspx?flid=" + flid + "&id=" + newsid + "&tsurl=" + url;
            }
        }
    })(jQuery);

    //  $.pub.ajaxs.cklg();
})
function NewWin(url, name, xpos, ypos, width, height) {
    newWin = window.open(url, name, "screenX=" + xpos + ",screenY=" + ypos + ",WIDTH=" + width + ",HEIGHT=" + height + ",location=0,resizable=1,status=0,titlebar=1,directories=0,toolbar=0,menubar=0,scrollbars=0,status=1");
    newWin.focus();
}
function selParentmap() {
    var dw2 = document.getElementById("sel_district");
    var dw3 = document.getElementById("sel_road");
    var tx1 = $("#ctl00_Label1").text();
    var tx2 = dw2.options[dw2.selectedIndex].text;
    var tx3 = dw3.options[dw3.selectedIndex].text;
    var tx4 = tx1 + '市|' + tx2 + '|' + tx3;
    tx4 = tx4.replace("请选择", "");
    tx4 = tx4.replace("请选择", "");

    NewWin('/googmap/baidumapadd.htm?keyword=' + tx4, 'sel', 100, 100, 600, 480);
}
function userdenglu() {
    var username = $("#TextBox1").val();
    var pwd = $('#TextBox2').val();
    var tishi = "";
    $.ajax({
        type: "post",
        async: false,
        cache: false,
        url: "/users/ajax.ashx",
        dataType: "text",
        data: "_type=usLogin&usname=" + username + "&uspwd=" + pwd,
        beforeSend: function() {
        },
        success: function(data) {
            tishi = data;
        },
        complete: function() {
        }
    })
    if (tishi.indexOf("进入管理中心") > 0) {
        var newbox = document.getElementById("smallLay");
        newbox.style.display = "none";
        document.getElementById("layer").style.display = "none";
        document.cookie = "uId=" + tishi.split('$$')[1] + ";domain=.qd8.com.cn;";
        window.location.reload();
    }
    else
        alert(tishi);
}
//影藏登录控件 
function hdenglu() {
    $("#smallLay").css("display", "none");
    $("div").remove("#layer");
}
//登陆框
function showid(idname) {
    var isIE = (document.all) ? true : false;
    var isIE6 = isIE && ([/MSIE (\d)\.0/i.exec(navigator.userAgent)][0][1] == 6);
    var newbox = document.getElementById(idname);
    newbox.style.zIndex = "9999";
    newbox.style.display = "block"
    newbox.style.position = !isIE6 ? "fixed" : "absolute";
    newbox.style.top = newbox.style.left = "50%";
    newbox.style.marginTop = -newbox.offsetHeight / 2 + "px";
    newbox.style.marginLeft = -newbox.offsetWidth / 2 + "px";
    var layer = document.createElement("div");
    layer.id = "layer";
    layer.style.width = layer.style.height = "100%";
    layer.style.position = !isIE6 ? "fixed" : "absolute";
    layer.style.top = layer.style.left = 0;
    layer.style.backgroundColor = "#000";
    layer.style.zIndex = "9998";
    layer.style.opacity = "0.2";
    document.body.appendChild(layer);
    /*var sel=document.getElementsByTagName("select");
    for(var i=0;i<sel.length;i++){        
    sel[i].style.visibility="hidden";
    }*/
    function layer_iestyle() {
        layer.style.width = Math.max(document.documentElement.scrollWidth, document.documentElement.clientWidth)
+ "px";
        layer.style.height = Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight) +
"px";
    }
    function newbox_iestyle() {
        newbox.style.marginTop = document.documentElement.scrollTop - newbox.offsetHeight / 2 + "px";
        newbox.style.marginLeft = document.documentElement.scrollLeft - newbox.offsetWidth / 2 + "px";
    }
    if (isIE) { layer.style.filter = "alpha(opacity=20)"; }
    if (isIE6) {
        layer_iestyle()
        newbox_iestyle();
        window.attachEvent("onscroll", function() {
            newbox_iestyle();
        })
        window.attachEvent("onresize", layer_iestyle)
    }
    /*layer.onclick=function(){newbox.style.display="none";layer.style.display="none";for(var i=0;i<sel.length;i++){
    sel[i].style.visibility="visible";
    }}*/
}


city_change = function() {
    var cid = $("#sel_city option:selected").val();
    $.ajax({
        type: "post",
        cache: false,
        url: "/users/ajax.ashx",
        dataType: "text",
        data: "_type=_GetDistrict&cid=" + cid,
        beforeSend: function() {

        },
        success: function(data) {
            $("#sel_district").empty();
            $("#sel_district").html(data);
            $("#sel_road").empty();
            $("#sel_road").html("<option value=0>请选择</option>");
        },
        complete: function() {
            biaojiditu();
        }
    })
}

district_change = function() {
    var cid = $("#sel_district option:selected").val();
    $.ajax({
        type: "post",
        cache: false,
        url: "/users/ajax.ashx",
        dataType: "text",
        data: "_type=_GetDistrict&cid=" + cid,
        beforeSend: function() {

        },
        success: function(data) {
            $("#sel_road").empty();
            $("#sel_road").html(data);
        },
        complete: function() {
            biaojiditu();
        }
    })
}

ck_blur = function(obj) {
    if (obj.value == "") {
        obj.value = "面议";
        $(obj).unFormValidator(true); //obj.value = "校验价位";
    }
    else {
        if (obj.value == "面议") {
            $(obj).unFormValidator(true); //obj.value = "校验价位";

        }
        else {
            $(obj).unFormValidator(false); //obj.value = "不校验价位";

        }
    }

}
ck_blur1 = function(obj) {
    if (obj.value == "") {
        obj.value = "不限";
        $(obj).unFormValidator(true); //obj.value = "校验价位";
    }
    else {
        if (obj.value == "不限") {
            $(obj).unFormValidator(true); //obj.value = "校验价位";

        }
        else {
            $(obj).unFormValidator(false); //obj.value = "不校验价位";

        }
    }

}
ck_focus = function(obj) {
    if (obj.value == "面议" || obj.value == "不限") {
        obj.value = "";
    }
}
function checkTag() {
    var count1 = document.all.checkbox.length;
    var sut = 0;
    for (var i = 0; i < count1; i++)
        if (document.all.checkbox[i].checked == true) {
        sut = sut + 1;
        if (sut > 2) {
            alert('最多只能选择两个标签！');
            document.all.checkbox[i].checked = false;
        }
    }
}


linksadd = function(linkid, linkurl, linktitle, typeid) {
    $.pub.ajaxs.linksadd(linkid, linkurl, linktitle, typeid);
}

//查询按钮点击事件
sub = function(flid) {
    try {
        var _url = document.location.href;
        var _reg = /cn\/\w.*?\//;
        var _listStr = _url.match(_reg);
        var _array = _listStr.toString().split('/');
        //  alert($("#keywords").val()+"            "+_array[1]);
        subp("/search/search.ashx", $("#viewtop1_keywords").val(), flid, _array[1]);
    } catch (ex) {
        //alert(ex.message);
    }
}

subp = function(url, key, fltype, flUrl) {
    //alert(url+"    "+key+"    "+fltype+"    "+flUrl);
    $.post(url, { "keywords": key, "flType": fltype, "flUrl": flUrl }, function(data) {
        window.location.href = data.url;
    }, "json")
}
//鼠标点击事件
mousedown = function() {
    var _flag = $("#viewtop1_keywords").val() == "请输入搜索关键词" ? true : false;
    if (_flag)
        $("#viewtop1_keywords").val("");
    else
        return true;
}

//文本框失去焦点事件
mouseup = function() {
    var _flag = $("#viewtop1_keywords").val() == "" ? true : false;
    if (_flag)
        $("#viewtop1_keywords").val("请输入搜索关键词");
    else
        return true;
}

keydown = function(e, flid) {
    if (!e) e = window.event; //火狐中是 window.event

    if ((e.keyCode || e.which) == 13) {
        subkey();
    }
}

//控制遮罩层提交和发布提交分离
document.onkeydown = function(e) {
    if (!e) e = window.event; //火狐中是 window.event
    if ((e.keyCode || e.which) == 13) {
        if ($("#smallLay") && $("#smallLay")[0] && $("#smallLay")[0].style.display == "block") {
            userdenglu();
        }
    }
}

function DetCheck(urlstr) {
    var url = "/users/ajax.ashx";
    $.post(url, { "_type": "ckLogin" }, function(data) {
        if (data.sta == 0) {
            showid('smallLay');
        }
        else {
            hdenglu();
            window.location.href = urlstr;
        }
    }, "json");
}
function changebkimg(pd) {
    if (pd == 0) {
        $("#updel").removeClass("bkcolr1");
        $("#updel").addClass("bkcolr2");
    }
    else if (pd == 1) {
        $("#updel").removeClass("bkcolr2");
        $("#updel").addClass("bkcolr1");
    }
}




function getcontrol(a) {
    return document.getElementById(a);
}

function SetInputValue2(e, d, g, c, i) {

    var b = "";
    if (e) {
        a = e.getAttribute("url");
        e = e.getElementsByTagName("a");
        if (e.length > 0) {
            e = e[0];
        }
    }

    b = e.innerHTML;

    b = FilterHtml(b);

    var f = d.split("|");

    if (f.length > 1) {

        if (getcontrol(f[0])) {
            getcontrol(f[0]).value = b;
        }
        if (getcontrol(f[1])) {
            getcontrol(f[1]).value = "";
        }
    } else {
        if (getcontrol(d)) {
            if (getcontrol(d)) {
                getcontrol(d).value = b;
            }
            if (a) {
                getcontrol(d).setAttribute("url", a);
            }
            getcontrol(d).setAttribute("data-intellisense", b);
        }
    }
}

function SetInputValue(d, c, f, e, b, a) {

    if (a) {
        SetInputValue2(d, c, f, e, b, a);
        subkey();
        //window.location.href = a;
        return;
    } else {
        SetInputValue1(d, c, f, e, b, a);
    }
    if (getcontrol(f)) {
        getcontrol(f).style.display = "none";
    }
    if (b != "" && getcontrol(b)) {
        getcontrol(b).click();
    }
    if (e && e != "") {
        ShowSelectedItem(e);
    }
}
function QuanToBan(c) {
    if (!c || c == "") {
        return "";
    }
    var a = "";
    for (var b = 0; b < c.length; b++) {
        if (c.charCodeAt(b) == 12288) {
            a += String.fromCharCode(c.charCodeAt(b) - 12256);
            continue;
        }
        if (c.charCodeAt(b) > 65280 && c.charCodeAt(b) < 65375) {
            a += String.fromCharCode(c.charCodeAt(b) - 65248);
        } else {
            a += String.fromCharCode(c.charCodeAt(b));
        }
    }
    return a;
}
function SetMouseOver(d, c) {
    var e = getcontrol(c);
    if (!e) {
        return;
    }
    var a = e.getElementsByTagName("li");
    var b = 0;
    if (a && a.length > 0) {
        for (; b < a.length; b++) {
            a[b].className = "unselected";
        }
    }
    d.className = "keyselected";
}
function GetTipData(f, w, c, g, x, u, fid, ftp) {
    var l = QuanToBan(document.getElementById(w.split("|")[0]).value);

    if (cacheinputvalue[f][l] != undefined) {
        SetToolTipData(cacheinputvalue[f][l], f, w, g, x, u);
    } else {
        var a = false;
        if (u) {
            a = true;
        }
        var d = "";

        k = "/ajax/wordsuggest.ashx";
        d += k + "?d=" + new Date().getTime() + "&inputbox=" + encodeURIComponent(l) + "&c=" + c + "&ft=" + ftp + "&f=" + fid;
        var e = "callback" + Math.random().toString().substring(2, 6);

        window[e] = function(j) {
            cacheinputvalue[f][l] = j;
            SetToolTipData(j, f, w, g, x, a);
            window[e] = null;
        };

        d += "&callback=" + e;
        var v = document.createElement("SCRIPT");
        v.src = d;

        document.body.appendChild(v);
    }
}
function ShowSelectedItem(c) {

    if (c && c != null && c != "") {

        var a = c.split("|");
        var b = 0;
        if (a.length > 0 && a[0] == "0") {
            b = 2;
        }
        for (; b < a.length; b++) {
            $("#" + a[b]).css("display", "inline");
        }
    } else {
        $("select").css("display", "inline");
    }
}
function HideSelectedItem(c) {
    if (c && c != null && c != "") {
        var a = c.split("|");
        var b = 0;
        if (a.length > 0 && a[0] == "0") {
            b = 2;
        }
        for (; b < a.length; b++) {
            $("#" + a[b]).css("display", "none");
        }
    } else {
        $("select").css("display", "none");
    }
}
function FilterHtml(b) {
    var a = b.replace(/(<cite.*?>.*?<.cite>)/ig, "").replace(/(<.*?>)/ig, "");
    if (b && b != "") {
        a = b.replace(/(<cite.*?>.*?<.cite>)/ig, "").replace(/(<span.*?>.*?<.span>)/ig, "").replace(/(<.*?>)/ig, "");
    } else {
        a = "";
    }
    return a;
}
function SetInputValue1(e, d, g, c, i, a) {
    if (a) {
        return;
    }
    var b = "";
    if (e) {
        a = e.getAttribute("url");
        e = e.getElementsByTagName("a");
        if (e.length > 0) {
            e = e[0];
        }
    }
    //        if (a) {
    //            var h = e.getElementsByTagName("b");
    //            if (h.length > 0) {
    //                b = h[0].innerHTML;
    //            } else {
    //                b = e.innerHTML;
    //            }
    //        } else {
    b = e.innerHTML;
    //        }
    b = FilterHtml(b);
    var f = d.split("|");
    if (f.length > 1) {
        if (getcontrol(f[0])) {
            getcontrol(f[0]).value = b;
        }
        if (getcontrol(f[1])) {
            getcontrol(f[1]).value = "";
        }
    } else {
        if (getcontrol(d)) {
            if (getcontrol(d)) {
                getcontrol(d).value = b;
            }
            if (a) {
                getcontrol(d).setAttribute("url", a);
            }
            getcontrol(d).setAttribute("data-intellisense", b);
        }
    }
}
function getElementPositionX(b) {
    var a = b;
    var c = 0;
    while (a) {
        c += a.offsetLeft;
        a = a.offsetParent;
    }
    if (navigator.userAgent.indexOf("Mac") != -1 && typeof (document.body.leftMargin) != "undefined") {
        c += document.body.leftMargin;
    }
    return c + 13;
}
function getElementPositionY(c) {
    var a = c;
    var b = 0;
    while (a) {
        b += a.offsetTop;
        a = a.offsetParent;
    }
    if (navigator.userAgent.indexOf("Mac") != -1 && typeof (document.body.leftMargin) != "undefined") {
        b += document.body.topMargin;
    }
    return b + c.clientHeight + 11;
}
function SetToolTipData(p, h, x, k, z, w) {
    var f = k.split("|");
    if (f.length > 1 && f[0] == "0") {
        if (getcontrol(f[1])) {
            getcontrol(f[1]).value = p;
        }
    }
    if (p && p.w && p.w.length) {
        var a = p.w;
        var s = 0;
        if (getcontrol(h)) {
            getcontrol(h).style.display = "block";
        } else {
            return;
        }
        var n = getcontrol(h).getElementsByTagName("ul");
        var l = "";
        var o = "";
        var q;
        var u = "";
        for (s = 0; s < a.length; s++) {
            if (!a[s]) {
                continue;
            }
            var d = "";
            if ((a[s].ls && a[s].ls.length > 0) || (a[s].cs && a[s].cs.length > 0)) {
                if (a[s].cs && a[s].cs.length > 0 && a[s].cs[0].l.indexOf("http://") == 0) { } else {
                    d = "http://" + document.location.hostname + "/";
                }
                if ((a[s].cs && a[s].cs.length > 0)) {
                    var e = a[s].cs[a[s].cs.length - 1];
                    d += e.l + "/";
                }
                if ((a[s].ls && a[s].ls.length > 0)) {
                    var g = a[s].ls[a[s].ls.length - 1];
                    d += g.l + "/";
                }
                var v = encodeURIComponent(a[s].k.replace(/([^\u0391-\uFFE5a-zA-Z0-9@#\+\-_\. ])/ig, ""));

                d += "search/";
                l += "<li class='" + o + "' onmouseover=\"SetMouseOver(this,'" + h + '\')" onmouseout="this.className=\'unselected\'" url="' + d + "\"  onmousedown=\"SetInputValue(this,'" + x + "','" + h + "','" + k + "','" + z + "','" + d + "');return false\">";
            } else {
                l += "<li class='" + o + "' onmouseover=\"SetMouseOver(this,'" + h + "')\" onmouseout=\"this.className='unselected'\" onmousedown=\"SetInputValue(this,'" + x + "','" + h + "','" + k + "','" + z + "');return false\">";
            }
            var y = a[s].k;
            for (var r = 0, b = a[s].h.length; r < b; r++) {
                y = y.replace(a[s].h[r].v, "<b>" + a[s].h[r].v + "</b>");
            }
            if (a[s].des) {
                y += " <b>" + a[s].des.replace(a[s].desk, "<em>" + a[s].desk + "</em>").replace(/-/gi, "<i>-</i>") + "</b>";
            }

            l = l + "<a href='javascript:void(0)' target='_self'>" + y;
            if (a[s].s) {
                l += "<cite>" + a[s].s + "</cite>";
            }
            l += "</a>";
            l += "</li>";
        }
        n[0].innerHTML = l;
        if (k && k != "") {
            HideSelectedItem(k);
        }
        var c = getcontrol(h).getElementsByTagName("iframe");

        if (c.length == 1) {
            c[0].style.height = getcontrol(h).offsetHeight + "px";
            c[0].style.width = getcontrol(h).offsetWidth + "px";
        }
    } else {
        if (getcontrol(h)) {
            getcontrol(h).style.display = "none";
            var n = getcontrol(h).getElementsByTagName("ul");
            n[0].innerHTML = "";
            if (k && k != "") {
                ShowSelectedItem(k);
            }
        } else {
            if (k && k != "") {
                ShowSelectedItem(k);
            }
            return;
        }
    }
}

var cacheinputvalue = {};
function ShowTipWindow(h, e, f, g, b, c, ct) {
    var a = h.split("|");
    if (a.length > 1 && a[1] == "1") {
        this.tooltipWindowID = a[0];
    } else {
        this.tooltipWindowID = h;
    }
    this.inputboxvalue = e;

    this.cityid = f;
    if (g) {
        this.selid = g;
    } else {
        this.selid = "";
    }
    this.notHideTips = false;
    this.flid = c;
    this.fltp = ct;

    this.buttonID = "";
    if (b) {
        this.showhot = true;
    } else {
        this.showhot = false;
    }
    cacheinputvalue[h] = {};
}

ShowTipWindow.prototype = {
    closeTipWindow: function() {
       
        if (this.selid && this.selid != "") {
            ShowSelectedItem(this.selid);
        }
        var a = this.tooltipWindowID + "mask";
        if (getcontrol(this.tooltipWindowID)) {
            document.body.removeChild(getcontrol(this.tooltipWindowID));
        }
        if (getcontrol(a)) {
            document.body.removeChild(getcontrol(a));
        }
    },
    GetToolData: function() {
        if (!this.inputboxvalue) {
            return;
        }
        var a = null;
        if (document.all) {
            a = window.event;
        } else {
            a = arguments[0] || arguments.callee.caller.arguments[0];
        }
        if (a != null) {
            getcontrol(this.inputboxvalue).setAttribute("url", null);
            try {
                getcontrol(this.inputboxvalue).removeAttribute("url");
            } catch (f) { }
            switch (a.keyCode) {
                case 13:
                    var b = getcontrol(this.tooltipWindowID);
                    if (b && b.style.display != "none") {
                        var d = b.getElementsByTagName("li");
                        var c = 0;
                        if (d.length > 0) {
                            for (c = 0; c < d.length; c++) {
                                if (d[c].className && d[c].className == "keyselected") {
                                    SetInputValue1(d[c], this.inputboxvalue, "", "", "");
                                }
                            }
                        }
                    }
                    if (this.selid && this.selid != "") {
                        ShowSelectedItem(this.selid);
                    }
                    this.closeTipWindow();
                    if (this.buttonID != "" && getcontrol(this.buttonID) && getcontrol(this.buttonID).type == "button") {
                        getcontrol(this.buttonID).click();
                    }
                    return;
                case 38:
                    var b = getcontrol(this.tooltipWindowID);
                    if (b && b.style.display != "none") {
                        var d = b.getElementsByTagName("li");
                        var c = 0;
                        var g = false;
                        if (d.length > 0) {
                            for (c = 0; c < d.length; c++) {
                                if (d[c].className && d[c].className == "keyselected") {
                                    g = true;
                                    d[c].className = "unselected";
                                    if (c > 0) {
                                        d[c - 1].className = "keyselected";
                                        if (getcontrol(this.inputboxvalue.split("|")[0])) {
                                            if (d[c - 1]) {
                                                SetInputValue1(d[c - 1], this.inputboxvalue, "", "", "");
                                            }
                                            getcontrol(this.inputboxvalue.split("|")[0]).focus();
                                        }
                                        return;
                                    } else {
                                        d[d.length - 1].className = "keyselected";
                                        if (getcontrol(this.inputboxvalue.split("|")[0])) {
                                            if (d[d.length - 1]) {
                                                SetInputValue1(d[d.length - 1], this.inputboxvalue, "", "", "");
                                            }
                                            getcontrol(this.inputboxvalue.split("|")[0]).focus();
                                        }
                                        return;
                                    }
                                }
                            }
                            if (!g) {
                                d[d.length - 1].className = "keyselected";
                                if (getcontrol(this.inputboxvalue.split("|")[0])) {
                                    if (getcontrol(this.inputboxvalue.split("|")[0])) {
                                        if (d[d.length - 1]) {
                                            SetInputValue1(d[d.length - 1], this.inputboxvalue, "", "", "");
                                        }
                                        getcontrol(this.inputboxvalue.split("|")[0]).focus();
                                    }
                                    getcontrol(this.inputboxvalue.split("|")[0]).focus();
                                }
                                return;
                            }
                        }
                    }
                    return;
                case 40:
                    var b = getcontrol(this.tooltipWindowID);
                    if (b && b.style.display != "none") {
                        var d = b.getElementsByTagName("li");
                        var c = 0;
                        var g = false;
                        if (d.length > 0) {
                            for (c = 0; c < d.length; c++) {
                                if (d[c].className && d[c].className == "keyselected") {
                                    g = true;
                                    d[c].className = "unselected";
                                    if (c < d.length - 1) {
                                        d[c + 1].className = "keyselected";
                                        if (getcontrol(this.inputboxvalue.split("|")[0])) {
                                            if (d[c + 1]) {
                                                SetInputValue1(d[c + 1], this.inputboxvalue, "", "", "");
                                            }
                                            getcontrol(this.inputboxvalue.split("|")[0]).focus();
                                        }
                                        return;
                                    } else {
                                        d[0].className = "keyselected";
                                        if (getcontrol(this.inputboxvalue.split("|")[0])) {
                                            if (d[0]) {
                                                SetInputValue1(d[0], this.inputboxvalue, "", "", "");
                                            }
                                            getcontrol(this.inputboxvalue.split("|")[0]).focus();
                                        }
                                        return;
                                    }
                                }
                            }
                            if (!g) {
                                d[0].className = "keyselected";
                                if (getcontrol(this.inputboxvalue.split("|")[0])) {
                                    if (d[0]) {
                                        SetInputValue1(d[0], this.inputboxvalue, "", "", "");
                                    }
                                    getcontrol(this.inputboxvalue.split("|")[0]).focus();
                                }
                                return;
                            }
                        }
                    }
                    return;
            }
        }
        if (getcontrol(this.inputboxvalue.split("|")[0]).value == "") {

            if (this.selid && this.selid != "") {
                ShowSelectedItem(this.selid);
            }
            this.closeTipWindow();
            return;
        }
        if (!getcontrol(this.tooltipWindowID)) {
            this.openTipWindow();
        }

        GetTipData(this.tooltipWindowID, this.inputboxvalue, this.cityid, this.selid, this.buttonID, this.showhot, this.flid, this.fltp);

    },
    openTipWindow: function() {
        if (!this.inputboxvalue) {
            return;
        }
        var b = getcontrol(this.inputboxvalue.split("|")[0]);
        var a = this.tooltipWindowID + "mask";
        var f = this.tooltipWindowID;
        var g = this.selid;
        this.closeTipWindow();
        var d = document.createElement("div");
        d.id = this.tooltipWindowID;
        d.style.position = "absolute";
        d.style.zIndex = "9999";
        d.style.display = "none";
        d.style.top = getElementPositionY(b) + 3 + "px";
        d.style.left = getElementPositionX(b) + "px";
        d.className = "tooltip";
        d.innerHTML = '<ul></ul><iframe src="about:blank" width="300" height="200" frameBorder="0" style="z-index:-1;position:absolute;top:0;left:0;border:0; " scrolling="no" ></iframe>';
        document.body.appendChild(d);
        var c = b,
                e = this;
        if (c.addEventListener) {
            c.addEventListener("blur", function() { e.closeTipWindow(); }, false);
        } else {
            if (c.attachEvent) {
                c.attachEvent("onblur", function() { e.closeTipWindow(); });
            }
        }
    }
};