package cn.jl.test.services;

import java.util.List;

public interface BaseService<T> {
	public void save(T t);
	
	public void update(T t);
	
	public void delete(int id);
	
	public T getById(int id);
	
	public List<T> query();
}
