<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/metro-bootstrap.min.css">
		<link rel="stylesheet" href="css/metro-bootstrap-responsive.css">
		<link rel="stylesheet" href="css/iconFont.css">
		<script src="js/api/jquery-1.7.1.min.js"></script>
		<script src="js/api/jquery-ui-1.9.2.custom.min.js"></script>
		<script src="js/api/metro.min.js"></script>
		<script src="js/menubar.js"></script>
		<script src="js/userCenterftlPage.js"></script>
		
		<style>.left
				{
					position:absolute;
					left:10%;
					background-color:#b0e0e6;
				}
		</style>
		<style>.right
				{
					position:absolute;
					left:20%;
					margin-right:10%;
					
				}
		</style>
		<title>${SYSTEM_NAME}用户信息页面</title>
	</head>
	<body class="metro center">
		<div id="menubar">
		</div>
		<div>
			<span class="fg-darkGreen " style="font-size:25px;" >${SYSTEM_NAME}用户中心</span>
			</br></br></br>
		</div>
		<div>
			<div class="left page-sidebar" style="background-color:rgb(239, 234, 227);">
				
					<ul class="unstyled" >
						<li class="sticker" ><a  id="personalInfo"  href="#"   onclick="javascript:void(0);">个人信息</a></li>
						</br>
						<li class="sticker" ><a  id="orderManager"  href="#"   onclick="javascript:void(0);">订单管理</a></li>
					</ul>
			</div>
			<div class="right">
				<!--用户管理-->
				<div id ="userManagementdiv" class="usetohide">
					<span class="tit">用户管理：</span>
					<input type="text" name="mutexIds" id="search" />
					<input type="button"  class="button fg-green"  onclick="queryByUserName();" value="查询"></button>&nbsp&nbsp
					<a class="bg-white" id ="addUser" href="editUserftlPage.action"  onclick="javascript:void(0);" >添加用户</a>
					<table class="table hovered fg-lightGreen" style="text-align: center;" >
						<thead>
							<tr>
								<th>用户名</th>
								<th>密码</th>	
								<th>用户昵称</th>	
								<th>用户类型</th>
								<th>创建时间</th>
								<th>手机号</th>
								<th>QQ号</th>
								<th>用户地址</th>
								<th>预留信息</th>
								<th>操作</th>			
							</tr>
						</thead>
						<tbody  id="userInfoList" >
						</tbody>
					</table>
				</div>
				<!--订单查询-->
				<div id ="orderManagerdiv" class="usetohide">
					<span class="tit">订单管理：</span>
					<input type="text" name="mutexIds" id="searchorder" />
					<input type="button"  class="button fg-green"  onclick="orderManager();" value="查询"></button>
					<table class="table hovered fg-lightGreen" style="text-align: center;" >
						<thead>
							<tr>
								<th>订单编号</th>
								<th>商家名</th>	
								<th>用户名</th>	
								<th>下单时间</th>
								<th>付款时间</th>
								<th>发货时间</th>
								<th>收货时间</th>
								<th>收款时间</th>
								<th>收货地址</th>
								<th>快递公司</th>
								<th>快递单号</th>
								<th>订单总价</th>	
								<th>订单状态</th>
								<th>操作</th>		
							</tr>
						</thead>
						<tbody  id="orderInfoList" >
						</tbody>
					</table>
				</div>
				<!--订单操作-->
				<div id ="odercontrodiv" class="usetohide">
					<ul class="unstyled">	
			    		<li><span class="fg-emerald" id="order"></span></li>
			    		</br></br>
			    		<li><span class="fg-emerald" id="ordermerchant"></span></li>
			    		</br></br>
			    		<li><span class="fg-emerald" id="orderuser"></span></li>
			    		</br></br>
			    		<li><span class="fg-emerald" id="orderTime"></span></li>
			    		</br></br>
			    		<li><span class="fg-emerald" id="payTime"></span></li>
			    		</br></br>
			    		<li><span class="fg-emerald" id="deliverTime"></span></li>
			    		</br></br>
			    		<li><span class="fg-emerald" id="receiptTime"></span></li>
			    		</br></br>
			    		<li><span class="fg-emerald" id="getTime"></span></li>
			    		</br></br>
			    		<li><span class="fg-emerald" id="address"></span></li>
			    		</br></br>
			    		<li><span class="fg-emerald" id="totalPrice"></span></li>
			    		</br></br>
			    		<li><span class="fg-emerald" id="status"></span></li>
			    		</br></br>
			    		<li>
			    		<table class="table hovered fg-lightGreen" style="text-align: center;" >
						<thead>
							<tr>
								<th>商品ID</th>
								<th>商品名称</th>
								<th>成交价格</th>	
								<th>购买数量</th>		
							</tr>
						</thead>
						<tbody  id="oderproductList" >
						</tbody>
					</table></li>
					<li class="oderxpress"><span class="fg-emerald " >快递公司</span><input type="text" id="xpressCompany" ></input></li>
			    		</br></br>
			    		<li class="oderxpress" ><span class="fg-emerald " >快递单号</span><input type="text" id="xpressNumber" ></input></li>
			    		</br></br>
						<li id="addbution"></li>
					</ul>
				</div>
				<!--产品管理-->
				<div id ="productInfodiv" class="usetohide">
					<span class="tit">商品管理：</span>
					<input type="text" name="mutexIds" id="searchproduct" />
					<input type="button"  class="button fg-green"  onclick="queryByProductId();" value="查询"></button>&nbsp&nbsp
					<a class="bg-white" id ="addProduct" href="productftlAdd.action"  onclick="javascript:void(0);" >添加商品</a>
					<table class="table hovered fg-lightGreen" style="text-align: center;" >
						<thead>
							<tr>
								<th>商品ID</th>
								<th>商品名称</th>
								<th>所属类目</th>	
								<th>商品价格</th>	
								<th>促销价格</th>
								<th>库存数量</th>
								<th>销售数量</th>
								<th>更新时间</th>
								<th>简单描述</th>
								<th>操作</th>			
							</tr>
						</thead>
						<tbody  id="productInfoList" >
						</tbody>
					</table>
				</div>
				<!--个人信息-->
				<div id ="personalInfodiv" class="usetohide">
					<ul class="unstyled">	
			    		<li><span class="fg-emerald">用户名</span> <input type="text" id="userName" disabled="disabled" class="user" onchange="onchangeUser();"></input> <span class="fg-darkGreen">用户的唯一标识，不可修改</span></li>
			    		</br></br>
			    		<li><span class="fg-emerald">密码</span> <input type="password" class="user" id="passWord" ></input> <span class="fg-darkGreen">至少6位</span></li>
			    		</br></br>
			    		<li><span class="fg-emerald">昵称</span> <input type="text" class="user" id="nickName" ></input> <span class="fg-darkGreen">用户名称</span></li>
			    		</br></br>
			   			<li><span class="fg-emerald">现居住地（默认收货地址）：</span> </li>
			    		<li><input type="text" style="width:80%;" id="detailAddress" class="user" onchange="detailAddresschange();" ></input></li> 
			    		</br></br>
			    		<li><span class="fg-emerald">手机号</span> <input type="text"  class="user" id="userPhone" ></input> <span class="fg-darkGreen">请填写正确的手机号，不然无法收货</span></li>
			    		</br></br>
			    		<li><span class="fg-emerald">QQ号</span> <input type="text" class="user" id="QQ" ></input> <span class="fg-darkGreen">QQ用于与卖家沟通</span></li>
			    		</br></br>
			    		<li><span class="fg-emerald">预留信息</span> <input type="text" class="user" id="reservedInformation" ></input> <span id ="reservedInformationcheck" class="fg-darkGreen">用于验证敏感操作</span></li>
			    		</br>
						<li>
							<input type="button" class="button success" id="regist"  onclick="regist();" value="修改" />
						</li>
					</ul>
				</div>
			</div>
		</div>
	</body>
	
</html>
