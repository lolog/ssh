package cn.jl.test.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		Map<String, Object> sessionMap = context.getSession();
		System.out.println("拦截器的Session");
		System.out.println(sessionMap.get("auth"));
		// 没有登录,则跳转到登录界面
		if(sessionMap.get("auth") == null) {
			return "login";
		}
		// 如果登录成功,则继续执行下一个拦截器/Action
		String result = invocation.invoke();
		return result;
	}

}
