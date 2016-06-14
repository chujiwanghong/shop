$(function(){  
	//检查cookie，用户是否已登录
	var userName=getCookie('userName');
	if (userName!=null && userName!=""){
		alert('Welcome again '+userName+'!');
	}

});

function a(){
	$.Dialog({
		 shadow: true,
		 overlay: false,
		 draggable: true,
		 icon: '<span class="icon-bus"></span>',
		 title: 'Draggable window',
		 width: 500,
		 padding: 10,
		 content: 'This Window is draggable by caption.',
		 onShow: function(){
			 var content = '<form id="login-form-1">' +
			 			   '<label>Login</label>' +
			 			   '<div class="input-control text"><input type="text" name="login"><button class="btn-clear"></button></div>' +
			 			   '<label>Password</label>'+
			 			   '<div class="input-control password"><input type="password" name="password"><button class="btn-reveal"></button></div>' +
			 			   '<div class="input-control checkbox"><label><input type="checkbox" name="c1" checked/><span class="check"></span>Check me out</label></div>'+
			 			   '<div class="form-actions">' +
			 			   '<button class="button primary">Login to...</button>&nbsp;'+
			 			   '<button class="button" type="button" onclick="$.Dialog.close()">Cancel</button> '+
			 			   '</div>'+
			 			   '</form>';
			 $.Dialog.title("User login");
			 $.Dialog.content(content);
			}
		 });
}


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

function setCookie(c_name,value,expiredays){
	var exdate=new Date();
	exdate.setTime(exdate.getTime() + (60*60 * 1000));//设置cookie过期时间    
	document.cookie=c_name+ "=" +escape(value)+((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
}

function delCookie(name) 
{ 
    var exp = new Date(); 
    exp.setTime(exp.getTime() - 1); 
    var cval=getCookie(name); 
    if(cval!=null) 
        document.cookie= name + "="+cval+";expires="+exp.toGMTString(); 
} 

//用户输完用户名，判断用户名是否存在
function onchangeUser(){
	var userName =$("#userName").val();
	var regName = new RegExp("^[a-z1-9]+$" );
	if(!regName.test(userName)){
		alert("请输入正确的用户名！");
	}
	else if(userName.length < 6){
			alert("请输入大于等于六位的用户名！");
		}
	else{
		URL="loginjsonUserchange.action";
		$.ajax({
	        url : URL,
	        type : 'POST',
	        async: false, 
	        data:{"userName":userName},
	        dataType : 'json', 
	        success : function(data) {
				if(data==null){
					alert("用户名不存在！");
					$("#userName").val("");
				}
			},//end of success
			error : function(data) {
	        	alert("ERROR");	
			}
		});
	}
	
}

//登录判断
function loadingon(){
	var passWord =$("#passWord").val();	
	var userName =$("#userName").val();
	var regName = new RegExp("^[a-z1-9]+$" );
	if(!regName.test(userName))
		alert("请输入正确的用户名！");
	else 
		if(userName.length < 6)
		alert("请输入大于等于六位的用户名！");
	else if(passWord.length < 6)
		alert("请输入大于等于六位的密码！");
	else {
		URL="loginjsonSys.action";
		$.ajax({
	        url : URL,
	        type : 'POST',
	        async: false, 
	        data:{"userName":userName,"passWord":passWord},
	        dataType : 'json', 
	        success : function(data) {
				if(data==null){
					alert("密码错误！");
					delCookie("userName");
				}
				else {
					var type="";
					switch(data[0].userType){
					case 0:type="管理员";break;
					case 1:type="会员";break;
					case 2:type="商家";break;
					}
					setCookie('userName',data[0].userName,1);
					setCookie('nickName',data[0].nickName,1);
					setCookie('userType',type,1);
					window.location.replace("userCenterftlPage.action");
				}
			},//end of success
			error : function(data) {
	        	alert("ERROR");	
	        	delCookie("userName");
			}
		});
	}
}


function regist(){
	window.open("editUserftlPage.action");
}
