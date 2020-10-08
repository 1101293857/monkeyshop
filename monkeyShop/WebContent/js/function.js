var flag=true;
var flag1=true;
var flag2=true;
var flag3=true;
var flag4=true;

function change(img){
	img.src="getCode?"+new Date().getTime();
}

function FocusItem(obj){
	if($(obj).attr('name')=='veryCode')
	{
		$(obj).next().next().html('').removeClass('error');
	}
	else
	{
		$(obj).next('span').html('').removeClass('error');
	}
}
function checkitem(obj){
	var msgBox=$(obj).next('span');
	
	switch($(obj).attr('name')){
		case "userName":
			if(obj.value=="")
			{
				msgBox.html('用户名不能为空');
				msgBox.addClass('error');
				flag1=false;
			}else
			{
				var url = "usernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
				$.get(url,function(data){
					if(data=="false"){
						msgBox.html('用户名不能重复');
				        msgBox.addClass('error');
                        flag1=false;
					}else{
						flag1=true;
						msgBox.html().removeClass('error');
					}
				})
			}
			break;
		case "password":
			if(obj.value=="")
			{
				msgBox.html('密码不能为空');
				msgBox.addClass('error');
				flag2=false;
			}
			else
			{
				flag2=true;
			}
			break;
		case "repassword":
			if(obj.value=="")
			{
				msgBox.html('该位置不能为空');
				msgBox.addClass('error');
				flag3=false;
			}else if($(obj).val() !=$('input[name="password"]').val()){
				msgBox.html('确认密码不正确');
				msgBox.addClass('error');
				flag3=false;
			}
			else{
				flag3=true;
			}
			break;
			
		case "veryCode":
			var numshow = $(obj).next().next();
			if(obj.value=="")
			{
				numshow.html('验证码不能为空');
				numshow.addClass('error');
				flag4=false;
			}else{
				var url="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
			    $.get(url,function(numdata){
				if(numdata=='false')
				{
					numshow.html('验证码输入有误');
					numshow.addClass('error');
					flag4=false; 
				}else
				{

					flag4=true;
					numshow.html().removeClass('error');
				}
			})
				
			
			}
			break;

		
			
	}
}

function checkform(jj){
	var els=jj.getElementsByTagName('input');

	
	//有onblur属性才需要
	for(var i=0;i<els.length;i++)
	{
		if(els[i]!=null)
		{
			if(els[i].getAttribute("onblur") ){
				checkitem(els[i]);
			}
		}
	}
	
	var nihao = (flag1 & flag2) & (flag3 & flag4);
	if(nihao==0)
		{
			return false;
		}
	else
		{
			return true;
		}
}