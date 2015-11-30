<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="userRegister" method="post">
    <label for="email">电子邮件：</label><input id="email" type="text" name="email"><br>
    <label for="name">用户名：</label><input id="username" type="text" name="userName"><br>
    <label for="telphone">手机：</label><input id="phonenumber" type="text" name="phoneNumber"><br>
    <label for="password">密码：</label><input id="password" type="password" name="password"><br>
    <input type="submit" value="submit">
  </form>
   <form action="userLogin" method="post">
    <label for="name">用户名：</label><input id="username" type="text" name="userName"><br>
    <label for="password">密码：</label><input id="password" type="password" name="password"><br>
    <input type="submit" value="submit">
  </form>
</body>
</html>