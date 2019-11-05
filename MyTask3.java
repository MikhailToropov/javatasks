package task;

public class MyTask3 {
    public static String cleanfunc(String arg){

        for(int i=0; i<arg.length(); i++) {
            String ss = arg.substring(i,i+1);
            if (arg.contains(ss+ss)){
                arg = arg.replace(ss+ss, "");
                return cleanfunc(arg);
            }
        }
        return arg;
         
     }
     public static void main(String []args){
        String sample1 = "aaabccddd";
        String sample2 = "baab";
        System.out.println(sample1);
        System.out.println(cleanfunc(sample1));
        System.out.println(sample2);
        System.out.println(cleanfunc(sample2));
     }
}
