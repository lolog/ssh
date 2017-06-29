package cn.jl.test.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.aspectj.util.FileUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.jl.test.model.Category;

import com.opensymphony.xwork2.ActionContext;

/**
 * ModelDriven必须实现getModel方法,此方法把返回的对象放入栈顶中
 */
@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category>
{
	public String update() {
		System.out.println(model);
		System.out.println("----update----");
		System.out.println(categoryService);
		categoryService.update(new Category(1, "女士服装0", true));
		return "SUCCESS";
	}

	public String save() {
		System.out.println("----save----");
		System.out.println(categoryService);
		return "SUCCESS";
	}

	public String query() {
		System.out.println(ActionContext.getContext().getValueStack().getRoot());
		/**
		 * 方案一：采用Map取代了内置对象,与JSP没有依赖,但是代码量比较大
		 */
		// ActionContext.getContext().put("categoryList",
		// categoryService.query());
		// ActionContext.getContext().getSession().put("categoryList",
		// categoryService.query());
		// ActionContext.getContext().getApplication().put("categoryList",
		// categoryService.query());

		/**
		 * 方案二：实现相应的接口,让相应的Map注入,代码量更大
		 */
		request.put("categoryList", categoryService.query());
		session.put("categoryList", categoryService.query());
		application.put("categoryList", categoryService.query());
		/**
		 * 方案三：实现相应的接口,让相应的Map注入,让BaseAction实现相应的接口
		 */
		return "SUCCESS";
	}

	public String getjson() {
		json = new HashMap<String, Object>();
		json.put("key", 1);
		json.put("row", categoryService.query());
		System.out.println(json);
		return "json";
	}

	public void upload() throws IOException {
		// 实现文件上传功能
		fileUpload.uploadFile(imageFile);

	}
}
