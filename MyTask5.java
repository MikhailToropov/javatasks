package task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyTask5 {
	public static void check_db_keys(List<String> arg1, List<String> arg2) {
		Set<String> keysset = new HashSet<String>(arg1);
		Set<String> keysdbset = new HashSet<String>(arg2);
		keysdbset.removeAll(keysset);
		if(!keysdbset.isEmpty()) {
		System.out.println(keysdbset);
		keysset = new HashSet<String>(arg1);
		keysdbset = new HashSet<String>(arg2);
		keysset.removeAll(keysdbset);
		if(!keysset.isEmpty()) {
			System.out.println(keysset);
		}
		}
	}

	public static void check_keys(Set<String> arg1, Set<String> arg2) {
		Set<String> k = arg1;
		Set<String> dbk = arg2;
		k.removeAll(dbk);
		if(!k.isEmpty()) {
			System.out.println(k);
		}
	}

	
	public static void main(String[] args) {

		List<String> keys = new ArrayList<String>();
        keys.add("A");
        keys.add("B");
        keys.add("C");
        keys.add("D");

        List<String> keysdb1 = new ArrayList<String>();
        keysdb1.add("A");
        keysdb1.add("B");
        keysdb1.add("C");
        keysdb1.add("D");
        keysdb1.add("E");
        
        List<String> keysdb2 = new ArrayList<String>();
        keysdb2.add("A");
        keysdb2.add("B");
        keysdb2.add("C");
        keysdb2.add("E");
        check_db_keys(keys, keysdb1);
        check_db_keys(keys, keysdb2);        
  
	}

}
