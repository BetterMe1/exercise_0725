package exercise.exercise_0725;

import java.util.Arrays;

/*
从100万个数里面找出10个最大的数。写出代码并分析复杂度。
维护一个10个元素的最小堆。算法复杂度O(N)
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for(int i=0;i<arr.length; i++){
           arr[i] = i+1;
        }
        int[] result = sort(arr,10);
        System.out.println(Arrays.toString(result));
    }
    public static int[] sort(int[]arr, int n){
        int[] result = new int[n];
        System.arraycopy(arr,0,result,0,n);
        //调整为大根堆
        for(int i=n-1; i>=0; i--){
            adjustDown(result,i,n);
        }
        //维护:成为小根堆
        maintainHeap(result);
        /*
        遍历剩下的数据，维护小根堆
         */
        for(int i=n; i<arr.length; i++) {
            if(arr[i] > result[0]){
                result[0] = arr[i];
                maintainHeap(result);
            }
        }
        return result;
    }

    /**
     * 维护小根堆
     * @param arr
     */
    private static void maintainHeap(int[] arr) {
        int tmp = 0;
        int end = arr.length-1;
        while(end > 0){
            tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            adjustDown(arr,0,end);
            end--;
        }
    }

    /**
     * 向下调整
     * @param arr
     * @param i
     */
    private static void adjustDown(int[] arr, int i,int len) {
        int c = 2*i+1;//左孩子
        int tmp = 0;
        while(c<len){
            c = c+1<len ? (arr[c]<arr[c+1]?c+1:c):c;//最大孩子
            if(arr[c] >arr[i]){
                tmp = arr[c];
                arr[c] = arr[i];
                arr[i] = tmp;
                i=c;
                c=2*i+1;
            }else{
                break;
            }
        }
    }
}
