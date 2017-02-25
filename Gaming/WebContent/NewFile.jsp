
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

<a href="insertForm.jsp">เพิ่มสินค้าใหม่</a>
<a href='ProductCtrl?action=null'>ดูรายการสินค้า</a>
<table border='1'>
	<tr><th>รหัส</th><th>ชื่่อสินค้า</th><th>รหัสยี่ห้อ</th><th>รหัสประเภท</th><th>รายละเอียด</th><th>จำนาน</th><th>ราคา</th><th></th><th></th></tr>
	
<%
  	@SuppressWarnings("unchecked")
  	ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("products");

  	if (productList!=null && productList.size()>0) {
	  	for(int i=0; i<productList.size(); i++) {
		  	Product product = productList.get(i);
%>
		<tr>
		<td><%=product.getProductID() %></td>
		<td><%=product.getProductName() %></td>
		<td><%=product.getBrandID() %></td>
		<td><%=product.getTypeID() %></td>
		<td><%=product.getProductDescription() %></td>
		<td><%=product.getProductNumber() %></td>
		<td><%=product.getProductPrice() %></td>
		<td><a href='ProductCtrl?action=editForm&ProductID=<%=product.getProductID() %>'>แก้ไข</a></td>
		<td><a href='ProductCtrl?action=remove&ProductID=<%=product.getProductID() %>'>ลบ</a></td>
		</tr>
<%
	  }
  }
%>
</table>

</body>
</html>