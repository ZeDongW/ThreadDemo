
/**  
 * @Title: Consumer.java
 * @Package com.wzd.waitnotify
 * @Description: 消费者
 * @author Administrator
 * @date 2018年8月26日下午4:04:53
 * @version V1.0  
 */

package com.wzd.waitnotify;

/**
 * @ClassName: Consumer
 * @Description: 消费者
 * @author Administrator
 * @date 2018年8月26日下午4:04:53
 */

public class Consumer implements Runnable {
	Product p;

	/**
	 * 创建一个新的实例 Consumer.
	 *
	 */

	public Consumer(Product p) {
		this.p = p;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @see java.lang.Runnable#run()
	 */

	@Override
	public void run() {
		while (true) {
			synchronized (p) {
				if (p.isFalg()) {
					System.out.println(Thread.currentThread().getName() + "消费了" + p);
					p.setFalg(false);
					p.notifyAll();
				} else {
					try {
						Thread.sleep(100);
						p.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
