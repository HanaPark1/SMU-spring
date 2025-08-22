<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 성적 확인</title>
		<style>
		  h2{text-align: center;}
		  table{width:400px; margin:10px auto;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:200px; height:40px; text-align: center; }
		</style>
	</head>
	<body>
	<h2>입력결과</h2>
	<table>
		<tr>
			<th>아이디</th>
			<td>${member.id}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${member.name}</td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td>${member.pw}</td>
		</tr>
		<tr>
			<th>번호</th>
			<td>${member.phone}</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${member.gender}</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>${member.hobby}</td>
		</tr>
		<tr>
			<th colspan="2"><a href="/">메인</a></th>
		</tr>
	</table>
	</body>
</html>