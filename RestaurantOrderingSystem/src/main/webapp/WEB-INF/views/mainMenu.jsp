<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Welcome</p>
	
	<c:if test="${showManageStaff}" >
 		<a href="/RestaurantOrderingSystem/manageStaff">Manage Staff</a> <br/>
	</c:if> 
	
	<a href="/RestaurantOrderingSystem/viewMenu">View Menu</a><br/>
	
	<c:if test="${showPlaceOrder}" >
		<a href="/RestaurantOrderingSystem/manageOrder">Start Order</a><br/>
	</c:if> 
	
	<c:if test="${showPlaceOrder}" >
		<a href="/RestaurantOrderingSystem/user_order_history">My Orders</a><br/>
	</c:if> 
	
	<c:if test="${showPlacedOrders}" >
		<a href="/RestaurantOrderingSystem/restaurant_order_history">Placed Orders</a><br/>
	</c:if> 
	
	 <form class="form-inline" action="/RestaurantOrderingSystem/logout" method="post">
      <input type="submit" value="Log out" />
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</body>
</html>