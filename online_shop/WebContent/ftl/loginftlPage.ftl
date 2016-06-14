<!DOCTYPE html>
<html lang="en">
	<head>
		<link rel="stylesheet" href="css/metro-bootstrap.min.css">
		<link rel="stylesheet" href="css/metro-bootstrap-responsive.css">
		<link rel="stylesheet" href="css/iconFont.css">
		<script src="js/api/jquery-1.7.1.min.js"></script>
		<script src="js/api/jquery-ui-1.9.2.custom.min.js"></script>
		<script src="js/api/metro.min.js"></script>
		<script type="text/javascript" src="js/menubar.js"></script>
		<script src="js/loginftlPage.js"></script>
		<title>${SYSTEM_NAME}登录页面</title>	
	</head>
	<body class="metro center">
		<div id="menubar">
		</div>
 		<div  align="center" >
 		<ul class="unstyled">	
		    <li><span class="fg-darkGreen" style="font-size:20px">欢迎登录${SYSTEM_NAME}</span></li>
		    </br>
		    <li><span class="fg-emerald">用户名</span> <input type="text" id="userName" onchange="onchangeUser();"></input></li>
		    </br>
		    </br>
		    <li><span class="fg-emerald">密&nbsp&nbsp&nbsp码</span> <input type="password" id="passWord" ></input></li>
		    </br>
			<li><input type="button" class="button success" id="loadingon"  onclick="loadingon();" value="登录" />
				<input type="button" class="bg-color-grayDark" id="regist"  onclick="regist();" value="注册" />
			</li>
		</ul>
		</div> 
	</body>
</html>