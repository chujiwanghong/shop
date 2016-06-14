var reservedInformationold="";
var speed=1000;  //窗口刷新速度
$(function(){ 
	$("div.usetohide").hide();
	$("#personalInfo").bind('click', personalInfo);
	$("#orderManager").bind('click', orderManager);
	init();
});

//根据用户类型初始化用户中心
function init(){
	var userType=$("#usertype").text();
	if(userType=="商家"){
		$("#orderManager").after('</br></br><li class="sticker"><a  id="productManagement"  href="#"   onclick="javascript:void(0);">商品管理</a></li>');
		$("#productManagement").bind('click', queryByProductId);
	}
	else if(userType=="管理员"){
		$("#orderManager").after('</br></br><li class="sticker"><a  id="userManagement"  href="#"   onclick="javascript:void(0);">用户管理</a></li>');
		$("#userManagement").bind('click', queryByUserName);
		$("#userManagement").after('</br></br><li class="sticker"><a  id="productManagement"  href="#"   onclick="javascript:void(0);">商品管理</a></li>');
		$("#productManagement").bind('click', queryByProductId);
	}
}

//格式化long类型的时间为年月日时分秒
function formatLongTimeToTime(time){
	var date = new Date(time);
	if(time==3784118400000){
		return "暂无";
	}
	else{
		return date.getFullYear() + '.'+ (date.getMonth() + 1) + '.'+ date.getDate()+" "+date.getHours()+":"
				+(date.getMinutes()<10?"0":"")+date.getMinutes()+":"+(date.getSeconds()<10?"0":"")+date.getSeconds();
	}
}

//订单查询页面
function orderManager(){
	var userType=getCookie('userType');
	var name=getCookie('userName');
	var userName="";
	var merchant="";
	if(userType=="会员"){
		userName=name;
	}
	else{
		merchant=name;
	}
	$("div.usetohide").hide(speed);
	$("#orderManagerdiv").show(speed);
	var orderId=$("#searchorder").val();
	if(orderId==null||orderId==""){
		orderId=0;
	}
	
	$.ajax({
        url : "orderjsonQueryForm.action",
        type : 'POST',
        async: true, 
        dataType : 'json', 
        data:{"merchant":merchant,"orderId":orderId,"userName":userName},
        success : function(data) {
			var str="";
			$("#orderInfoList").empty();
			if(data==null){
				alert("订单不存在！");
				$("#searchorder").val("");
				}
			else{
				for(var i=0;i<data.length;i++){
					var orderTime=formatLongTimeToTime(data[i].orderTime.time);
					var deliverTime=formatLongTimeToTime(data[i].deliverTime.time);
					var payTime=formatLongTimeToTime(data[i].payTime.time);
					var getTime=formatLongTimeToTime(data[i].getTime.time);
					var receiptTime=formatLongTimeToTime(data[i].receiptTime.time);
					var xpressNumber=data[i].xpressNumber;
					if(xpressNumber==0){
						xpressNumber="";
					}
					var status="";
					switch(data[i].status+1){
					case 1:status="等待买家付款";break;
					case 2:status="等待卖家发货";break;
					case 3:status="等待买家收货";break;
					case 4:status="等待卖家收款";break;
					case 5:status="订单完成";break;
					case 6:status="卖家取消订单";break;
					case 7:status="买家取消订单";break;
					case 8:status="卖家退货";break;
					}
					 str+='<tr>'
					 	 +'<td><span id="order'+i+'">'+data[i].orderId+'</span></td>'
						 +'<td> <span id="ordermerchant'+i+'">'+data[i].merchant+'</span></td>'
						 +'<td> <span id="orderuser'+i+'">'+data[i].userName+'</span></td>'
						 +'<td> <span id="orderTime'+i+'">'+orderTime+' </span></td>'
						 +'<td> <span id="payTime'+i+'">'+payTime+' </span></td>'
						 +'<td> <span id="deliverTime'+i+'">'+deliverTime+' </span></td>'
						 +'<td> <span id="receiptTime'+i+'">'+receiptTime+' </span> </td>'
						 +'<td> <span id="getTime'+i+'">'+getTime+' </span> </td>'
						 +'<td> <span id="address'+i+'" class="hhhh">'+data[i].address+'</span> </td>'
						 +'<td> <span id="xpressCompany'+i+'">'+data[i].xpressCompany+' </span> </td>'
						 +'<td><span id="xpressNumber'+i+'">'+xpressNumber+' </span>  </td>'
						 +'<td><span id="totalPrice'+i+'">'+data[i].totalPrice+'</span>  </td>'
						 +'<td> <span id="status'+i+'">'+status+' </span></td>'
						 +'<td><input type="button" class="button success" id="'+data[i].orderId+'" value="修改" onclick="ordermodify('+i+','+data[i].status+')"/></td></tr>';
				}
				$("#orderInfoList").append(str);
				$("span.hhhh").hide();
			}
		},//end of success
		error : function(data) {
        	alert("ERROR");	
		}
	});
}


//管理订单
function ordermodify(i,status){
	$("div.usetohide").hide(speed);
	$("#odercontrodiv").show(speed); 
	$("#order").text("订单ID："+$("#order"+i).text());
	$("#ordermerchant").text("商家："+$("#ordermerchant"+i).text());
	$("#orderuser").text("用户："+$("#orderuser"+i).text());
	$("#orderTime").text("下单时间："+$("#orderTime"+i).text());
	$("#payTime").text("付款时间："+$("#payTime"+i).text());
	$("#deliverTime").text("发货时间："+$("#deliverTime"+i).text());
	$("#receiptTime").text("收货时间："+$("#receiptTime"+i).text());
	$("#getTime").text("收款时间："+$("#getTime"+i).text());
	$("#address").text("收货地址："+$("#address"+i).text());
	$("#totalPrice").text("订单总价："+$("#totalPrice"+i).text());
	$("#status").text("订单状态："+$("#status"+i).text());
	$.ajax({
        url : "orderjsonQueryProduct.action",
        type : 'POST',
        async: false, 
        dataType : 'json', 
        data:{"orderId":$("#order"+i).text()},
        success : function(data) {
			var str="";
			$("#oderproductList").empty();
			if(data==null){
				alert("订单不存在！");
			}
			else{
				for(var i=0;i<data.length;i++){
					str+='<tr>'
					 	 +'<td><span >'+data[i].productId+'</span></td>'
					 	 +'<td><span id="orderproduct'+i+'">'+data[i].productId+'</span></td>'
						 +'<td>'+data[i].transactionPrice+'</td>'
						 +'<td> '+data[i].number+'</td></tr>';
				}
				$("#oderproductList").append(str);
				for(var i=0;i<data.length;i++){
					URL="productjsonQuery.action";
					$.ajax({
				        url : URL,
				        type : 'POST',
				        async: false, 
				        dataType : 'json', 
				        data:{"productId":data[i].productId},
				        success : function(datapr) {
				        	$("#orderproduct"+i).text(datapr[0].productName);
				        }
					});
				}
			}
        }
      });
	var statusnow="";
	switch(status+1){
		case 0:statusnow="生成订单";break;
		case 1:statusnow="买家付款";break;
		case 2:statusnow="卖家发货";break;
		case 3:statusnow="买家收货";break;
		case 4:statusnow="卖家收款";break;
		case 5: statusnow="订单完成";break;
	}
	$("#addbution").empty();
	$("#addbution").append('<input type="button" class="button success" id="managernow" value="'+statusnow+'" onclick="updatestatus('+i+','+status+');"/>');
	$("#xpressCompany").val("");
	$("#xpressNumber").val("");
	if(status==0){
		$("#xpressCompany").hide();
		$("#xpressNumber").hide();
	}
	else{
		$("#xpressCompany").show();
		$("#xpressNumber").show();
	}
	if(status>1){
		$("#xpressCompany").val($("#xpressCompany"+i).text());
		$("#xpressNumber").val($("#xpressNumber"+i).text());
	}
}

//更改订单状态
function updatestatus(i,status){
	var userName=getCookie('userName');
	var merchant=$("#ordermerchant"+i).text();
	//订单状态：0：订单生成 1：买家付款 2：卖家发货 3：买家收货 4：订单完成 5：卖家取消订单 6：买家取消订单 7：卖家退货
	if(userName==merchant){
		if(status==0||status==2){
			alert("请等待"+$("#orderuser"+i).text()+$("#managernow").val()+"！");
		}
		else if(status==1){
			$.ajax({
		        url : "orderjsonUpdateDeliver.action",
		        type : 'POST',
		        async: false, 
		        data:{"orderId":$("#order"+i).text(),"xpressCompany":$("#xpressCompany").val(),"xpressNumber":$("#xpressNumber").val()},
		        success : function() {
		        	alert("发货成功！");
		        }
			});
		}
		else if(status==3){
			$.ajax({
		        url : "orderjsonUpdateGet.action",
		        type : 'POST',
		        async: false, 
		        data:{"orderId":$("#order"+i).text()},
		        success : function() {
		        	alert("收款成功！");
		        }
			});
		}
		else {
			alert("您无权变更当前订单状态，请联系管理员！");
		}
	}else if(userName!=merchant){
		if(status==1||status==3){
			alert("请等待"+merchant+$("#managernow").val()+"！");
		}
		else if(status==0){
			$.ajax({
		        url : "orderjsonUpdatePay.action",
		        type : 'POST',
		        async: false, 
		        data:{"orderId":$("#order"+i).text()},
		        success : function() {
		        	alert("付款成功！");
		        }
			});
		}
		else if(status==2){
			$.ajax({
		        url : "orderjsonUpdateReceipt.action",
		        type : 'POST',
		        async: false, 
		        data:{"orderId":$("#order"+i).text()},
		        success : function() {
		        	alert("收货成功！");
		        }
			});
		}
		else {
			alert("您无权变更当前订单状态，请联系管理员！");
		}
	}
}



//查询用户信息
function personalInfo(){
	var userName=getCookie('userName');
	if (userName!=null && userName!=""){
		$("div.usetohide").hide(speed);
		$("#personalInfodiv").show(speed);
		URL="queryByUserName.action?userName="+userName;
		$.ajax({
	        url : URL,
	        type : 'POST',
	        async: true, 
	        dataType : 'json', 
	        contentType:false,
	        processData:true,
	        success : function(data) {
	        	$("#userName").val(data[0].userName);
	        	$("#passWord").val(data[0].passWord);
	        	$("#detailAddress").val(data[0].userAddress);
	        	$("#nickName").val(data[0].nickName);
	        	$("#userPhone").val(data[0].userPhone);
	        	$("#QQ").val(data[0].QQ);
	        	$("#reservedInformation").val("");	
	        	reservedInformationold=data[0].reservedInformation;
			},//end of success
			error : function(data) {
	        	alert("ERROR");	
			}
		});
	}else{
		window.location.replace("loginftlPage.action");
	}
}

//商家查询商品列表
function queryByProductId(){
	var merchantName=getCookie('userName');
	if (userName!=null && userName!=""){
		$("div.usetohide").hide(speed);
		$("#productInfodiv").show(speed);
		var productId=$("#searchproduct").val();
		if(productId==null||productId==""){
			productId=0;
		}
		URL="productjsonQuery.action";
		$.ajax({
	        url : URL,
	        type : 'POST',
	        async: true, 
	        dataType : 'json', 
	        data:{"merchantName":merchantName,"productId":productId},
	        success : function(data) {
				var str="";
				$("#productInfoList").empty();
				if(data==null){
					alert("商品不存在！");
					$("#searchproduct").val("");
					}
				else{
					for(var i=0;i<data.length;i++){
						var timecreat=formatLongTimeToTime(data[i].updateTime.time);
						 str+='<tr>'
						 	 +'<td><span id="product'+data[i].productId+'">'+data[i].productId+'</span></td>'
							 +'<td> '+data[i].productName+'</td>'
							 +'<td> <span id="productType'+data[i].productId+'">'+data[i].productType+'</span></td>'
							 +'<td> '+data[i].productPrice+' </td>'
							 +'<td> '+data[i].discountPrice+'</td>'
							 +'<td> '+data[i].inventoryNum+' </td>'
							 +'<td> '+data[i].saleNum+' </td>'
							 +'<td> '+timecreat+' </td>'
							 +'<td> '+data[i].simpleDescribe+' </td>'
							 +'<td><input type="button" class="button success" id="'+data[i].productId+'" value="修改" onclick="productmodify('+data[i].productId+')"/></td></tr>';
					}
					$("#productInfoList").append(str);
					for(var i=0;i<data.length;i++){
						$.ajax({
					        url : "productjsonCategory.action",
					        type : 'POST',
					        async: false, 
					        dataType : 'json', 
					        data:{"productType":data[i].productType},
					        success : function(dataType) {
					        	$("#productType"+data[i].productId).text(dataType[0].categoryName);
					        }
						});
					}
				}
			},//end of success
			error : function(data) {
	        	alert("ERROR");	
			}
		});
	}
}


//管理员查询用户列表
 function queryByUserName(){
	$("div.usetohide").hide(speed);
	$("#userManagementdiv").show(speed);
	var userName=$("#search").val();
	URL="queryByUserName.action?userName="+userName;
	$.ajax({
        url : URL,
        type : 'POST',
        async: true, 
        dataType : 'json', 
        contentType:false,
        processData:true,
        success : function(data) {
			var str="";
			$("#userInfoList").empty();
			if(data==null){
				alert("用户不存在！");
				$("#search").val("");
				}
			else{
				for(var i=0;i<data.length;i++){
					var type="";
					switch(data[i].userType){
					case 0:type="管理员";break;
					case 1:type="会员";break;
					case 2:type="商家";break;
					}
					var timecreat=formatLongTimeToTime(data[i].creatDate.time);
					 str+='<tr>'
					 	 +'<td><span id="userName'+data[i].id+'">'+data[i].userName+'</span></td>'
						 +'<td> '+data[i].passWord+'</td>'
						 +'<td> '+data[i].nickName+'</td>'
						 +'<td> '+type+' </td>'
						 +'<td> '+timecreat+'</td>'
						 +'<td> '+data[i].userPhone+' </td>'
						 +'<td> '+data[i].QQ+' </td>'
						 +'<td> '+data[i].userAddress+' </td>'
						 +'<td> '+data[i].reservedInformation+' </td>'
						 +'<td><input type="button" class="button success" id="'+data[i].userName+'" value="修改" onclick="usermodify('+data[i].id+')"/></td></tr>';
				}
				$("#userInfoList").append(str);
			}
		},//end of success
		error : function(data) {
        	alert("ERROR");	
		}
	});
}

 //商家管理商品
 function productmodify(productId){
	 
	 window.location.replace("productftlPage.action?productId="+productId);
 }
 
 
 
 //管理员管理用户
function usermodify(i){
	var temUserName=$("#userName"+i).text();
	$("div.usetohide").hide(1000);
	$("#personalInfodiv").show(speed);
	URL="queryByUserName.action?userName="+temUserName;
	$.ajax({
        url : URL,
        type : 'POST',
        async: true, 
        dataType : 'json', 
        contentType:false,
        processData:true,
        success : function(data) {
        	$("#userName").val(data[0].userName);
        	$("#passWord").val(data[0].passWord);
        	$("#detailAddress").val(data[0].userAddress);
        	$("#userPhone").val(data[0].userPhone);
        	$("#nickName").val(data[0].nickName);
        	$("#QQ").val(data[0].QQ);
        	$("#reservedInformation").val(data[0].reservedInformation);	
        	$("#reservedInformation").attr("disabled",true);
        	reservedInformationold=data[0].reservedInformation;
		},//end of success
		error : function(data) {
        	alert("ERROR");	
		}
	});
}

//更新用户信息
function regist(){
	var userName=$("#userName").val();
	var passWord=$("#passWord").val();
	var userPhone=$("#userPhone").val();
	var QQ=$("#QQ").val();
	var reservedInformation=$("#reservedInformation").val();
	var addressInfo=$("#detailAddress").val();
	if(reservedInformation!=reservedInformationold){
		$("#reservedInformationcheck").text("预留信息不正确！");
		$("#reservedInformationcheck").attr("class","bg-red");
	}
	else{
		var URL="editUserjsonAddUser.action";
		$.ajax({
	        url : URL,
	        type : 'POST',
	        async: true, 
	        dataType : 'json', 
	        data:{"userName":userName,"passWord":passWord,"userPhone":userPhone,"QQ":QQ,"addressInfo":addressInfo,"reservedInformation":reservedInformation},
	        success : function(data) {
	        	personalInfo();
	        	$("#reservedInformationcheck").text("用于验证敏感操作");
	    		$("#reservedInformationcheck").attr("class","fg-darkGreen");
				alert("修改成功！");
			},//end of success
			error : function(data) {
		        alert("ERROR");
		        	
			}
		});
	}
}


