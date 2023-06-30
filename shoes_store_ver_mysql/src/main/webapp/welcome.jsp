<%@page import="dal.BrandDAO,model.Brand,java.util.*"%>
<html>
<head>
<meta http-equiv='refresh' content="0; URL='index.jsp'">
</head>

<%
	BrandDAO brandDAO = new BrandDAO();
	List<Brand> list = brandDAO.list();
	pageContext.setAttribute("list_brands", list, PageContext.APPLICATION_SCOPE);
%>

<body>
</body>
</html>