/**
 * 给jquery validate 自定义 验证规则
 */
$.validator.addMethod("youzhengcode",function(value,element,params){
	var pattern = /^[0-9]{6}$/;
	return this.optional(element)||pattern.test(value);
},"邮政编码格式错误");

//验证手机号码
jQuery.validator.addMethod("mobile", function(value,element,params){
	var mobilepattern = /^[0-9]{11}$/;
	return this.optional(element)||mobilepattern.test(value);
		
	} ,"非法的手机号码");