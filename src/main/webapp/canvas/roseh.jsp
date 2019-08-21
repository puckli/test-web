<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">

    <title>FOR | </title>
    <meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=0.8; maximum-scale=1.6"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache"/>
    <style type="text/css">
        body {
            width:100%;
            height: 100%;
        }

        .section {
            position:fixed;
            width: 100%;
            left:0px; bottom:10px; width:100%;
            text-align: center;
        }

        .section div{
            text-shadow: 2px 2px 1px #000;
            font-size: 26px;
            text-align: center;
            color: red;
        }

        .ilu {
            font-weight: bold;
            font-size: 1.5em;
            -moz-transition: all 5s ease-in 5s;
            -webkit-transition: all 5s ease-in 5s;
            -o-transition: all 5s ease-in 5s;
            transition: all 5s ease-in 5s;
            visibility: hidden;
        }

        .words {
            margin-top: 100px;
            height: 60px
        }

        .rose{
            position: absolute;
            text-align: center;
            margin: auto auto;
        }
    </style>
</head>

<body>

<div id="demo" style="width:100%; height:500px;" class="rose">
    <canvas id="c" height="500" width="500" style="margin: auto;"></canvas>
</div>

<div class="section">
    <br>
    <div id="ilu" class="ilu" style="">(*˘︶˘*).。.:*♡</div>
    <div id="word" class="words"></div>
</div>

<script>
    var b = document.body;
    var c = document.getElementsByTagName('canvas')[0];
    var a = c.getContext('2d');
    var canvas = document.getElementsByTagName('canvas')[0];
    var ctx = canvas.getContext('2d');
    document.body.clientWidth;

    with (m = Math) C = cos, S = sin, P = pow, R = random;
    c.width = c.height = f = 500;
    h = -250;

    function p(a, b, c) {
        if (c > 60)
            return [S(a * 7) * (13 + 5 / (.2 + P(b * 4, 4))) - S(b) * 50, b * f + 50, 625 + C(a * 7) * (13 + 5 / (.2 + P(b * 4, 4))) + b * 400, a * 1 - b / 2, a];
        A = a * 2 - 1;
        B = b * 2 - 1;
        if (A * A + B * B < 1) {
            if (c > 37) {
                n = (j = c & 1) ? 6 : 4;
                o = .5 / (a + .01) + C(b * 125) * 3 - a * 300;
                w = b * h;
                return [o * C(n) + w * S(n) + j * 610 - 390, o * S(n) - w * C(n) + 550 - j * 350, 1180 + C(B + A) * 99 - j * 300, .4 - a * .1 + P(1 - B * B, -h * 6) * .15 - a * b * .4 + C(a + b) / 5 + P(C((o * (a + 1) + (B > 0 ? w : -w)) / 25), 30) * .1 * (1 - B * B), o / 1e3 + .7 - o * w * 3e-6]
            }
            if (c > 32) {
                c = c * 1.16 - .15;
                o = a * 45 - 20;
                w = b * b * h;
                z = o * S(c) + w * C(c) + 620;
                return [o * C(c) - w * S(c), 28 + C(B * .5) * 99 - b * b * b * 60 - z / 2 - h, z, (b * b * .3 + P((1 - (A * A)), 7) * .15 + .3) * b, b * .7]
            }
            o = A * (2 - b) * (80 - c * 2);
            w = 99 - C(A) * 120 - C(b) * (-h - c * 4.9) + C(P(1 - b, 7)) * 50 + c * 2;
            z = o * S(c) + w * C(c) + 700;
            return [o * C(c) - w * S(c), B * 99 - C(P(b, 7)) * 50 - c / 3 - z / 1.35 + 450, z, (1 - b / 1.2) * .9 + a * .1, P((1 - b), 20) / 4 + .05]
        }
    }

    var draw = setInterval('for(i=0;i<1e4;i++)if(s=p(R(),R(),i%46/.74)){z=s[2];x=~~(s[0]*f/z-h);y=~~(s[1]*f/z-h);if(!m[q=y*f+x]|m[q]>z)m[q]=z,a.fillStyle="rgb("+~(s[3]*h)+","+~(s[4]*h)+","+~(s[3]*s[3]*-80)+")",a.fillRect(x,y,1,1)}', 1);

    var demo = document.getElementById('demo');

    function redraw() {
        draw = setInterval('for(i=0;i<1e4;i++)if(s=p(R(),R(),i%46/.74)){z=s[2];x=~~(s[0]*f/z-h);y=~~(s[1]*f/z-h);if(!m[q=y*f+x]|m[q]>z)m[q]=z,a.fillStyle="rgb("+~(s[3]*h)+","+~(s[4]*h)+","+~(s[3]*s[3]*-80)+")",a.fillRect(x,y,1,1)}', 0);
    }

    function clear_canvas() {
        ctx.clearRect(0, 0, 520, 500);
    }

    function stop_draw(obj) {
        clearInterval(obj);
    }

    window.onload = function () {
//        $("#ilu").show(5000);
        document.getElementById("ilu").style.visibility = "hidden";
        document.getElementById("ilu").style.visibility = "visible";
        setInterval(appendWord, 200);
    }

    var word = "en~";
    //  I ♥ U
    var cnts = false;
    function appendWord(){
        if(cnts){
            return;
        }
        cnts = true;
        var worddiv = document.getElementById("word");
        var arr = word.split(",");
        var st = 1000;
        for(var i in arr){
            setTimeout(appends, st);
            st = st + 350;
        }
    }
    var cnti = 0;
    var arr = word.split(",");
    function appends() {
        var worddiv = document.getElementById("word");
        worddiv.append(arr[cnti] ? arr[cnti] : " ");
        cnti++;
    }


</script>

</body>
</html>
