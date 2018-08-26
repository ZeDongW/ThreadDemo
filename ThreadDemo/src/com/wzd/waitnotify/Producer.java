
/**  
 * @Title: Producer.java
 * @Package com.wzd.waitnotify
 * @Description: 生产者
 * @author Administrator
 * @date 2018年8月26日下午3:51:09
 * @version V1.0  
 */

package com.wzd.waitnotify;

/**
 * @ClassName: Producer
 * @Description: 生产者
 * @author Administrator
 * @date 2018年8月26日下午3:51:09
 */

public class Producer implements Runnable {
	Product p;

	/**
	 * 创建一个新的实例 Producer.
	 *
	 */

	public Producer(Product p) {
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
		int i = 0;
		while (true) {
			synchronized (p) {
				if (!p.isFalg()) {
					if (i % 2 == 0) {
						p.setName("苹果");
						p.setPrice(6.5);
					} else {
						p.setName("香蕉");
						p.setPrice(2.0);
					}
					System.out.println(Thread.currentThread().getName() + "生产了：" + p);
					i++;
					p.setFalg(true);
					p.notifyAll();
				} else {
					try {
						p.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
