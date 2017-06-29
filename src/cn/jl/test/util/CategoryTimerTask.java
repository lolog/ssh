package cn.jl.test.util;

import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import cn.jl.test.model.Category;
import cn.jl.test.services.CategoryService;

/**
 * 设置任务,用于刷新缓存数据
 */
@Component("categoryTimerTask")
public class CategoryTimerTask extends TimerTask {
	@Resource
	private CategoryService categoryService = null;
	@Resource
	private ApplicationContext context = null;
	
	private ServletContext application = null;
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}

	@Override
	public void run() {
		System.out.println("=======CategoryTimerTask=====");
		List<Category> list = categoryService.queryByHot(true);
		System.out
				.println("=======================================================");
		System.out.println(list);
		System.out
				.println("=======================================================");
		application.setAttribute("list", list);
		System.out.println("------" + categoryService + "--------");
	}

}
