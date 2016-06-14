var temmerchantName="";
$(function(){ 
	
	queryByProductId();	 
	$("#productId").hide();
});
function queryByProductId(){
	var paras = location.search;
	var result = paras.match(/([^\?&]*=[^&]*)/g);
	var temp;
	paras = {};
	var pr=$("#productId").val();
	for(var i in result){
	    temp = result[i].split('=');
	    paras[temp[0]] = temp[1];
	}
	if(paras.productId==null){
		paras.productId=pr;
	}
	URL="productjsonQuery.action";
	$.ajax({
        url : URL,
        type : 'POST',
        async: false, 
        dataType : 'json', 
        data:{"productId":paras.productId},
        success : function(data) {
			var str="";
			temmerchantName=data[0].merchantName;
			$("#productInfoList").empty();
			if(data==null){
				alert("商品不存在！");
			}
			else{
				$.ajax({
			        url : "productjsonCategory.action",
			        type : 'POST',
			        async: true, 
			        dataType : 'json', 
			        data:{"productType":data[0].productType},
			        success : function(dataType) {
			        	$("#productType").html("所属类目："+dataType[0].categoryName);
			        }
				});
				$.ajax({
			        url : "queryByUserName.action",
			        type : 'POST',
			        async: true, 
			        dataType : 'json', 
			        data:{"userName":data[0].merchantName},
			        success : function(dataMerchantName) {
			        	$("#merchantName").html("商家："+dataMerchantName[0].nickName+"&nbsp&nbsp&nbsp手机："+dataMerchantName[0].userPhone+"&nbsp&nbspQQ："+dataMerchantName[0].QQ);
			        }
				});
				$("#productindex").attr("src",data[0].indexPictuer);
				$("#productName").html(data[0].productName);
				$("#productPrice").html("参考价"+data[0].productPrice);
				$("#discountPrice").html("促销价"+data[0].discountPrice);
				$("#simpleDescribe").html("&nbsp&nbsp&nbsp&nbsp"+data[0].simpleDescribe);
				$("#inventoryNum").html("库存数量："+data[0].inventoryNum+"&nbsp&nbsp"+"卖出数量："+data[0].saleNum);
				$("#merchantName").html("商家："+data[0].inventoryNum+"&nbsp&nbsp"+"卖出数量："+data[0].saleNum);
				$.ajax({
			        url : "productjsonDescribe.action",
			        type : 'POST',
			        async: true, 
			        dataType : 'json', 
			        data:{"productId":data[0].productId},
			        success : function(dataEvaluate) {
			        	var strcomment = '<li><h2 class="fg-green">商品评价</h2></li>';
						var strevaluate = '<li><h2 class="fg-green">商品展示</h2></li>';
						var j=0;
						for(var i=0;i<dataEvaluate.length;i++){
							if(dataEvaluate[i].describeType==1){
								strevaluate+='<li><h2 id="evaluate'+dataEvaluate[i].describeId+'" class="fg-green">'+dataEvaluate[i].describeCharacter+'</h2></li></br>'+
											 '<li><img id="evaluate'+dataEvaluate[i].describeId+'" class="span10" src="'+dataEvaluate[i].describePicture+'" ></img></li>';
							}
							else{
								strcomment+='<li><h2 id="evaluate'+dataEvaluate[i].describeId+'" class="fg-green">'+dataEvaluate[i].describeUser+'</h2>'+dataEvaluate[i].describeCharacter+'</li>';	
							}
						}
						$("#evaluation").append(strevaluate);
						$("#comment").append(strcomment);
						for(var i=0;i<dataEvaluate.length;i++){
							if(dataEvaluate[i].describeType==1){
								continue;
							}
							j=dataEvaluate[i].describeId;
							$.ajax({
						        url : "queryByUserName.action",
						        type : 'POST',
						        async: false, 
						        dataType : 'json', 
						        data:{"userName":dataEvaluate[i].describeUser},
						        success : function(dataMerchant) {
						        	$("#evaluate"+j).html(dataMerchant[0].nickName);
						        },
						        error : function(dataEvaluate) {
						        	alert("出错了");	
								}
							});
						}
			        },
			        error : function(dataEvaluate) {
			        	alert("ERROR");	
					}
				});
				$.ajax({
			        url : "productjsonHotProduct.action",
			        type : 'POST',
			        async: true, 
			        dataType : 'json', 
			        data:{"productType":data[0].productType},
			        success : function(dataProduct) {
			        	var strhot = "";
						for(var i=0;i<dataProduct.length;i++){
							if(dataProduct[i].productId==data[0].productId){
								continue;
							}
							var URL="productftlPage.action?productId="+dataProduct[i].productId;
							strhot+='<li><a href="'+URL+'"><img id="HotProduct'+dataProduct[i].productId+'" class="span3" src="'+dataProduct[i].indexPictuer+'" ></img></a></li>'+
										'<li><a href="'+URL+'" class="fg-green">'+dataProduct[i].productName+'&nbsp&nbsp'+dataProduct[i].productPrice+'</a></li></br>';		
						}
						$("#hotsale").append(strhot);
			        },
			        error : function(dataProduct) {
			        	alert("错误");	
					}
				});
			}
		},//end of success
		error : function(data) {
        	alert("ERROR");	
		}
	});
}


function onbuynow(){
	var merchantName=getCookie('userName');
	if(merchantName==null||merchantName==""){
		window.location.replace("loginftlPage.action");
	}
	else{
		var number=$("#buynumber").val();
		var paras = location.search;
		var result = paras.match(/([^\?&]*=[^&]*)/g);
		var temp;
		paras = {};
		var pr=$("#productId").val();
		for(var i in result){
		    temp = result[i].split('=');
		    paras[temp[0]] = temp[1];
		}
		if(paras.productId==null){
			paras.productId=pr;
		}
		var productId=paras.productId;
		var discountPrice=$("#discountPrice").text();
		var userName=getCookie('userName');
		
		$.ajax({
	        url : "orderjsonInsertForm.action",
	        type : 'POST',
	        async: true, 
	        dataType : 'json', 
	        data:{"productId":productId,"number":number,"userName":userName,"merchant":temmerchantName,"transactionPrice":discountPrice},
	        success : function(dataEvaluate) {
	        	alert(userName+"以"+discountPrice+"购买了"+number+"个"+temmerchantName+"的"+productId+"请关注用户中心订单管理");
	        }
		});
	}
}
