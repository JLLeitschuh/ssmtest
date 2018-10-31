<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>this title</title>
<script type="text/javascript">
	$(document).ready(function() {
		// 初始化分页
		laypage({
			cont : $("#div_page"), //容器。值支持id名、原生dom对象，jquery对象,
			pages : '${pageInfo.pages}', //总页数
			skin : 'yahei', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
			groups : 7, //连续显示分页数
			first : '首页',
			last : '尾页',
			prev : '上一页',
			next : '下一页',
			curr : function() {
				return $
				{
					pageInfo.pageNum
				}
				;
			}(),
			jump : function(e, first) { //触发分页后的回调
				if (!first) { //一定要加此判断，否则初始时会无限刷新
					$("input[name='pageNum']").val(e.curr);
					$("#productForm").submit();
				}
			}
		});

	/* 	//搜索
		$('#product_search').on('click', function() {
			$("input[name='pageNum']").val(1);
			$("#productForm").submit();
		});

		$("#companyId option").each(function() {
			if ($(this).val() == '${productVO.companyId}') {
				$(this).attr("selected", "selected");
			}
		});
	});
 */
</script> --%>
</head>


<body>
	<div>
		<div>
			<form action="${pageContext.request.contextPath}/to_product_list" method="get">

				<label>公司名称</label> <select name="companyId" id="companyId">
					<option value="">--请选择--</option>
					<option <c:if test="${1 == item.id }">selected="selected"</c:if> value="1">公司一</option>
					<c:forEach items="${companyList }" var="item">
						<option <c:if test="${productVO.companyId == item.id }">selected="selected"</c:if> value="${item.id }">${item.companyName }</option>
					</c:forEach>
				</select> <label>产品名称:</label> <input name="productName" type="text" value="${productVO.productName }">
				<div>
					<label>显示条数&nbsp;&nbsp;</label>
					<div>
						<select id="pageSize" name="pageSize">
							<option <c:if test="${productVO.pageSize == 10}"> selected="selected"</c:if> value="10">10</option>
							<option <c:if test="${productVO.pageSize == 20}"> selected="selected"</c:if> value="20">20</option>
							<option <c:if test="${productVO.pageSize == 50}"> selected="selected"</c:if> value="50">50</option>
							<option <c:if test="${productVO.pageSize == 100}"> selected="selected"</c:if> value="100">100</option>
						</select>
					</div>
					<input type="submit" value="提交">
				</div>
			</form>
		</div>
		<div>
			<table>
				<thead>
					<tr>
						<th class="center">序号</th>
						<th class="center">产品名称</th>
						<th class="center">产品价格</th>
						<th class="center">生产时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list}" var="product" varStatus="index">
						<tr>
							<td align="center">${index.index+1 }</td>
							<td>${product.productName }</td>
							<td>${product.productPrice }</td>
							<td>${product.productTime }</td>
							<td align="center"><a href="javascript:;" onclick="_toUpdateUser('${product.id}');" class="link2 cu" title="编辑"></td>
							<td align="center"><a href="javascript:;" onclick="_toDeleUser('${product.id}');" class="link2 cu" title="删除"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
								
	</div>
</body>
</html>