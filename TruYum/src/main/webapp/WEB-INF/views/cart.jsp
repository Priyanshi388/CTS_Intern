<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<a class="nav-link" href="menu-item-list-customer_?username=${user.userName}">Menu</a>
				<a class="nav-link" href="cart?username=${user.userName}">Cart</a>
					<a class="nav-link" href="logout">Hello ${user.userName}</a>
			</nav>
		</header>
		<article>
			<h2 class="article-heading">Cart</h2>
			<table  class="table-margin">
				<tr>
					<th class="col-left">Name</th>
					<th class="col-left">Free Delivery</th>
					<th class="col-right">Price</th>
					<th></th>
				</tr>
				<c:forEach var="mList" items="${menuitemlist}">
				<tr>
			
					<td class="col-left">${mList.name}</td>
					<td class="col-left">${mList.freeDelivery}</td>
					<td class="col-right">${mList.price}</td>
					<td>
						<a class="action-link" href="cart-notification?menuitem=${mList.id}&username=${user.userName}">Delete</a>
					</td>
				</tr>
				</c:forEach>
				
				<tr>
					<th></th>
					<th class="col-left">Total</th>
					<th class="col-right">${total}</th>
					<th></th>
				</tr>
			</table>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
	</body>
</html>