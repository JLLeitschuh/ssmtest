<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>this title</title>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!--jquery-->
<script src="${ctx}/static/public/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<!-- 弹窗插件 -->
<script src="${ctx }/static/lib/layer/layer.js" type="text/javascript"></script>
<!-- 分页插件 -->
<script src="${ctx}/static/lib/laypage/laypage.js"></script>
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
					$("#userForm").submit();
				}
			}
		});

		//搜索
		$('#user_search').on('click', function() {
			$("input[name='pageNum']").val(1);
			$("#userForm").submit();
		});

		$("#corpId option").each(function() {
			if ($(this).val() == '${vo.corpId}') {
				$(this).attr("selected", "selected");
			}
		});

		$("#roleId option").each(function() {
			if ($(this).val() == '${vo.roleId}') {
				$(this).attr("selected", "selected");
			}
		});
	});

	function _toAddUser() {
		location.href = "${ctx }/func/user/to_add_user";
	}

	function _toUpdateUser(userId) {
		location.href = "${ctx }/func/user/to_update_user?userId=" + userId
	}
</script>
</head>


<body>
	<div>
		<div>
			<h1 align="center">列表页面</h1>
			<form action="to_produtct_list" method="post">

				<label>公司名称</label> <select name="companyId" id="companyId">
					<option value="">--请选择--</option>
					<option <c:if test="${1 == item.id }">selected="selected"</c:if> value="1">公司一</option>
					<c:forEach items="${companyList }" var="item">
						<option <c:if test="${vo.corpId == item.id }">selected="selected"</c:if> value="${item.id }">${item.name }</option>
					</c:forEach>
				</select> <label>产品名称:</label> <input name="productName" type="text" value="${vo.productName }">
				<div class="row form-group">
					<label class="col-lg-1 form_name">显示条数&nbsp;&nbsp;</label>
					<div class="col-lg-2">
						<select class="form-control" id="pageSize" name="pageSize">
							<option <c:if test="${vo.pageSize == 10}"> selected="selected"</c:if> value="10">10</option>
							<option <c:if test="${vo.pageSize == 20}"> selected="selected"</c:if> value="20">20</option>
							<option <c:if test="${vo.pageSize == 50}"> selected="selected"</c:if> value="50">50</option>
							<option <c:if test="${vo.pageSize == 100}"> selected="selected"</c:if> value="100">100</option>
						</select>
					</div>
					<label class="col-lg-1 form_name"></label>
					<div class="col-lg-2 pull-right">
						<a href="javascript:" id="product_search" class="btn btn-primary btn-xs" style="width: 80%;"> 搜索 </a> <a href="${pageContext.request.contextPath}/to_produtct_list">搜索2</a>
					</div>
				</div>
			</form>
		</div>
		<div>
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
							<td align="center"><a href="javascript:;" onclick="_toUpdateUser('${productlist.id}');" class="link2 cu" title="编辑"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div align="right" class="page font1">
					<div id="div_page"></div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>