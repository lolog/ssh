package cn.jl.test.action;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.jl.test.model.ImageFile;
import cn.jl.test.services.BaseService;
import cn.jl.test.services.CategoryService;
import cn.jl.test.services.LoginService;
import cn.jl.test.util.FileUpload;
import cn.jl.test.util.MessageUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Struts流程：创建Action -> 调用拦截器  -> 拦截器调用成功,再调用Action方法
 * 项目启动的时候,Struts已经把相应的内置对象和内置对象对应的Map存储到了ApplicationContext和值栈中
 * 如果实现了相应的Aware接口,就会从ActionContext中获得相应的Map进行传入值,实现的拦截器为：
 */
@SuppressWarnings("unchecked")
@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware, ModelDriven<T>{
	
	protected Map<String, Object> session;
	protected Map<String, Object> request;
	protected Map<String, Object> application;
	@Resource
	protected CategoryService categoryService;
	@Resource
	protected LoginService loginService;
	@Resource
	protected MessageUtil messageUtil;
	
	protected T model;     
	
	
	
	protected ImageFile imageFile;
	@Resource
	protected FileUpload fileUpload;

	protected Map<String, Object> json = null;
	
	public Map<String, Object> getJson() {
		return this.json;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.json = jsonMap;
	}

	@Override
	public T getModel() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return model;
	}
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	//	public void setCategoryService(CategoryService categoryService) {
	//		this.categoryService = categoryService;
	//	}
	
	public ImageFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(ImageFile imageFile) {
		this.imageFile = imageFile;
	}

}
