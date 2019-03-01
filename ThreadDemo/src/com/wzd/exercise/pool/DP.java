
/**  
 * @Title: DP.java
 * @Package com.wzd.exercise.pool
 * @Description: 生产者，消费者
 * @author wangzedong
 * @date 2018年8月26日下午11:21:44
 * @version V1.0  
 */

package com.wzd.exercise.pool;

/**
 * @ClassName: DP
 * @Description: 生产者，消费者
 * @author wangzedong
 * @date 2018年8月26日下午11:21:44
 */
public class DP {
	public static void main(String[] args) {
		Pool p = new Pool();
		Inlet il = new Inlet(p);
		Disembogue db = new Disembogue(p);
		Thread t1 = new Thread(il);
		Thread t2 = new Thread(db);
		t1.start();
		t2.start();
	}
}
