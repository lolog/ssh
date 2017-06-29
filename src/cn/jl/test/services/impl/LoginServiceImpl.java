package cn.jl.test.services.impl;

import org.springframework.stereotype.Service;

import cn.jl.test.model.Category;
import cn.jl.test.services.LoginService;

@Service("loginService")
public class LoginServiceImpl extends BaseServiceImpl<Category> implements
		LoginService {
	@Override
	public Category login(Category category) {
		String hql = "FROM Category c WHERE c.type=:type";
		return (Category) getSession().createQuery(hql)//
				.setString("type", category.getType()) //
				.uniqueResult();
	}

}
