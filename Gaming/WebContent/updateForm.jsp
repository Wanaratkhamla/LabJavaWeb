<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList, model.Product" %>
<%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ProductCtrl" method="POST">
<%
  	@SuppressWarnings("unchecked")
  	Product product = (Product)request.getAttribute("product");
%>
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="ProductID" value="<%=product.getProductID() %>">
	BrandID <input type="Text" name="BrandID" value="<%=product.getBrandID() %>"> <br>
	TypeID <input type="Text" name="TypeID" value="<%=product.getTypeID() %>"> <br>
	ProductName <input type="Text" name="ProductName" value="<%=product.getProductName() %>"> <br>
	ProductPrice <input type="Text" name="ProductPrice" value="<%=product.getProductPrice() %>"> <br>
	ProductNumber <input type="Text" name="ProductNumber" value="<%=product.getProductNumber() %>"> <br>
	ProductDescription <input type="Text" name="ProductDescription" value="<%=product.getProductDescription() %>"> <br>
	<input type="submit" value="add">
</form>

</body>
</html>