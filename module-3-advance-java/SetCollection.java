
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/*
import java.util.List;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args){   
    	
    	List<Integer> nums=new ArrayList<Integer>();
    	nums.add(6);
    	nums.add(5);
    	nums.add(8);
    	nums.add(2);
    	nums.add(6);
    	//nums.add("5");
    	
    	for(Object n:nums)
    	{
    		int num=(Integer)n;
    		System.out.println(num+2);
    	}
    }
}
 */
public class SetCollection {

    public static void main(String[] args) {

//    	Set<Integer> nums=new HashSet<Integer>();  	
//    	Set<Integer> nums=new TreeSet<Integer>();
        Collection<Integer> nums = new TreeSet<Integer>(); // it is SET in sorted format
        nums.add(62);
        nums.add(54);
        nums.add(82);
        nums.add(21);

        //nums.add("5");
        Iterator<Integer> values = nums.iterator(); // replacement of for loop

        while (values.hasNext()) { // hasNext tells that do we have next element
            System.out.println(values.next());
        }

//    	for(int n:nums)
//    	{
//    		System.out.println(n);
//   	}
    }
}
