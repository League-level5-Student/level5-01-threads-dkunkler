package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
Thread [] threads;
ConcurrentLinkedQueue<Task> taskQueue;

ThreadPool(int totalThreads){
	threads = new Thread[totalThreads];
	taskQueue = new ConcurrentLinkedQueue<Task>();
	for(int i = 0; i<totalThreads; i++) {
		threads[i] = new Thread(new Worker(taskQueue));
	}

}

public void start()
{
	for( Thread t : threads) {
		t.start();
		try {
	
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public void addTask(Task task) {
	// TODO Auto-generated method stub
	taskQueue.add(task);
}



}
