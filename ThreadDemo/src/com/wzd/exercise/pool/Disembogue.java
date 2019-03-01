
/**  
 * @Title: Disembogue.java
 * @Package com.wzd.exercise.pool
 * @Description: 放水程序
 * @author wangzedong
 * @date 2018年8月26日下午11:15:34
 * @version V1.0  
 */

package com.wzd.exercise.pool;

/**
 * @ClassName: Disembogue
 * @Description: 放水程序
 * @author wangzedong
 * @date 2018年8月26日下午11:15:34
 */

public class Disembogue implements Runnable {

	Pool p;// 共享水池

	/**
	 * 创建一个新的实例 Disembogue.
	 *
	 */

	public Disembogue(Pool p) {
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
		        if (p.getSize() >= 2) {
					        System.out.print("正在放水，当前池水量为：" + p.getSize() + "L");
					        p.setSize(p.getSize() - 2);
					        System.out.println(",放水后池水量为：" + p.getSize() + "L");
					        p.notify();
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
