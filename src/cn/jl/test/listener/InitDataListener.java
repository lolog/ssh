package cn.jl.test.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.jl.test.util.CategoryTimerTask;

/**
 * 用于项目启动的时候数据初始化
 */
public class InitDataListener implements ServletContextListener {

	private ApplicationContext context = null;
	private CategoryTimerTask categoryTimerTask = null;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		/**
		 * 1.获取业务逻辑类,查询数据信息
		 */
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		/**
		 * 方案一:不可取,会重新加载Spring配置文件
		 */
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext-*.xml");
		// categoryService = (CategoryService)
		// context.getBean("categoryService");
		// System.out.println("--------------"+categoryService+"------------");

		/**
		 * 方案二：项目启动的时候,把Spring配置文件通过监听器加载并且存储到了 ServletContext中,只需要获取即可
		 * 直接从ServletContext中,获取Spring的配置文件 此方案的key比较长,不容易记住
		 */
		// ApplicationContext ac =
		// (ApplicationContext)event.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		// categoryService =
		// ac.getBean("categoryService",CategoryService.class);
		// System.out.println("------"+categoryService+"--------");
		/**
		 * 方案三：通过工具类加载
		 */
		context = WebApplicationContextUtils.getWebApplicationContext(event
				.getServletContext());
		categoryTimerTask = context.getBean("categoryTimerTask",
				CategoryTimerTask.class);
		// 把内置对象赋值交给categoryTimerTask
		categoryTimerTask.setApplication(event.getServletContext());
		// 设置定时器刷新数据,守护线程
		new Timer(true).schedule(categoryTimerTask,0, 2000000);

	}

}
