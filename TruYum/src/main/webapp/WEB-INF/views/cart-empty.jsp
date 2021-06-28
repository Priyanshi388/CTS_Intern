<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${user.userName}
<header>
			<span class="header-title">truYum</span>
			<img class="header-logo" src="./images/truyum-logo-light.png" alt="truYum Logo"></img>
			<nav>
				<a class="nav-link" href="./menu-item-list-customer.html">Menu</a>
				<a class="nav-link" href="cart.html">Cart</a>
			</nav>
		</header>
		<article>
			<h2 class="article-heading">Cart</h2>
			<p class="article-message">No items in cart. Use 'Add to Cart' option in 
				<a class="article-link" href="menu-item-list-customer?user=${user}">Menu Item List</a>.
			</p>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
</body>
</html>