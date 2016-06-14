$(function(){ 
	//添加导航菜单
	//document.body.style.background='url("css/10000ii.jpg")';
	var str='<nav class="navigation-bar navbar" >'+
	 		'<nav class="navigation-bar-content">'+
	 		'<item class="element"><a class="fg-white" id ="homepage" href="homeftlPage.action"  onclick="javascript:void(0);">首页</a></item>'+
	 		'<item class="element"><a class="fg-white" id ="usertype" href="#"  onclick="javascript:void(0);" ></a></item>'+
	 		'<item class="element"><a class="fg-white" id ="login" href="#"  onclick="javascript:void(0);" ><span id="loginName">登录</span></a></item>'+
	 		'<item class="element"><a class="fg-white" id ="usercenter" href="#"  onclick="javascript:void(0);" >用户中心</a></item>'+
	 		'<item class="element"><a class="fg-white" id ="logout" href="#"  onclick="javascript:void(0);" style="text-align: right;">注销</a>'+
	 		'</nav></nav>';
	$("#menubar").append(str);
	$("#menubar").after('<div style="position:fixed; right:5%; top:90%; bottom:0px;"><a  href="#" ><input type="button" class="button success" value="回到顶部"></a></div>');
	$("#homepage").bind('click', homepage);
	$("#login").bind('click', login);
	$("#logout").hide();
	$("#usertype").hide();
	$("#usercenter").hide();
	$("#logout").bind('click', logout);
	
	//检查cookie，根据用户是否登录调整顶部菜单
	login();
});

//通知函数
function alert(notifyText){
	 setTimeout(function(){
		 $.Notify({style: {background: '#1ba1e2', color: 'white'}, content: notifyText});// caption: 'Info...',提示标题
		 }, 1000);
	setTimeout(function(){
		 $.Notify({style: {background: 'red', color: 'white'}, content: notifyText});
		 }, 2000);
	setTimeout(function(){
		 $.Notify({style: {background: 'green', color: 'white'}, content: notifyText});
		 }, 3000);
//	setTimeout(function(){
//		 $.Notify({style: {background: 'red', color: 'white'},content: notifyText});
//		 }, 4000);
		
}


//检查cookie，根据用户是否登录调整顶部菜单
function login(){
	var nickName=getCookie('nickName');
	if (nickName!=null && nickName!=""){
		var url='userCenterftlPage.action?nickName='+nickName;
		$("#loginName").text(nickName);
		$("#usercenter").attr("href",url);
		var userType=getCookie('userType');
		$("#usertype").text(userType);
		$("#usertype").show();
		$("#usercenter").show();
		$("#logout").show();
	}
	else{
		$("#login").attr("href","loginftlPage.action");
		$("#loginName").text("登录");
		$("#usercenter").attr("href","#");
		$("#usercenter").hide();
		$("#usertype").hide();
		$("#usertype").text("");
		$("#logout").hide();
	}
}
//注销登录
function logout(){
	var userName=getCookie('userName');
	var nickName=getCookie('nickName');
	var usertype=getCookie('usertype');
	delCookie('userName');
	delCookie('nickName');
	delCookie('usertype');
	login();
}

//获取cookie
function getCookie(c_name)
{
	if (document.cookie.length>0) {
	  c_start=document.cookie.indexOf(c_name + "=");
	  if (c_start!=-1) { 
	    c_start=c_start + c_name.length+1 ;
	    c_end=document.cookie.indexOf(";",c_start);
	    if (c_end==-1) {
	    	c_end=document.cookie.length;
	    }
	    return unescape(document.cookie.substring(c_start,c_end));
	  } 
   }
	return "";
}

//设置cookie
function setCookie(c_name,value,expiredays){
	var exdate=new Date();
	exdate.setTime(exdate.getTime() + (2*60 * 1000));    //day*24*60*60*1000
	document.cookie=c_name+ "=" +escape(value)+((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
}

//删除cookie
function delCookie(name) 
{ 
    var exp = new Date(); 
    exp.setTime(exp.getTime() - 1); 
    var cval=getCookie(name); 
    if(cval!=null) 
        document.cookie= name + "="+cval+";expires="+exp.toGMTString(); 
} 
