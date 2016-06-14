$(function(){  
	var userName=getCookie('userName');
	$("#merchantName").val(userName);
	$("#merchantName").hide();
	$("#merchant").val(userName);
	$("#merchant").hide();
});
function addEvaluate(){
	$("#tianjia").before('<li><input type="file" id="upload" name="upload"><br/><li><span class="fg-emerald">图片描述：</span><input type="text" name="note"><br/><br/>');
}
