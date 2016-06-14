$(function(){  
	inIt();	 
});
function inIt(){
	
	$.ajax({
        url : "productjsonHotProduct.action",
        type : 'POST',
        async: true, 
        dataType : 'json', 
        data:{"productType":0},
        success : function(dataProduct) {
        	var strhot = "";
			for(var i=0;i<dataProduct.length&&i<15;i++){
				var URL="productftlPage.action?productId="+dataProduct[i].productId;
				strhot+='<li><a href="'+URL+'"><img id="HotProduct'+dataProduct[i].productId+'" class="span2" src="'+dataProduct[i].indexPictuer+'" /></a></li>'+
							'<li><a href="'+URL+'" class="fg-green">'+dataProduct[i].productName+'&nbsp&nbsp'+dataProduct[i].productPrice+'</a></li></br>';		
			}
			$("#hotSale").append(strhot);
        },
        error : function(dataProduct) {
        	alert("错误");	
		}
	});
	
	var userName=getCookie('userName');
	if(userName==null || userName==""){
		userName="chenzhiqiang";
	}
	URL="editUserjsonId.action?userName="+userName;
	$.ajax({
        url : URL,
        type : 'POST',
        async: true, 
        dataType : 'json', 
        contentType:false,
        processData:true,
        success : function(data) {
        	if(data==null){
        		alert("未查询到用户的类目");
        	}
        	else{
        		for(var i=0;i<data.length;i++){
        			$.ajax({
            	        url : "productjsonHotProduct.action",
            	        type : 'POST',
            	        async: false, 
            	        dataType : 'json', 
            	        data:{"productType":data[i].category},
            	        success : function(dataProduct) { 
            	        	var strhot = '<li><a href="#" class="span12" id="categorytitle'+i+'"></a></li>';
            	        	if(dataProduct!=null){
	            				for(var j=0;j<dataProduct.length&&j<4;j++){
	            					var URL="productftlPage.action?productId="+dataProduct[j].productId;
	            					strhot+='<div class="span3"><li><a href="'+URL+'"><input type="image" style="overflow:hidden;height:250px" id="HotProduct'+dataProduct[j].productId+'" class="span3"  src="'+dataProduct[j].indexPictuer+'" /></a></li>'+
	            							'<li><a href="'+URL+'" class="fg-green">'+dataProduct[j].productName+'&nbsp&nbsp'+dataProduct[j].productPrice+'</a></li></br></div>';
	            				}
            	        	}
            	        	$("#categoryul").append(strhot);
            	        },
            	        error : function(dataProduct) {
            	        	alert("错误");	
            			}
            		});
        			$.ajax({
    			        url : "productjsonCategory.action",
    			        type : 'POST',
    			        async: false, 
    			        dataType : 'json', 
    			        data:{"productType":data[i].category},
    			        success : function(dataType) {
    			        	$("#categorytitle"+i).html(dataType[0].categoryName);
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

function enterAction(e){
	var event= window.event||e;
	 if(event.keyCode==13) {  
		 queryByProductId();
	 }
}


function queryByProductId(){
	$("#categoryul").empty();
	var value=$("#search").val();
	var regName = new RegExp("^[0-9a-zA-Z]+$" );
	var regNamen = new RegExp("^[0-9]+$" );
	var productId="0";
	var merchantName="chenzhiqiang";
	var productName="";
	if(!regName.test(value)){
		productName=value;
	}else if(!regNamen.test(value)){
		merchantName=value;
	}
	else{
		productId=value;
	}
	URL="productjsonQuery.action";
	$.ajax({
        url : URL,
        type : 'POST',
        async: true, 
        dataType : 'json', 
        data:{"merchantName":merchantName,"productId":productId,"productName":productName},
        success : function(data) {
        	var strhot = '';
        	for(var i=0;i<data.length;i++){
        		var URL="productftlPage.action?productId="+data[i].productId;
				strhot+='<div class="span3"><li><a href="'+URL+'"><img id="product'+data[i].productId+'" style="overflow:hidden;height:250px"  class="span3" src="'+data[i].indexPictuer+'" ></img></a></li>'+
				'<li><a href="'+URL+'" class="fg-green">'+data[i].productName+'&nbsp&nbsp'+data[i].productPrice+'</a></li></br></div>';	
        	}
        	$("#categoryul").append(strhot);
        }
	});
}
