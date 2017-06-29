package cn.jl.test.services;

import cn.jl.test.model.Category;

public interface LoginService extends BaseService<Category>{
	public Category login(Category category);
}
