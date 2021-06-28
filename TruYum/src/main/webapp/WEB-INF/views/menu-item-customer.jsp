
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
				<a class="nav-link" href="menu-item-list-customer_?username=${user.userName}">Menu</a>
				<a class="nav-link" href="cart?username=${user.userName}">Cart</a>
					<a class="nav-link" href="logout">Hello ${user.userName}</a>
			</nav>
		</header>
		<article>
			<h2 class="article-heading">Menu Items</h2>
			
			<table>
				<tr>
					<th class="col-left">Name</th>
					<th>Free Delivery</th>
					<th class="col-right">Price</th>
					<th>Category</th>
					<th>Action</th>
				</tr>
				<c:forEach var="m" items="${menuitemlist}">
				
				<tr>
					<td class="col-left">${m.name}</td>
					<td>${m.freeDelivery}</td>
					<td class="col-right">${m.price}</td>
					<td>${m.category}</td>
					<td>
						<a class="action-link" href="addtocart?menuitem=${m.id}&username=${user.userName}">Add to Cart</a>
					</td>
				</tr>
			</c:forEach>
			</table>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
</body>
</html>