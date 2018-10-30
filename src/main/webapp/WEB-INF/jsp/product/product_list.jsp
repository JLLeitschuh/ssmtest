<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>this title</title>
</head>
<body>
<h1 align="center">成功页面</h1>

<table>
		<thead>
				<tr>
					<th class="center">产品名称</th>
					<th class="center">产品价格</th>
					<th class="center">生产时间</th>
				</tr>
		</thead>
<tbody>
<c:forEach items="${list}" var="productlist" varStatus="index">
			<tr>
				<td>${productlist.productName }</td>
				<td>${productlist.productPrice }</td>
				<td>${productlist.productTime }</td>
			</tr>
		</c:forEach>
</tbody>


</table>


		

${d }
</body>
</html>