package cn.jl.test.services;


import java.util.List;

import cn.jl.test.model.Category;

public interface CategoryService extends BaseService<Category> {
	public List<Category> queryByHot(boolean hot);
}
