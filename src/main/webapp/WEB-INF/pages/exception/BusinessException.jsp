<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>业务错误信息</title>
    </head>
    <body>
        <img src="http://okxw7jg6g.bkt.clouddn.com/me_comic16X16.ico" height="16" width="16" /><br/>
        <% Exception e = (Exception) request.getAttribute("ex"); %>
        <H2>业务错误: <%= e.getClass().getSimpleName()%></H2>
        <hr/>
        <P>错误描述：</P>
        <%= e.getMessage()%>
        <P>错误信息：</P>
        <% e.printStackTrace(new java.io.PrintWriter(out)); %>
    </body>
</html>