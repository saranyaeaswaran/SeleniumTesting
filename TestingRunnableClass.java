package allTests;

import resources.RunnableClassForThreads;

public class TestingRunnableClass {

	public static void main(String[] args) {
		
		RunnableClassForThreads runClass = new RunnableClassForThreads();
		Thread thread1 = new Thread(runClass);
		thread1.start();
		while(RunnableClassForThreads.count<=10) {
			System.out.println("In main method : "+RunnableClassForThreads.count++);
		}
	}

}
