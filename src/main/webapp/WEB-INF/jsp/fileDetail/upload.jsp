<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>this title</title>
</head>
<body>
<body>
 
    <form action="fileUpload" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="file">
        <input type="submit" value="提交">
    </form>
</body>
</body>
</html>