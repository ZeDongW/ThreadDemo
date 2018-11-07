
/**  
 * @Title: DeadLock.java
 * @Package com.wzd.deadlock
 * @Description: 简单死锁例子
 * @author wangzedong
 * @date 2018年8月26日下午3:22:36
 * @version V1.0  
 */

package com.wzd.deadlock;

/**
 * @ClassName: DeadLock
 * @Description: 简单死锁例子
 * @author wangzedong
 * @date 2018年8月26日下午3:22:36
 */

public class DeadLock implements Runnable {

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @see java.lang.Runnable#run()
	 */

	@Override
	public void run() {
		if ("A".equals(Thread.currentThread().getName())) {
			synchronized ("A") {
				System.out.println(Thread.currentThread().getName() + "   get A  wait B......");
				synchronized ("B") {
					System.out.println(Thread.currentThread().getName() + "   get A  and B, success!!");
				}
			}
		} else if ("B".equals(Thread.currentThread().getName())) {
			synchronized ("B") {
				System.out.println(Thread.currentThread().getName() + "   get B  wait A......");
				synchronized ("A") {
					System.out.println(Thread.currentThread().getName() + "   get A  and B, success!!");
				}
			}
		}
	}

	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		Thread t1 = new Thread(dl, "A");
		Thread t2 = new Thread(dl, "B");
		t1.start();
		t2.start();
	}
}
