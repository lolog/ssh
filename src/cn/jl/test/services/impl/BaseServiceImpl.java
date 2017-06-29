package cn.jl.test.services.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import cn.jl.test.services.BaseService;

@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {
	private Class clazz;
	
	@Resource
	protected SessionFactory sessionFactory;

	public BaseServiceImpl() {
		System.out.println("this 代表当前调用构造方法的对象：" + this);
		System.out.println("获取当前this对象父类信息：" + this.getClass().getSuperclass());
		System.out.println("获取当前this对象父类信息(包括泛型)："
				+ this.getClass().getGenericSuperclass());
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
		System.out.println(clazz.getSimpleName());
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	//	public void setSessionFactory(SessionFactory sessionFactory) {
	//		this.sessionFactory = sessionFactory;
	//	}

	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String hql = "DELETE " + clazz.getSimpleName() + " WHERE id=:id";
		getSession().createQuery(hql)//
				.setInteger("id", id) //
				.executeUpdate();
	}

	@Override
	public T getById(int id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		String hql = "FROM " + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

}
