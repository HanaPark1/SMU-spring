<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>숫자입력</title>
		<style>
		  h2{text-align: center;}
		  table{width:400px; margin:10px auto;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:200px; height:40px; text-align: center; }
		</style>
	</head>
	<body>
	<h2>숫자입력</h2>
	<form action="/num/numInput" method="post">
		<label>이름</label>
		<input type="text" name="name"><br>
		<label>국어</label>
		<input type="text" name="kor"><br>
		<label>영어</label>
		<input type="text" name="eng"><br>
		
		<input type="submit" value="저장">

	</form>
	<ul>
		<li><a href="/">메인</a></li>
	</ul>
	</body>
</html>