<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생성적</title>
		<style>
		  h2{text-align: center;}
		  table{width:400px; margin:10px auto;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:200px; height:40px; text-align: center; }
		</style>
	</head>
	<body>
	<h2>로그인페이지</h2>
	<form action="/stu/stu" method="post">
		<label>번호</label>
		<input type="text" name="sno"><br>
		<label>이름</label>
		<input type="text" name="name"><br>
		<label>국어</label>
		<input type="text" name="kor"><br>
		<label>영어</label>
		<input type="text" name="eng"><br>
		<label>수학</label>
		<input type="text" name="math"><br>
		
		<input type="submit" value="성적저장">

	</form>
	<ul>
		<li><a href="/">메인</a></li>
	</ul>
	</body>
</html>