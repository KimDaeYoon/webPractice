<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todoList</title>
</head>
<body>
	<h1>Todo List</h1>
	<form action="add" method="post">
		할일: <input type="text" name="todo" placeholder="할일 입력"> <input
			type="submit" value="하일 추가" />
	</form>

	<c:forEach items="${todoList }" var="todo">
		<p>
		<c:if test= "${todo.done }">완료</c:if>
		<c:if test= "${!todo.done }">진행중</c:if>
		
		<a href="update?id=${todo.id }"> ${todo.todo }</a>
		<a href="delete?id=${todo.id }">삭제</a>
		</p>
	</c:forEach>

</body>
</html>