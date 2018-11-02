<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员新增</title>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!-- Css for boot -->
<link href="${ctx}/static/public/css/boot.css" rel="stylesheet" type="text/css" />
<!--Admin Core Css-->
<link href="${ctx}/static/public/css/admin.css" rel="stylesheet" type="text/css" />
<!-- My Fonts -->
<link href="${ctx}/static/lib/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
<!--Tree Menu-->
<link href="${ctx}/static/lib/tree-menu/tree.css" rel="stylesheet" type="text/css" />
<!--jquery-->
<script src="${ctx}/static/public/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<!--layer JS-->
<script src="${ctx }/static/lib/layer/layer.js" type="text/javascript"></script>

<style>
label {
	margin: 0px;
}

.form-control {
	padding: 0px;
	border-radius: 0px;
}
</style>


<script type="text/javascript">

	function _doAddProduct() {
		var url = "${ctx}/product/do_add_product";
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
	 

	function _toBack(){
		location.href = "${ctx }/product/to_product_list";
	}
	
</script>

</head>

<body>
	<div class="row">
		<div class="col-lg-12 now_position">
			<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 14px;">&#xe62d;</i>
			&nbsp;产品新增
		</div>
	</div>
	<div class="space1"></div>
	<div class="space1"></div>
	<div class="space1"></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<form id="productForm">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="pull-left list_name">产品新增</div>
							<div class="pull-right"></div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="">
										<div class="form_gridinner">
											<div class="row">
												<div class="clear"></div>
											</div>
											<div class="row form-group">
												<label class="col-lg-2 form_name"><span class="red">*</span>产品公司&nbsp;&nbsp;</label>
												<div class="col-lg-4">
													<select class="form-control" id="corp" name="companyId" >
														<option value="">--请选择--</option>
														<c:forEach items="${companyList }" var="company">
															<option value="${company.id}">${company.companyName }</option>
														</c:forEach>
													</select>
												</div>
												<div class="space1"></div>
												<div class="space1"></div>
												<label class="col-lg-2 form_name">产品名称&nbsp;&nbsp;</label>
												<div class="col-lg-10">
													<input type="text" class="form-control" id="parentIframe" name="productName" />
												</div>
												<div class="space1"></div>
												<div class="space1"></div>
												<label class="col-lg-2 form_name">产品价格&nbsp;&nbsp;</label>
												<div class="col-lg-10">
													<input type="text" class="form-control" id="parentIframe"
														name="productPrice" />
												</div>
												<div class="space1"></div>
												<div class="space1"></div>
												<label class="col-lg-2 form_name">进货时间&nbsp;&nbsp;</label>
												<div class="col-lg-10">
													<input type="text" class="form-control" id="parentIframe" name="productTimeStr"  value="<%=(new java.util.Date()).toLocaleString()%>" />
												</div>
												<div class="clear"></div>
											</div>
										</div>
									</div>
								</div>
								<div class="clear"></div>
							</div>
						</div>
						<div class="panel-footer">
							<a href="javascript:;" onclick="_doAddProduct()" class="btn btn-sm btn-primary pull-right publish" style="width: 100px; margin-left: 10px;">
								<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 14px;">&#xe60a;</i>
								&nbsp;&nbsp;保存
							</a>
							<a href="javascript:;" onclick="_toBack();" class="btn btn-sm btn-default pull-right" style="width: 100px; margin-left: 10px;">
								<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 14px;">&#xe60c;</i>
								&nbsp;&nbsp;返回
							</a>
							<div class="clear"></div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>