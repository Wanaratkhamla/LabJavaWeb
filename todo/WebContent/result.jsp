<%@page import="java.util.ArrayList, model.Note"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=utf8"></head>
<body>
<%
	ArrayList<Note> nlist = (ArrayList<Note>)request.getAttribute("notes");
	for (int i=0; i<nlist.size(); i++) {
		Note note = nlist.get(i);
		out.println(note.getTask() + "<br>");
	}
%>
</body>
</html>