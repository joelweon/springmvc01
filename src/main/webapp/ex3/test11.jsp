<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex3</title>
</head>
<body>
<h1>test11</h1>
페이지 컨트롤러가 HttpServletReqest에 보관한 값 꺼내기<br>
name: ${ requestScope.name }<br>
age:  ${ requestScope.age }<br>
tel:  ${ requestScope.tel }<br>
</body>
</html>