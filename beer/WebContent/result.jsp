<%@page import="java.util.ArrayList"%>
<html>
<body>

<h2>Beer Recommendation</h2>

<%
  ArrayList<String> beerList = (ArrayList<String>)request.getAttribute("brands");

  for(int i=0; i<beerList.size(); i++) {
     out.println(beerList.get(i) + "<br>");
    }
%>

</body>
</html>
