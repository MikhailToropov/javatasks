package task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Counter{
    
    List<Integer> count = Arrays.asList(0,1,2,3,4,5,6,7,8,9);    
   
    public synchronized void add(int value){
      System.out.println(value);
      this.count.set(value, value);
    }
    
    public synchronized int get(){
    	int ret = 10;
    	for(int x: count) {
    		if(x!=10) {
    			ret = x;
    			count.set(x, 10);
    			break;
    		}
    	}
    	return ret;
    	}
    public int getid(){
    	int ret = 10;
    	do {
    		ret = this.get();
    	}while(ret==10);
    	return ret;
    }
 }

class CounterThread extends Thread{

    protected Counter counter = null;
    int uval;

    public CounterThread(Counter counter){
       this.counter = counter;
    }

    public void run() {
    try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    this.counter.add(this.uval);
	
	
   }
	public int get_unq_id() {
    	this.uval = this.counter.getid();
    	return this.uval;
    }
 }

public class MyTask1 {

	public static void main(String[] args) {
		Counter counter = new Counter();
	    IntStream.rangeClosed(1, 10).parallel().forEach(val -> System.out.println(String.format("First test. Thread %s have unique id %s", val, getUniqueId(counter))));
	    IntStream.rangeClosed(1, 15).parallel().forEach(val -> System.out.println(String.format("Second test. Thread %s have unique id %s", val, getUniqueId(counter))));
	    System.out.println("finish");
	}

	private static int getUniqueId(Counter x) {

	    int uniqueId;
	   
		CounterThread  thread = new CounterThread(x);
		thread.start();
		uniqueId = thread.get_unq_id();
	    return uniqueId;
	}
	}