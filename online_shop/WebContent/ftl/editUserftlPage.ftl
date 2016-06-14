<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/metro-bootstrap.min.css">
		<link rel="stylesheet" href="css/metro-bootstrap-responsive.css">
		<link rel="stylesheet" href="css/iconFont.css">
		<script src="js/api/jquery-1.7.1.min.js"></script>
		<script src="js/api/jquery-ui-1.9.2.custom.min.js"></script>
		<script src="js/api/metro.min.js"></script>
		<script type="text/javascript" src="js/menubar.js"></script>
		<script type="text/javascript" src="js/editUserftlPage.js"></script>
		<style>.center
				{
					margin:auto;
					width:60%;
					background-color:#b0e0e6;
				}
		</style>
		<title>${SYSTEM_NAME}用户信息页面</title>
	</head>
	<body class="metro center">
		<div id="menubar">
		</div>
		<div> 
		<div class="page secondary">
			<div class="page-header">
				<div class="page-header-content" align="center" >
					</br></br>
					<span class="fg-darkGreen " style="font-size:25px;">${SYSTEM_NAME}用户信息</span>
				</div>
			</div>
 
			<div class="page-region">
				<div class="page-region-content" >
					<ul class="unstyled">	
			    		<li><span class="fg-emerald">用户名</span> <input type="text" id="userName" class="user" onchange="onchangeUser();"></input> <span class="fg-darkGreen">用户的唯一标识，不可重复，至少4位，不能包含特殊字符</span></li>
			    		</br></br>
			    		<li><span class="fg-emerald">密码</span> <input type="password" class="user" id="passWord" ></input> <span class="fg-darkGreen">至少6位</span></li>
			    		</br>
			    		<li><span class="fg-emerald">再次输入密码</span> <input type="password" class="user" id="repassWord" ></input></li>
			    		</br></br>
			    		<li><span class="fg-emerald">昵称</span> <input type="text" class="user" id="nickName" ></input></li>
			    		</br></br>
			   			<li><span class="fg-emerald">现居住地（默认收货地址）：</span> </li>
			    		<li>
			    			<select class="fg-lime" name="provinceInfoSelect" id="provinceInfoSelect" onchange="provinceInfoSelectChange();" editable="false"  style="width:10%;" >			
			   			 		<option value="0">请选择</option>
							</select>
							<select class="fg-lime" name="cityInfoSelect" id="cityInfoSelect" onchange="cityInfoSelectChange();" editable="false"  style="width:10%;" >			       		
			    				<option value="0">请选择</option>
							</select>
							<select class="fg-lime" name="districtInfoSelect" id="districtInfoSelect" onchange="districtInfoSelectChange();" editable="false"  style="width:10%;" >			       		
			    				<option value="0">请选择</option>
							</select>
							<input type="text" style="width:25%;" id="detailAddress" class="user" onchange="detailAddresschange();" ></input>
							</br>
							<span class="fg-emerald" id="detailAddressinfo" ><span>
						</li> 
						</br>
			    		</br></br>
			    		<li><span class="fg-emerald">手机号</span> <input type="text"  class="user" id="userPhone" ></input> <span class="fg-darkGreen">请填写正确的手机号，不然无法收货</span></li>
			    		</br></br>
			    		<li><span class="fg-emerald">QQ号</span> <input type="text" class="user" id="QQ" ></input> <span class="fg-darkGreen">QQ用于与卖家沟通</span></li>
			    		</br></br>
			    		<li><span class="fg-emerald">预留信息</span> <input type="text" class="user" id="reservedInformation" ></input> <span class="fg-darkGreen">用于验证敏感操作</span></li>
			    		</br>
						<li><input type="button" class="bg-color-grayDark" id="reset"  onclick="reset();" value="重置" />&nbsp&nbsp&nbsp&nbsp
							<input type="button" class="button success" id="regist"  onclick="regist();" value="注册" />
							<span id = "editedUserName" class="fg-emerald" >${editedUserName?if_exists }</span>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>
