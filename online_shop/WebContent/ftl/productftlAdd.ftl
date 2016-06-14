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
		<script type="text/javascript" src="js/productftlAdd.js"></script>
		<title>${SYSTEM_NAME}商品信息编辑</title>
	</head>
	<body style="background-color: #efeae3" class="metro center" >
		<div id="menubar">
		</div>
        <div class="container">
        	<div  style="text-align: center;">
        		</br>
        			<h2>${SYSTEM_NAME}商品信息编辑<h2>
        	</div>
            <div class="grid no-margin" >
                <div class="row" >
                	<div class="span3">
                		<span name="merchant" id="merchant"></span>
                	</div>
	             <div class="span10 no-tablet-portrait no-phone " >
	                 <form method="POST" enctype="multipart/form-data" action="uploadimg.action"  >
                       	<ul class="unstyled " id="categoryul">
                       		<li><span class="fg-emerald">商品名称：</span> <input type="text" id="productName" name="productName"></input> <span class="fg-darkGreen">首页仅展示名称，谨慎填写</span></li>
                       		</br></br>
                       		<li><span class="fg-emerald">所属类目：</span> <input type="text" id="productType" name="productType"></input> <span class="fg-darkGreen">类目关系到搜索排名，谨慎填写</span></li>
							</br></br>
							<li><span class="fg-emerald">产品价格：</span> <input type="text" id="productPrice" name="productPrice" ></input> <span class="fg-darkGreen">产品价格，谨慎填写</span></li>
							</br></br>
							<li><span class="fg-emerald">促销价格：</span> <input type="text" id="discountPrice" name="discountPrice"></input> <span class="fg-darkGreen">促销价格是最终成交价，谨慎填写</span></li>
							</br></br>
							<li><span class="fg-emerald">库存数量：</span> <input type="text" id="inventoryNum" name="inventoryNum" ></input> <span class="fg-darkGreen">库存数量，谨慎填写</span></li>
							</br></br>
							<li><span class="fg-emerald">简单描述：</span> <input type="text" id="simpleDescribe" name="simpleDescribe"></input> <span class="fg-darkGreen">简单描述，谨慎填写</span></li>
							</br></br>
							<input type="text" id="merchantName" name="merchantName"></input>
							<li><span class="fg-emerald">详细描述：</span></br>
							<li><input type="file" id="upload" name="upload"><br/>
		  					<li><span class="fg-emerald">图片描述：</span><input type="text" name="note">
		  					<br/><br/>
		  					<input type="button" id="tianjia" class="button success" onclick="addEvaluate();" value="添加详细描述"></inout>
		  					
						</ul>
					<input type="submit" id="submit" class="button success" value="提交" "> 
					</form>
                    </div> 
               </div>
           </div>
       </div>
	</body>
</html>
