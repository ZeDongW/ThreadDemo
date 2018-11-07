
/**  
 * @Title: Inlet.java
 * @Package com.wzd.exercise.pool
 * @Description: 进水程序
 * @author wangzedong
 * @date 2018年8月26日下午11:04:45
 * @version V1.0  
 */

package com.wzd.exercise.pool;

/**
 * @ClassName: Inlet
 * @Description: 进水程序
 * @author wangzedong
 * @date 2018年8月26日下午11:04:45
 */

public class Inlet implements Runnable {
	// 共享的蓄水池
	Pool p;

	/**
	 * 创建一个新的实例 Inlet.
	 *
	 */

	public Inlet(Pool p) {
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
			if (p.getSize() <= (p.MAX_SIZE - 5)) {
				synchronized (p) {
					System.out.print("正在加水，当前池水量为：" + p.getSize() + "L");
					p.setSize(p.getSize() + 5);
					System.out.println(",加水后池水量为：" + p.getSize() + "L");
					p.notify();
				}
			} else {
				synchronized (p) {
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
