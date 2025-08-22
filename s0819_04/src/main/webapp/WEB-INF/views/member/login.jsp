<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<style>
		  h2{text-align: center;}
		  table{width:400px; margin:10px auto;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:200px; height:40px; text-align: center; }
		</style>
	</head>
	<body>
	<h2>로그인페이지</h2>
	<form action="/login" method="post">
		<label>아이디</label>
		<input type="text" name="id"><br>
		<label>패스워드</label>
		<input type="text" name="pw"><br>
		<input type="submit" value="로그인">

	</form>
	<ul>
		<li><a href="/">메인</a></li>
	</ul>
	</body>
</html>