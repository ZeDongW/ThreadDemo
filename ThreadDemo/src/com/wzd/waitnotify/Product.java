
/**  
 * @Title: Product.java
 * @Package com.wzd.waitnotify
 * @Description: 产品
 * @author wangzedong
 * @date 2018年8月26日下午3:45:17
 * @version V1.0  
 */

package com.wzd.waitnotify;

/**
 * @ClassName: Product
 * @Description: 产品
 * @author wangzedong
 * @date 2018年8月26日下午3:45:17
 */

public class Product {
	private String name; // 产品名
	private double price; // 价格
	private boolean falg = false; // 是否已生产

	/**
	 * 创建一个新的实例 Product.
	 *
	 */

	public Product() {

	}

	/**
	 * 创建一个新的实例 Product.
	 *
	 * @param name
	 * @param price
	 * @param falg
	 */

	public Product(String name, double price, boolean falg) {
		this.name = name;
		this.price = price;
		this.falg = falg;
	}

	/**
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return price
	 */

	public double getPrice() {
		return price;
	}

	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return falg
	 */

	public boolean isFalg() {
		return falg;
	}

	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */

	public void setFalg(boolean falg) {
		this.falg = falg;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

}
