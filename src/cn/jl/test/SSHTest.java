package cn.jl.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.jl.test.model.Category;
import cn.jl.test.services.CategoryService;
import cn.jl.test.services.impl.CategoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class SSHTest {
	//	@Resource
	//	private Date date;
	@Resource
	private CategoryService categoryService;
	@Test
	public void springTest(){
		//	System.out.println(date);
	}
	@Test
	public void HibernateTest(){
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.save(new Category("男士服装",false));
	}
	@Test
	public void hibernateAndSpringTest(){
		categoryService.update(new Category(1,"男士服装",true));
	}
}
