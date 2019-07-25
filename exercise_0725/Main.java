package exercise.exercise_0725;

/*
简单错误记录（2)
循环记录：记录后8条
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        while(in.hasNext()){
            String[] strs = in.next().split("\\\\");
            String str = strs[strs.length-1];
            str = str+" "+in.next();
            int index = list.indexOf(str);
            if(index==-1){
                list.add(str);
                count.add(1);
            }else{
                count.set(index,count.get(index)+1);
            }
        }
        for(int i=Math.max(0,list.size()-8); i<list.size(); i++){
            String s = list.get(i);
            String name = s.split(" ")[0];
            if(name.length()>16){
                s = name.substring(name.length()-16)+" "+s.split(" ")[1];
            }
            System.out.println(s+" "+count.get(i));
        }
    }
}