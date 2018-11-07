
/**  
 * @Title: SaleTicketsByImplements.java
 * @Package com.wzd.creatthread
 * @Description: 实现Runnable接口自定义异常类
 * @author wangzedong
 * @date 2018年8月25日下午9:24:24
 * @version V1.0  
 */

package com.wzd.creatthread;

/**
 * @ClassName: SaleTicketsByImplements
 * @Description: 实现Runnable接口自定义异常类
 * @author wangzedong
 * @date 2018年8月25日下午9:24:24
 */

public class SaleTicketsByImplements implements Runnable {

	// Runnable 是同一个对象不需要将票数设为静态
	// 票数
	int num = 50;

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
	 * @see java.lang.Runnable#run()
	 */

	@Override
	public void run() {
		saleTickets();
	}

	public static void main(String[] args) {
		SaleTicketsByImplements stbi = new SaleTicketsByImplements();
		Thread t1 = new Thread(stbi, "窗口1");
		Thread t2 = new Thread(stbi, "窗口2");
		Thread t3 = new Thread(stbi, "窗口3");
		t1.start();
		t2.start();
		t3.start();
	}
}
