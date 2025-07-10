class Counter
{
	int count;
	// public void increment()
    /*
    synchronized helps to avoid clashes between threads -> meaning if both threads incrementing at the same exact time, it will only increment once and will give inaccurate result, but synchronized helps to avoid such clashes and make one thread wait a little for seamless execution; so this increment() can be call by any one place at a time.
    This clashing is called race-condition and this 'synchronized' helps to avoid it
    */
	public synchronized void increment()
	{
		count++;
	}
}

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException{   
    	
    	Counter c=new Counter();
    	
    	Runnable obj1=()->
    	{
//    		for(int i=1;i<=1000;i++)
    		for(int i=1;i<=10000;i++)
    		{
    			c.increment();
    		}
    	};
    	
    	Runnable obj2=()->
    	{
//    		for(int i=1;i<=1000;i++)
    		for(int i=1;i<=10000;i++)
    		{
    			c.increment();
    		}
    	};
    	
    	Thread t1=new Thread(obj1);
    	Thread t2=new Thread(obj2);
    	 	
    	t1.start();
    	t2.start();
    	
    	t1.join(); // If not added main() will just print count value and will stop the overall execution
    	t2.join(); // Using this helps main() thread to wait for specified thread to come back

    	System.out.println(c.count);
        /*
        
        t1      main        t2
        |        |          |
        |        |          |
        |        |          |
        ---------|-----------
                 | joining 2 threads with main thread
                 |
                 |
            continue the execution
        */
    	
    }
}