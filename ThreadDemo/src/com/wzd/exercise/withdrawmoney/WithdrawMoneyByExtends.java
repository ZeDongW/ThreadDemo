
/**  
 * @Title: WithdrawMoneyByExtends.java
 * @Package com.wzd.exercise
 * @Description: 银行取钱练习
 * @author wangzedong
 * @date 2018年8月25日下午10:02:18
 * @version V1.0  
 */

package com.wzd.exercise.withdrawmoney;

/**
 * @ClassName: WithdrawMoneyByExtends
 * @Description: 银行取钱练习
 * @author wangzedong
 * @date 2018年8月25日下午10:02:18
 */

public class WithdrawMoneyByExtends extends Thread {

	// 银行总存款
	static int total = 5000;

	/**
	 * 创建一个新的实例 WithdrawMoneyByExtends.
	 *
	 */

	public WithdrawMoneyByExtends(String name) {
		super(name);
	}

	/**
	 * 
	 * @Title: withdrawMoney @Description: 取钱动作 @throws
	 */
	public void withdrawMoney() {
		while (true) {
			synchronized (this.getClass()) {
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
	 * @see java.lang.Thread#run()
	 */

	@Override
	public void run() {
		withdrawMoney();
	}

	public static void main(String[] args) {
		WithdrawMoneyByExtends wmbe1 = new WithdrawMoneyByExtends("丈夫");
		WithdrawMoneyByExtends wmbe2 = new WithdrawMoneyByExtends("妻子");
		wmbe1.start();
		wmbe2.start();
	}
}
