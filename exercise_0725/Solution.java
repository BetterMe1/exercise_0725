package exercise.exercise_0725;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int num = array[0];
        int count = 1;
        for(int i=1; i<array.length; i++){
            if(array[i] == num){
                count++;
            }else{
                count--;
            }
            if(count == 0 && i+1<array.length){
                num = array[i+1];
                count = 1;
            }
        }
        //检验
        count = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] == num){
                count++;
            }
        }
        if(count*2>array.length){
            return num;
        }
        return 0;
    }
}