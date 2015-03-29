<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<c:if test="${ not empty user}">
    <jsp:include page="${pageContext.request.contextPath}/chat/index.jsp"/>
</c:if>

<c:if test="${  empty user}">
    <jsp:include page="${pageContext.request.contextPath}/login.jsp"/>
</c:if>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml">--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />--%>
    <%--<title>jQuery Scroller</title>--%>
    <%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div id="myDiv" style="width: 500px; height: 100px; overflow: auto; border: 1px solid black;"></div>--%>
<%--<input type="text" id="myTextInput" />--%>
<%--<input type="button" value="Send" id="postButton" />--%>
<%--<div id="info"/>--%>
<%--<script type="text/javascript">--%>
    <%--$(document).ready(function(){--%>
        <%--$('#postButton').click(function(){--%>
            <%--$('#myDiv').append($('#myTextInput').val() + '<br/>');--%>
            <%--$('#myTextInput').val('');--%>
            <%--$("#myDiv").animate({ scrollTop: $("#myDiv").attr("scrollHeight") - $('#myDiv').height() }, 3);--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>