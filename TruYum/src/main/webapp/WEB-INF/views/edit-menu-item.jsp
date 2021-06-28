<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<a class="nav-link" href="/menu-item-list-admin?username=${user.userName}">Menu</a>
				<a class="nav-link" href="logout">Hello ${username}</a>
			</nav>
		</header>
		<article>
			<h2 class="article-heading">Edit Menu Item</h2>
			<form name="editMenuItemForm"  action="edit-menu-item-status?menuitem=${item.id}&username=${username}" method="post">
				<table class="form-table">
					<tr>
						<td colspan="4">
							<label class="form-item" for="field-title">Title</label>
							<input class="form-input" type="text" name="name" id="field-title" value="${item.name}"></input>
						</td>
					</tr>
					<tr>
						<td>
							<label class="form-item" for="field-price">Price (Rs.)</label>
							<input class="form-input form-input-right" type="text" name="price" id="field-price" value="${item.price}"></input>
						</td>
						<th>
							<label class="form-item" for="field-yes">Active</label><br>
							<input type="radio" name="active" id="field-yes" value="Yes" checked><label class="form-item" for="field-yes">Yes</label></input>
							<input type="radio" name="active" id="field-no" value="No"><label class="form-item" for="field-no">No</label></input>
						</th>
						<td>
							<label class="form-item" for="field-dateOfLaunch">Date of Launch</label>
							<input class="form-input" type="text" name="dateOfLaunch" id="field-dateOfLaunch" placeholder="dd/mm/yyyy" value=<fmt:formatDate value="${item.dateOfLaunch}" pattern="dd/MM/yyyy" />></input>
						</td>
						<td>
							<label class="form-item" for="field-category">Category</label>
							<select class="form-input" name="category" id="field-category">
								<option value="select">--Select--</option>
								<option value="Starters">Starters</option>
								<option value="Main Course" selected>Main Course</option>
								<option value="Desert">Desert</option>
								<option value="Drinks">Drinks</option>
							</select>
						</td>
					</tr>
					<tr colspan=4>
						<td>
							<label class="form-item" for="field-freeDelivery">
								<input type="checkbox" name="freeDelivery" id="field-freeDelivery" value="Yes" checked>Free Delivery
								<span class="form-checkbox"></span>
							</label>
						</td>
					</tr>
					<tr colspan=4>
						<td>
							<input class="form-button" type="submit" name="submit" value="Save"></input>
						</td>
					</tr>
				</table>
			</form>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
</body>
</html>