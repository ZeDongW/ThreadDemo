
/**  
 * @Title: Saleticket.java
 * @Package com.wzd.creatthread
 * @Description: 继承Thread类自定义线程
 * @author wangzedong
 * @date 2018年8月25日下午8:25:09
 * @version V1.0  
 */

package com.wzd.creatthread;

/**
 * @ClassName: Saleticket
 * @Description: 通过继承Thread类自定义线程
 * @author wangzedong
 * @date 2018年8月25日下午8:25:09
 */

public class SaleTicketsByExtends extends Thread {
	// 共享静态变量，票数
	static int num = 50;

	/**
	 * 创建一个新的实例 SaleTicketsByExtends.
	 *
	 */

	public SaleTicketsByExtends(String name) {
		super(name);
	}

	/**
	 * 
	 * @Title: saleTickets @Description: 卖票程序 @throws
	 */
	public void saleTickets() {
		while (true) {
			synchronized (this.getClass()) {
				if (num > 0) {
					System.out.println(Thread.currentThread().getName() + "卖出了第" + num + "张票");
					num--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("票售罄了.....");
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

	/**
	 * 重写run方法
	 */
	@Override
	public void run() {
		saleTickets();
	}

	public static void main(String[] args) {
		SaleTicketsByExtends atbe1 = new SaleTicketsByExtends("窗口1");
		SaleTicketsByExtends atbe2 = new SaleTicketsByExtends("窗口2");
		SaleTicketsByExtends atbe3 = new SaleTicketsByExtends("窗口3");
		atbe1.start();
		atbe2.start();
		atbe3.start();
	}
}
