$(function(){ 
	var URL="image/10000i.jpg";
	$("#image").attr("src",URL);
});

function subclick(){
	var file=$("#upload").val();
	alert(file);
	var URL="D:\\image\\home";
	$("#image").attr("src","image\home"); 
}