<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" type="image/ico" href="./images/truyum-logo-dark.png" />
		<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<header>
			<span class="header-title">truYum</span>
			<img class="header-logo" src="./images/truyum-logo-light.png" alt="truYum Logo"></img>
			<nav>
				<a class="nav-link" href="login-first">Menu</a>
				<a class="nav-link" href="login-first">Cart</a>
			</nav>
		</header>
		<article>
			<h2 class="article-heading">Register</h2>
<form:form  action="saveuser" modelAttribute="user" method="post">
      <table  class="table-margin">
          <tr>
              <td class="col-left">User Name:</td>
              <td class="col-right"><form:input path="userName" /></td>
          </tr>
          
          <tr>
              <td class="col-left">
              
                  <input type="submit" value="Create" />
              </td>
              <td class="col-right">
              
                 <a href="login">Login</a>
              </td>
          </tr>
            
          <tr>
              <td class="col-left">
              
              </td>
              <td class="col-right">
              
              
              </td>
          </tr>
      </table>
     
  </form:form>
  </article>
</body>
</html>