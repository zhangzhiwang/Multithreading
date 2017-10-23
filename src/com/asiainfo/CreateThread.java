package com.asiainfo;

/**
 * 创建线程
 * 
 * @author zhangzhiwang
 * @date 2017年10月23日 下午1:12:37
 */
public class CreateThread {
	public static void main(String[] args) {
		// 线程类是Thread，创建线程有两种方式：1、创建Thread的子类来覆盖Thread的run()方法 2、直接使用Thread的run()方法，但要给Thread传递Runnable对象（通过看源码可得知此过程）
		// 方式1:
		Thread thread1 = new Thread() {// start后，调用Thread的子类（这里为内部类）的run()方法
			@Override
			public void run() {
				System.out.println("1:" + Thread.currentThread().getName());
			}
		};
		thread1.start();// 启动线程，会自动调用Thread的run()方法
		
		//方式2:
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("2:" + Thread.currentThread().getName());
			}
		});
		thread2.start();
		
		//方式1优先于方式2，原因就是方式1用的是子类复写父类的方法，方式2直接用的是父类（Thread）的run()方法
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable:" + Thread.currentThread().getName());
			}
		}) {
			@Override
			public void run() {
				System.out.println("Thread son:" + Thread.currentThread().getName());
			}
		};
		thread3.start();//thread3用来证明方式1优先于方式2
	}
}
