<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>

    <style>

        i {
            color: red;
        }

    </style>
</head>
<body>
<h3>Login Page</h3>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
           method="POST" >

   <c:if test="${param.error != null}">

       <i >You entered invalid username/password</i>
   </c:if>

    <p>
        User Name : <input type="text" name="username"/>
    </p>

    <p>
        Password : <input type="password" name="password"/>
    </p>

    <input class="asd" type="submit" value="Login"/>

</form:form>

</body>
</html>
