$(function(){  
	var upId = 1;
	$("#editType").hide();
	var editedUserName=$("#editedUserName").text();
	$("#cityInfoSelect").hide();
	$("#districtInfoSelect").hide();
	$("#detailAddress").hide();
	$("#detailAddress").empty();
	$("#detailAddressinfo").hide();
	
	//从数据库查询所有省份信息
	if(upId!=0){
		var URL="searchAddress.action?upId=" + encodeURI(encodeURI(upId));
			$.ajax({
		        url : URL,
		        type : 'POST',
		        async: true, 
		        dataType : 'json', 
		        contentType:false,
		        processData:true,
		        success : function(data) {
					$("#provinceInfoSelect").empty();
					$("#provinceInfoSelect").append("<option value=0 selected>请选择</option>");
					for(var i=0;i<data.length;i++){
						value= data[i].value;
						name = data[i].name;
						var option = $("<option>").val(value).text(name);
					      $("#provinceInfoSelect").append(option); 
					}
				},//end of success
				error : function(data) {
		        	alert("ERROR");	
				}
			});
	}
});


//格式化long类型的时间为年月日时分秒
function formatLongTimeToTime(time){
	var date = new Date(time);
	return date.getFullYear() + '.'+ (date.getMonth() + 1) + '.'+ date.getDate()+" "+date.getHours()+":"
	+(date.getMinutes()<10?"0":"")+date.getMinutes()+":"+(date.getSeconds()<10?"0":"")+date.getSeconds();
}

//查询用户信息
function queryByUserName(){
	var temUserName=$("#search").val();
	URL="queryByUserName.action?temUserName="+encodeURI(encodeURI(temUserName));
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
			for(var i=0;i<data.length;i++){
				var type="";
				switch(data[i].userType){
				case 0:type="管理员";break;
				case 1:type="商家";break;
				case 2:type="会员";break;
				}
				var timecreat=formatLongTimeToTime(data[i].creatDate.time);
				 str+='<tr id="user'+i+'"><td>'+data[i].id+'</td>'
				 	 +'<td id="userName'+i+'">'+data[i].userName+'</td>'
					 +'<td id="'+data[i].userName+'"><input type="text" name="mutexIds" id="user'+data[i].userName+'" value="'+data[i].passWord+'" onchange="passWordchange('+i+')"/></td>'
					 +'<td> '+type+' </td>'
					 +'<td> '+timecreat+'</td>'
					 +'<td> '+data[i].userPhone+' </td>'
					 +'<td> '+data[i].QQ+' </td>'
					 +'<td> '+data[i].userAddress+' </td>'
					 +'<td> '+data[i].reservedInformation+' </td>'
					 +'<td><input type="button" name="mutexIds" id="'+data[i].userName+'" value="删除" onclick="deleteUser('+i+')"/></td></tr>';
			}
			$("#userInfoList").append(str);
		},//end of success
		error : function(data) {
        	alert("ERROR");	
		}
	});
}

function deleteUser(str,i){
	var temUserName=$("#userName"+i).text();
	alert(str);
	return;
	var URL="shop.czq.com/deleteUserInfo.action?temUserName=" + encodeURI(encodeURI(temUserName));
	$.ajax({
        url : URL,
        type : 'POST',
        async: true, 
        dataType : 'json', 
        contentType:false,
        processData:true,
        success : function(data) {
        	$("#user"+i).remove();
		},//end of success
		error : function(data) {
        	alert("ERROR");	
		}
	});
	}


function passWordchange(i){
	var st=$("#userName"+i).text();
	var passWord = $("#user"+st).val();
	alert(passWord);
	if(passWord.length < 3)
		alert("请输入大于等于三位的密码！");
	else{
		
		var URL="shop.czq.com/updateUserInfo.action?temUserName="+st+"&temPassWord="+passWord;
		$.ajax({
	        url : URL,
	        type : 'POST',
	        async: true, 
	        dataType : 'json', 
	        contentType:false,
	        processData:true,
	        success : function(data) {
	        	alert("更新成功");
			},//end of success
			error : function(data) {
	        	alert("ERROR");	
			}
		});
	}
}


function addUser(){
	var userName = $("#userName").val();
	var passWord = $("#passWord").val();
	var size = $('tbody>tr').length;
	var regName = new RegExp("^[a-z1-9]+$" );
	if(!regName.test(userName))
		alert("请输入正确的用户名！");
	else if(passWord.length < 3)
		alert("请输入大于等于三位的密码！");
	else {
		var URL="shop.czq.com/insertUserInfo.action?temUserName="+userName+"&temPassWord="+passWord;
		$.ajax({
	        url : URL,
	        type : 'POST',
	        async: true, 
	        dataType : 'json', 
	        contentType:false,
	        processData:true,
	        success : function(data) {
	        	var	str='<tr id="user'+size+'"><td id="userName'+size+'">'
				 +userName+'</td>'
				 +'<td name="'+userName+'"><input type="text" name="mutexIds" id="'+userName+'" value="'+passWord+'" onchange="passWordchange('+size+')"/></td>'
				 +'<td><input type="button" name="mutexIds" id="'+userName+'" value="删除" onclick="deleteUser('+size+')"/></td></tr>';
			$("#userInfoList").append(str);
			},//end of success
			error : function(data) {
	        	alert("ERROR");	
			}
		});
	}
	
}

function provinceInfoSelectChange(){
	var upId = $("#provinceInfoSelect").find("option:selected").val();
	$("#address").hide();
	$("#cityInfoSelect").hide();
	$("#districtInfoSelect").hide();
	$("#detailAddress").hide();
	if(upId!=0){
		var URL="shop.czq.com/searchAddress.action?upId=" + encodeURI(encodeURI(upId));
		$.ajax({
	        url : URL,
	        type : 'POST',
	        async: true, 
	        dataType : 'json', 
	        contentType:false,
	        processData:true,
	        success : function(data) {
				$("#cityInfoSelect").show();
				$("#cityInfoSelect").empty();
				$("#cityInfoSelect").append("<option value=0 selected>请选择</option>");
				for(var i=0;i<data.length;i++){
					value= data[i].value;
					name = data[i].name;
					var option = $("<option>").val(value).text(name);
				      $("#cityInfoSelect").append(option); 
				}
			},//end of success
				error : function(data) {
		        	alert("ERROR");
		        	
				}
			});
	}
}


function cityInfoSelectChange(){
	var upId = $("#cityInfoSelect").find("option:selected").val();
	$("#address").hide();
	$("#districtInfoSelect").hide();
	$("#detailAddress").hide();
	if(upId!=0){
		var URL="shop.czq.com/searchAddress.action?upId=" + encodeURI(encodeURI(upId));
		$.ajax({
	        url : URL,
	        type : 'POST',
	        async: true, 
	        dataType : 'json', 
	        contentType:false,
	        processData:true,
	        success : function(data) {
				$("#districtInfoSelect").show();
				$("#districtInfoSelect").empty();
				$("#districtInfoSelect").append("<option value=0 selected>请选择</option>");
				for(var i=0;i<data.length;i++){
					value= data[i].value;
					name = data[i].name;
					var option = $("<option>").val(value).text(name);
				      $("#districtInfoSelect").append(option); 
				}
			},//end of success
				error : function(data) {
		        	alert("ERROR");
		        	
				}
			});
	}
}


function districtInfoSelectChange(){ 
	var districtInfo = $("#districtInfoSelect").find("option:selected").text();
	if(districtInfo!="请选择")
	{
		$("#detailAddress").show();
	}
	else{
		$("#detailAddress").val("");
		$("#detailAddress").hide();
	}
}

function detailAddresschange(){
	var districtInfo = $("#districtInfoSelect").find("option:selected").text();
	var nowcityInfo = $("#cityInfoSelect").find("option:selected").text();
	var nowProvinceInfo = $("#provinceInfoSelect").find("option:selected").text();
	var detailInfo=$("#detailAddress").val();
	if(detailInfo.length==0){
		$("#detailAddressinfo").hide();
	}
	else{
		$("#detailAddressinfo").show();
		$("#detailAddressinfo").text(nowProvinceInfo+nowcityInfo+districtInfo+detailInfo);
	}
}


//重置用户信息为空
function reset(){
	$("input.user").val("");
	$("#provinceInfoSelect").val(0);
	$("#cityInfoSelect").hide();
	$("#districtInfoSelect").hide();
	$("#detailAddress").hide();
	$("#detailAddress").empty();
	$("#detailAddressinfo").hide();
}

//提交用户信息
function regist(){
	var userName=$("#userName").val();
	var passWord=$("#passWord").val();
	var userPhone=$("#userPhone").val();
	var nickName=$("#nickName").val();
	var QQ=$("#QQ").val();
	var reservedInformation=$("#reservedInformation").val();
	var addressInfo=$("#detailAddressinfo").text();
	var URL="editUserjsonAddUser.action";
	$.ajax({
        url : URL,
        type : 'POST',
        async: true, 
        dataType : 'json', 
        data:{"userName":userName,"passWord":passWord,"userPhone":userPhone,"QQ":QQ,"nickName":nickName,"addressInfo":addressInfo,"reservedInformation":reservedInformation},
        success : function(data) {
			alert("注册成功！");
			setCookie('userName',userName,1);
			setCookie('nickName',nickName,1);
			setCookie('userType',"会员",1);
			window.location.replace("homeftlPage.action");
		},//end of success
			error : function(data) {
	        	alert("ERROR");
	        	
			}
		});
}
