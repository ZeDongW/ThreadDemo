
    /**  
     * @Title: Pc.java
     * @Package com.wzd.waitnotify
     * @Description: 生产者消费者实例
     * @author Administrator
     * @date 2018年8月26日下午4:11:06
     * @version V1.0  
     */
    
package com.wzd.waitnotify;


    /**
     * @ClassName: Pc
     * @Description: 生产者消费者实例
     * @author Administrator
     * @date 2018年8月26日下午4:11:06
     */

public class Pc {
	public static void main(String[] args) {
		Product p = new Product();
		Producer pro = new Producer(p);
		Consumer con = new Consumer(p);
		Thread t1 = new Thread(pro, "生产者1");
		Thread t2 = new Thread(pro, "生产者2");
		Thread t3 = new Thread(con, "消费者1");
		Thread t4 = new Thread(con, "消费者2");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
