<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Welcome</h2>
<hr>


<p>User :
    <security:authentication property="principal.username"/>
    <br><br>

    Role(s) :
    <security:authentication property="principal.authorities"/>
    <br><br>

<hr>

<security:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meting</a> (only for Manager)
    </p>

</security:authorize>

<br><br>

<security:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/admin">IT Systems Meeting</a> (only for Admins)
    </p>
</security:authorize>

<br><br>


<form:form action="${pageContext.request.contextPath}/logout"
           method="post">

    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>
