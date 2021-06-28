
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>truYum</title>
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
			<h2 class="article-heading">User name ${user.userName} already take try with different username </h2>
<a href="register">Register</a>
</article>
</body>

</html>