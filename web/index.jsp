<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<c:if test="${ not empty user}">
    <jsp:include page="${pageContext.request.contextPath}/chat/index.jsp"/>
</c:if>

<c:if test="${  empty user}">
    <jsp:include page="${pageContext.request.contextPath}/login.jsp"/>
</c:if>
