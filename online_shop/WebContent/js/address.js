$(function(){  
	var upId = 1;
	$("#address").hide();
	$("#cityInfoSelect").hide();
	$("#districtInfoSelect").hide();
	if(upId!=0){
		var URL="shop.czq.com/searchAddress.action?upId=" + encodeURI(encodeURI(upId));
			$.ajax({
		        url : URL,
		        type : 'POST',
		        async: false, 
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

function provinceInfoSelectChange(){
	var upId = $("#provinceInfoSelect").find("option:selected").val();
	$("#address").hide();
	$("#cityInfoSelect").hide();
	$("#districtInfoSelect").hide();
	if(upId!=0){
		var URL="shop.czq.com/searchAddress.action?upId=" + encodeURI(encodeURI(upId));
		$.ajax({
	        url : URL,
	        type : 'POST',
	        async: false, 
	        dataType : 'json', 
	        contentType:false,
	        processData:true,
	        success : function(data) {
				$("#cityInfoSelect").show();
				$("#cityInfoSelect").empty();
				$("#cityInfoSelect").append("<option value=0 selected>请选择</option>");
				for(var i=0;i<data.length;i++){
					values= data[i].value;
					name = data[i].name;
					$("#cityInfoSelect").append('<option  value='+values+'>'+name+'</option>');  
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
	if(upId!=0){
		var URL="shop.czq.com/searchAddress.action?upId=" + encodeURI(encodeURI(upId));
		$.ajax({
	        url : URL,
	        type : 'POST',
	        async: false, 
	        dataType : 'json', 
	        contentType:false,
	        processData:true,
	        success : function(data) {
				$("#districtInfoSelect").show();
				$("#districtInfoSelect").empty();
				$("#districtInfoSelect").append("<option  value=0 selected>请选择</option>");
				for(var i=0;i<data.length;i++){
					values= data[i].value;
					name = data[i].name;
				    $("#districtInfoSelect").append('<option  value='+values+'>'+name+'</option>'); 
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
	var nowcityInfo = $("#cityInfoSelect").find("option:selected").text();
	var nowProvinceInfo = $("#provinceInfoSelect").find("option:selected").text();
	if(districtInfo!="请选择")
	{
		$("#address").show();
		$("#address").text("您选择了"+nowProvinceInfo+nowcityInfo+districtInfo);     // 通过 jQuery 创建元素
	}
	else{
		$("#address").text("");
		$("#address").hide();
	}
}
	


/*function loadingon(){
	var passWord =$("#passWord").val();	
	var userName =$("#userName").val();
	var regName = new RegExp("^[a-z1-9]+$" );
	if(!regName.test(userName))
		alert("请输入正确的用户名！");
	else if(passWord.length < 3)
		alert("请输入大于等于三位的密码！");
	else {
		var date=new Date();
		$("#date").val(date.getFullYear()+"年"+date.getMonth()+"月"+date.getDate()+"日"+date.getHours()+"时"+date.getMinutes()+"分"+date.getSeconds()+"秒");
		$('#Login').submit();	
	}
}
*/