
/**  
 * @Title: WithdrawMoneyByImplements.java
 * @Package com.wzd.exercise
 * @Description: 银行取钱练习
 * @author Administrator
 * @date 2018年8月25日下午10:19:02
 * @version V1.0  
 */

package com.wzd.exercise;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * @ClassName: WithdrawMoneyByImplements
 * @Description: 银行取钱练习
 * @author Administrator
 * @date 2018年8月25日下午10:19:02
 */

public class WithdrawMoneyByImplements implements Runnable {
	// 银行总存款
	static int total = 5000;
	// 共享锁对象
	static Object o = new Object();

	/**
	 * 
	 * @Title: withdrawMoney @Description: 取钱动作 @throws
	 */
	public void withdrawMoney() {
		while (true) {
			synchronized (o) {
				if (total > 0) {
					System.out.println(Thread.currentThread().getName() + "取出了1000块， 剩余" + (total - 1000) + "元");
					total -= 1000;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("对不起，您的存款不足，无法取钱！！！");
					break;
				}
			}
		}
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @see java.lang.Runnable#run()
	 */

	@Override
	public void run() {
		withdrawMoney();
	}

	public static void main(String[] args) {
		WithdrawMoneyByImplements wmbi = new WithdrawMoneyByImplements();
		Thread t1 = new Thread(wmbi, "丈夫");
		Thread t2 = new Thread(wmbi, "妻子");
		t1.start();
		t2.start();
	}
}
