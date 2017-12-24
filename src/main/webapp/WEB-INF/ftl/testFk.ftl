<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<#-- FreeMarker的插值有如下两种类型:1,通用插值${expr};2,数字格式化插值:#{expr}或#{expr;format}  -->
Hello ${name}
<br><br>
    #{nums} ..
    #{nums2} ..
    #{nums3} ..
    <br><br>

        <#assign answer=42/>
        ${answer}
        ${answer?string} <#-- the same as ${answer} -->
        ${answer?string.number}
        ${answer?string.currency}
        ${answer?string.percent}
        ${answer}

            <br><br>
        ${lastUpdated?string("yyyy-MM-dd HH:mm:ss zzzz")}<br>
        ${lastUpdated?string("EEE, MMM d, ''yy")}<br>
        ${lastUpdated?string("EEEE, MMMM dd, yyyy, hh:mm:ss a '('zzz')'")}<br><br>


        <#assign foo=true/>
        ${foo?string("yes", "no")}
            <br><br>

        <#-- 数字格式化插值可采用#{expr;format}形式来格式化数字,其中format可以是:
        mX:小数部分最小X位
        MX:小数部分最大X位  -->
        <#assign x=2.582/>
        <#assign y=4/>
        #{x; M2} <#-- 输出2.58 -->
        #{y; M2} <#-- 输出4 -->
        #{x; m2} <#-- 输出2.6 -->
        #{y; m2} <#-- 输出4.0 -->
        #{x; m1M2} <#-- 输出2.58 -->
        #{x; m1M2} <#-- 输出4.0 -->

    <br><br>
    <u1>
        <#-- 使用FTL指令 -->
        <#list list as td><br>
            <li>${td.name} for ${td.desc} Euros</li>
        </#list>
     <u1>
    <br><br>

        ${map.hello}<br>
         <#if map?exists>
             <#list map?keys as key>
                 ${key}  ${map[key]}
             </#list>
         </#if>
        <br><br>


     <#assign age=23>
     <#if (age>60)>老年人
     <#elseif (age>40)>中年人
     <#elseif (age>20)>青年人
     <#else> 少年人
     </#if>






</body>
</html>