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
		<script type="text/javascript" src="js/address.js"></script>
		<title>地址选择页面</title>
	</head>
	<body class="metro">
	<h1>地址选择</h1>
	<div id="div" class="input-control select">	
		<select name="provinceInfoSelect" id="provinceInfoSelect" onchange="provinceInfoSelectChange();" editable="false"  style="width:135px;" >			
		    <option value="0">请选择</option>
		</select>
		<select name="cityInfoSelect" id="cityInfoSelect" onchange="cityInfoSelectChange();" editable="false"  style="width:135px;" >			       		
		    <option value="0">请选择</option>
		</select>
		<select name="districtInfoSelect" id="districtInfoSelect" onchange="districtInfoSelectChange();" editable="false"  style="width:135px;" >			       		
		    <option value="0">请选择</option>
		</select> 
		</br>
		</br> 
		<li><span class="fg-color-green" id="address"></span></li>
		</br>
		<div id="login_div" >
		<div style="padding: 10px" class="content">
				<label>用户名</label>
				<div class="input-control text">
					<input name="username" type="text">
				</div>
				<div class="input-control password">
       				 <input type="password" />
        			<button class="helper"></button>
   				 </div>

				<br/>
					<div id="alt_div" style="color: red"></div>
				<br/>
				<div class="form-actions">
					<button class="button primary" onclick="login()">确定</button>
					&nbsp;
					<button class="button" type="button" onclick="$.Dialog.close()">取消</button>
				</div>
		</div>
	</div>
	</body>
</html>
