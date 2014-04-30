package com.java;

public class Singleton {

	private Singleton() {
	};
	
	public void say() {
		System.out.println("My object is::" + this);
	}
	
	/*
	 * 懒汉模式
	 */
	/*private static Singleton single = new Singleton();
	public static Singleton getSingleton() {
		return single;
	}
*/
	
	/*
	 * 饿汉模式
	 */
	
/*	private static Singleton single=null;
	public static Singleton getSingleton(){
		if(single==null)
			single=new Singleton();
		return single;	
	}
	*/

	/*
	 * 匿名静态内部类
	 */
	
	/*private static class SingletonHolder{
		private final static Singleton single=new Singleton();
	}
	public static Singleton getSingleton(){
		return SingletonHolder.single;
	}*/
	
	/*
	 * double check ,适用于多线程情况
	 */
	private static Singleton single=null;
	public static Singleton getSingleton(){
		if(single==null){
			synchronized(Singleton.class){
				if(single==null){
					single=new Singleton();
				}
			}
		}
		return single;
	}
	
	public static void main(String aa[]) {
		Singleton single1 = Singleton.getSingleton();
		Singleton single2 = Singleton.getSingleton();
		
		single1.say();
		single2.say();
	}

}
