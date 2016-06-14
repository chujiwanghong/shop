<!DOCTYPE html>
<html lang="en">
	<head>
		<link rel="stylesheet" href="css/metro-bootstrap.min.css">
		<link rel="stylesheet" href="css/metro-bootstrap-responsive.css">
		<link rel="stylesheet" href="css/iconFont.css">
		<style type="text/css">
			.row{width:1200px;}
			.span2{width:150px;float:left;margin-left:10px;}
			.span12{width:1000px;float:right;}
			#hotSale{width:140px;float:left;margin:0 auto;}
			#zzzz{clear:both;}
		</style>
		<script src="js/api/jquery-1.7.1.min.js"></script>
		<script src="js/api/jquery-ui-1.9.2.custom.min.js"></script>
		<script src="js/api/metro.min.js"></script>
		<script type="text/javascript" src="js/menubar.js"></script>
		<script type="text/javascript" src="js/homeftlPage.js"></script>
		<title>${SYSTEM_NAME}首页</title>
	</head>
	<body class="metro center" >
		<div id="menubar">
		</div>
        <div class="container">
        	<div id="searchdiv" style="text-align: center;">
        		</br></br></br>
        		<input type="text" name="mutexIds" id="search" style="width:300px;" onkeypress="enterAction(event);"/>
				<input type="button"  class="button bg-green fg-white "  onclick="queryByProductId();" value="搜索"></button>&nbsp&nbsp;
        	</div>
            <div class="grid no-margin">
                <div class="row">
               		 <div class="span2 bg-white">
                   			<span class="fg-emerald" id="hotsale">热卖推荐</span>
                    	<ul class="unstyled" id="hotSale">	
						</ul>
				  	 </div>
                    <div id="categoryuldiv" class="span12 no-tablet-portrait no-phone " >
                       	<ul class="unstyled " id="categoryul">
						</ul>
                    </div>
                    <div id="zzzz"></div>
               </div>
           </div>
       </div>
	</body>
</html>
