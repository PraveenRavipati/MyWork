<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout</title>
 <script >
 window.location.hash="no-back-button";
 window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
 window.onhashchange=function(){
	 window.location.hash="no-back-button";
}</script>
</head>
<body>
    <% 
    HttpSession hs=request.getSession();
    hs.removeAttribute("uname");
    hs.invalidate();
    response.sendRedirect("Login.html");
    %>
</body>
</html>