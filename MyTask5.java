package task;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyTask5 {
	public static void main(String[] args) {
		List<String> keys = new ArrayList<>();
        List<String> dbkeys1 = new ArrayList<>();
        List<String> dbkeys2 = new ArrayList<>();

        keys.add(new String("A"));
        keys.add(new String("B"));
        keys.add(new String("C"));
        keys.add(new String("D"));

        dbkeys1.add(new String("A"));
        dbkeys1.add(new String("B"));
        dbkeys1.add(new String("C"));
        dbkeys1.add(new String("D"));
        dbkeys1.add(new String("E"));
        
        dbkeys2.add(new String("A"));
        dbkeys2.add(new String("B"));
        dbkeys2.add(new String("C"));
        dbkeys2.add(new String("E"));
        
        
        Set<String> result = dbkeys1.stream().distinct().filter(Predicate.not(keys::contains)).collect(Collectors.toSet());
        System.out.println(result);
        result = keys.stream().distinct().filter(Predicate.not(dbkeys1::contains)).collect(Collectors.toSet());
        System.out.println(result);
        result = dbkeys2.stream().distinct().filter(Predicate.not(keys::contains)).collect(Collectors.toSet());
        System.out.println(result);
        result = keys.stream().distinct().filter(Predicate.not(dbkeys2::contains)).collect(Collectors.toSet());
        System.out.println(result);
       
    }

}
