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
		<script type="text/javascript" src="js/productftlPage.js"></script>
		<style>.left
				{
					position:absolute;
					left:10%;
				}
		</style>
		<style>.right
				{
					position:absolute;
					left:40%;
					margin-right:10%;	
				}
		</style>
		<style>.midlle
				{
					position:relative;
					top:50%;
					margin-right:20%;	
				}
		</style>
		<style>.buy
				{
					position：fixed
					left:50%;
					top:40%;
				}
		</style>
		<title>${SYSTEM_NAME}商品信息页面</title>
	</head>
	<body class="metro center">
		<div id="menubar">
		</div>
		<div style="position:fixed; right:-8%; top:35%; ">
			<input type="button" class="button success" value="立即购买" onclick="onbuynow();">
			<input id="buynumber" type="text" style="width:10%" value="1">	
		</div>
		<div id = "producttop" >	
			<div id="productPicture" class="span4 left">
				<img id="productindex" class="span5" style="overflow:hidden;height:250px" ></img>
			</div>	
			<div name="productName" class="right">
				<input type="text" id="productId" value=${productId}></span>
				<h1 id="productName" class="fg-green"></h1>
				<h4 id="simpleDescribe" class="fg-cyan">  </h2>
				<h2 id="productType" class="fg-green"></h2>
				<h2 id="productPrice" ></h2>
				<h1 id="discountPrice" class="fg-red"></h1>
				<h2 id="inventoryNum" class="fg-green"></h2>
				<h3 id="merchantName" class="fg-green"></h2>
			</div>
		</div>
		<div id ="productmiddle" class="midlle">
			<div id ="productmiddle" class="left"  style="left:0%;">
				<span  class="fg-green" style="font-size:20px"> 同类型热卖推荐：</span>
				<ul class="unstyled" id="hotsale">
					
				</ul>
			</div>
			<div class="right"  style="left:30%;">
				<ul class="unstyled" id="evaluation">	
				</ul>
				<ul class="unstyled" id="comment">	
				</ul>
			<div>
			
		</div>
		
	</body>
</html>
