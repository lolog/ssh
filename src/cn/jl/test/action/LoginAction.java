package cn.jl.test.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.jl.test.model.Category;

@Controller
@Scope("prototype")
public class LoginAction  extends BaseAction<Category>{
	// 登录验证
	public String login(){
		model = loginService.login(model);
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println(model);
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		if(model == null) {
			// 登录失败
			session.put("error", "登录失败");
			System.out.println(session.get("error"));
			return "login";
		}
		else {
			// 登录成功,存入Session中
			session.put("auth", model);
			// 根据session中goUrl的值是否有值决定跳转
			if(session.get("goUrl") == null) {
				return "index";
			}
			else {
				return "goUrl";
			}
		}
	}
	public void sendEmail(){
		messageUtil.sendEmail(null);
	}
}
