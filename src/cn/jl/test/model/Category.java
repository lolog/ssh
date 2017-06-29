package cn.jl.test.model;


/**
 * 容器的关闭不会导致session销毁 当对象存储到硬盘的时候,就需要实现序列化接口,序列化就是添加一个唯一的ID(类主键)
 * 在反序列化的时候就可以成功找到相应的对象
 * 
 */
public class Category {

	private int id;
	private String type;
	private Boolean hot;

	public Category() {
		super();
	}

	public Category(String type, Boolean hot) {
		super();
		this.type = type;
		this.hot = hot;
	}

	public Category(int id, String type, Boolean hot) {
		super();
		this.id = id;
		this.type = type;
		this.hot = hot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getHot() {
		return hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", type=" + type + ", hot=" + hot + "]";
	}
}
