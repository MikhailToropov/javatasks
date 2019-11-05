package task;

import java.util.ArrayList;
import java.util.List;

class ObjectA{
	int id;
	String field;
	String ff;
	ObjectA(int arg1, String arg2, String arg3){
		this.id = arg1;
		this.field = arg2;
		this.ff = arg3;
	}
	public void check(ObjectA arg)
	{
		if(this.id!=arg.id) {
		System.out.println("Wrong id");	
		}
		if(!this.field.equals(arg.field)) {
			System.out.println(String.format("Wrong field for id:%s", this.id));	
		}
		if(!this.ff.equals(arg.ff)) {
			System.out.println(String.format("Wrong value for id:%s", this.id));	
			}
    }
}
public class MyTask4 {
	
	
public static void main(String[] args) {
	List<ObjectA> data = new ArrayList<ObjectA>();

	data.add(new ObjectA(1, "field1", "value1"));
	data.add(new ObjectA(2, "field2", "value2"));
	data.add(new ObjectA(3, "field3", "value3"));
	data.add(new ObjectA(4, "field4", "value4"));
	
	List<ObjectA> checkdata = new ArrayList<ObjectA>();
	checkdata.add(new ObjectA(1, "field1", "value1"));
	checkdata.add(new ObjectA(2, "otherfield", "value2"));
	checkdata.add(new ObjectA(3, "field3", "othervalue"));
	checkdata.add(new ObjectA(4, "otherfield", "othervalue"));
	for(int i=0; i< data.size(); i++) {
		data.get(i).check(checkdata.get(i));
	}
}
}
