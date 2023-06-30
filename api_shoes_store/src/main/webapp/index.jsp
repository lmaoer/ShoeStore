<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<hmtl>

<body>


<c:forEach items="${data}" var="i">
<img alt="" src="data:image/jpg;base64,${i.image}">
</c:forEach>

<form action="Base64" method="POST">
	<input type="text" placeholder="base64 here" name="base64">
</form>

<img alt="" src="data:image/jpg;base64,${base64}">

<script type="text/javascript">
fetch('/api_shoes_store/product').then(response => {
  console.log(response);
  if (!response.ok) throw new Error(`Request failed`);
  return response.json();
}).then(data => {
  console.log(data);
  
    
    /* html = "<option>" + city.name + "</option>";
    document.querySelector('select').insertAdjacentHTML('beforeend', html); */
  
})
.catch(err => {
  err => console.log(err);
});
</script>

</body>

</hmtl>
