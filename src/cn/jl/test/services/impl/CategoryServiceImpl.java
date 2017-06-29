package cn.jl.test.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.jl.test.model.Category;
import cn.jl.test.services.CategoryService;

@SuppressWarnings("unchecked")
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements
		CategoryService {
	public CategoryServiceImpl() {
		super();
	}

	// public static void main(String[] args) {
	// new CategoryServiceImpl();
	// }

	@Override
	public List<Category> queryByHot(boolean hot) {
		String hql = "FROM Category c WHERE c.hot=:hot ORDER BY c.id DESC";
		return getSession().createQuery(hql)//
				.setBoolean("hot", hot)//
				.setFirstResult(0) //
				.setMaxResults(4)//
				.list();
	}
}
