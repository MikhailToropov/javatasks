package task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Counter{
    
    List<Integer> count = Arrays.asList(0,1,2,3,4,5,6,7,8);    
   
    public synchronized void add(int value){
    	
      this.count.set(value, value);
    }
    
    public synchronized int get(){
    	int ret = 10;
    	do {
    	for(int x: count) {
    		if(x!=10) {
    			ret = x;
    			count.set(x, 10);
    			break;
    		}
    	}
    	}while(ret==10);
    	return ret;
    	}    
 }

class CounterThread extends Thread{

    protected Counter counter = null;

    public CounterThread(Counter counter){
       this.counter = counter;
    }
    @Override
    public void run() {
	System.out.println("Finish thread");
   }
    @SuppressWarnings("deprecation")
	public int get_unq_id() {
    	int x = this.counter.get(); 
    	System.out.println("send id");
    	this.stop();
    	return x;
    }
 }

public class MyTask1 {

	public static void main(String[] args) {
		Counter counter = new Counter();
	    IntStream.rangeClosed(1, 10).parallel().forEach(val -> System.out.println(String.format("First test. Thread %s have unique id %s", val, getUniqueId(counter))));
	    System.out.println("finish");

	    //IntStream.rangeClosed(1, 15).parallel().forEach(val -> System.out.println(String.format("Second test. Thread %s have unique id %s", val, getUniqueId())));

	}

	private static int getUniqueId(Counter x) {

		
	   
		CounterThread  thread = new CounterThread(x);
		
		uniqueId = thread.get_unq_id();
	    return uniqueId;

	}

	}