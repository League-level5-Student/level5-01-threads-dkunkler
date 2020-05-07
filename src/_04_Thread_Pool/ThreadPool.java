package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
Thread [] threads;
ConcurrentLinkedQueue<Task> taskQueue;

ThreadPool(int totalThreads){
	threads = new Thread[totalThreads];
	for(int i = 0; i<totalThreads; i++) {
		threads[i] = new Thread();
	}
	taskQueue = new ConcurrentLinkedQueue<Task>();
}

}
