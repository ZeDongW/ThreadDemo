
/**  
 * @Title: Pool.java
 * @Package com.wzd.exercise.pool
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Administrator
 * @date 2018年8月26日下午11:01:46
 * @version V1.0  
 */

package com.wzd.exercise.pool;

/**
 * @ClassName: Pool
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年8月26日下午11:01:46
 */

public class Pool {
	
	private int size;//水池的水量
	static final int MAX_SIZE = 500;

	/**
	 * 创建一个新的实例 Pool.
	 *
	 */

	public Pool() {
		
	}

	/**
	 * 创建一个新的实例 Pool.
	 *
	 * @param size
	 */

	public Pool(int size) {
		this.size = size;
	}

	
	/**
	 * @return size
	 */
	
	public int getSize() {
		return size;
	}

	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setSize(int size) {
		this.size = size;
	}

}
