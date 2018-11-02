<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品管理</title>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!-- Css for boot -->
<link href="${ctx }/static/public/css/boot.css" rel="stylesheet" type="text/css" />
<!--Admin Core Css-->
<link href="${ctx }/static/public/css/admin.css" rel="stylesheet" type="text/css" />
<!-- My Fonts -->
<link href="${ctx }/static/lib/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
<!--Tree Menu-->
<link href="${ctx }/static/lib/tree-menu/tree.css" rel="stylesheet" type="text/css" />
<!--jquery-->
<script src="${ctx}/static/public/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<!-- 弹窗插件 -->
<script src="${ctx }/static/lib/layer/layer.js" type="text/javascript"></script>
<!-- 分页插件 -->
<script src="${ctx}/static/lib/laypage/laypage.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	// 初始化分页
	laypage({
		  cont: $("#div_page"), //容器。值支持id名、原生dom对象，jquery对象,
		  pages: '${pageInfo.pages}', //总页数
		  skin: 'yahei', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
		  groups: 7, //连续显示分页数
		  first: '首页',
	      last:'尾页',
	      prev:'上一页',
	      next:'下一页',
		  curr: function(){
			  return ${pageInfo.pageNum};
		  }(), 
	      jump: function(e, first){ //触发分页后的回调
	    	  if(!first){ //一定要加此判断，否则初始时会无限刷新
	          	  $("input[name='pageNum']").val(e.curr);
	          	  $("#productForm").submit();
	      	  }
		  }
	});
	
	//搜索
	$('#product_search').on('click',function(){
		 $("input[name='pageNum']").val(1);
		$("#productForm").submit();
	});
	
	$("#companyId option").each(function() {
		if ($(this).val() == '${vo.companyId}') {
		$(this).attr("selected", "selected");
		}
	});  
});

function _toAddProduct(){
	location.href = "${ctx }/product/to_add_product";
}

function _toUpdateProduct(productId){
	location.href = "${ctx }/product/to_update_product?productId="+productId
}

function doUpdateProduct() {
	var url = "${ctx}/product/do_delete_product";
	var param = $("#productForm").serialize();
	$.post(url, param, function(data) {
		data = eval("(" + data + ")");
		if (data.success) {
			layer.alert(data.msg, {
				icon : 6, btn:['确定'], title:'信息'
			}, function(index) {
				layer.close(index);
				window.location.href = "${ctx }/product/to_product_list";
			});
		} else {
			layer.alert(data.msg, {
				icon : 6, btn:['确定'], title:'信息'
			});
		}
	});

}
 function _toDeleteProduct(productId) {
	var url = "${ctx}/product/do_delete_product";
	var param = {
			"productId":productId
	}
	$.post(url, param, function(data) {
		data = eval("(" + data + ")");
		if (data.success) {
			layer.alert(data.msg, {
				icon : 6, btn:['确定'], title:'信息'
			}, function(index) {
				layer.close(index);
				window.location.href = "${ctx }/product/to_product_list";
			});
		} else {
			layer.alert(data.msg, {
				icon : 6, btn:['确定'], title:'信息'
			});
		}
	});
} 

</script>

<style>
label {
	margin: 0px;
}

.form-control {
	padding: 0px;
	border-radius: 0px;
}
</style>
</head>

<body>
	<div class="row">
		<div class="col-lg-12 now_position">
			<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 14px;">&#xe62d;</i>
				&nbsp;产品列表
		</div>
	</div>
	<div class="space1"></div>
	<div class="space1"></div>
	<div class="space1"></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body" style="padding-bottom: 0px;">
						<div class="row">
							<form id="productForm" action="${ctx }/product/to_product_list" method="post">
								<input type="hidden" name="pageNum" value="${pageInfo.pageNum }" />
								<div class="col-lg-12">
									<div class="row form-group">
										<label class="col-lg-1 form_name">公司名称&nbsp;&nbsp;</label>
										<div class="col-lg-2">
											<select class="form-control" name="companyId" id="companyId">
												<option value="">--请选择--</option>
												<%-- <option <c:if test="${1 == item.id }">selected="selected"</c:if> value="1">公司总部</option> --%>
												<c:forEach items="${companyList }" var="company">
													<option <c:if test="${vo.companyId == company.id }">selected="selected"</c:if> value="${company.id }">${company.companyName}</option>
												</c:forEach>
											</select>
										</div>
										<label class="col-lg-1 form_name">产品名称&nbsp;&nbsp;</label>
										<div class="col-lg-2">
											<input type="text" class="form-control" name="productName" value="${vo.productName}" />
										</div>
										<div class="clear"></div>
									</div>
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
											<a href="javascript:" id="product_search" class="btn btn-primary btn-xs" style="width: 80%;">
												<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 14px">&#xe611;</i>
												搜索
											</a>
										</div>
										<div class="clear"></div>
									</div>
								</div>
								<div class="clear"></div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="pull-left list_name">产品管理</div>
							<div class="pull-right">
								<a href="javascript:;" onclick="_toAddProduct();" class="btn btn-success btn-xs">
									<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 14px">&#xe612;</i>
									新增
								</a>
							</div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="table-responsive">
										<table
											class="table table-striped table-bordered table-hover table-minwidth">
											<thead>
												<tr>
													<th class="center">序号</th>
													<th class="center">产品名称</th>
													<th class="center">公司名称</th>
													<th class="center">产品价格</th>
													<th class="center">生产时间</th>
													<th class="center">操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${pageInfo.list }" var="product" varStatus="index">
													<tr>
														<td align="center">${index.index+1 }</td>
														<td>${product.productName }</td>
														<td>${product.companyName }</td>
														<td>${product.productPrice }</td>
														<td><fmt:formatDate value="${product.productTime}" pattern="yyyy-mm-dd HH:mm:ss"/></td>
														<%-- <td>${product.productTime }</td> --%>
														<td align="center">
															<a href="javascript:;" onclick="_toUpdateProduct('${product.id}');" class="link2 cu" title="编辑">
																编辑
															</a>
															<a href="javascript:;" onclick="_toDeleteProduct('${product.id}');" class="link2 cu" title="删除">
																删除
															</a>
															&nbsp;
                      									</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								<div class="clear"></div>
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
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>