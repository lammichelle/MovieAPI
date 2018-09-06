<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href= "https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css">

</head>
<body>



<table border="1">
<!-- ${personinfo} is a list  coming from the PersonController-->
<!-- this for each loop works just like an enhanced for loop in java -->
	<th>Title</th> 
	 <th>Overview</th>
	 <th> Add to favorites!</th>
<c:forEach var="a" items="${mtest }" >
	<tr>
	
	
	
	 <td>${a.title}</td> 
	 <td>${a.overview}</td>
	 <td><a href = "/add/${a.id}/${a.title}/${a.video}/${a.overview}/${a.releaseDate}/"> <button>Add to favorite!</button></a></td>
	</tr>
	</c:forEach>
</table>


</body>
</html>