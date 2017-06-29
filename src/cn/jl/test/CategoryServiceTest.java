package cn.jl.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.jl.test.services.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class CategoryServiceTest {
	@Resource
	CategoryService categoryService;
	@Test
	public void query(){
		System.out.println(categoryService.query());
	}
	@Test
	public void queryhotTest(){
		System.out.println(categoryService.queryByHot(true));
	}
}
