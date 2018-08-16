package sort;

import org.apache.poi.ss.formula.functions.T;

/**
 * Created by gzy on 2018/6/7.
 */
public class BubbleSort {

    public static void main(String argu[]){
        int[] list={2,5,1,17,6,55};
        for(int i=0;i<list.length;i++){
            for(int j=0;j<list.length-i-1;j++){
                if(list[j]>list[j+1]){
                    int temp = list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                }
            }
        }
        for(int i : list){
            System.out.println(i);
        }
    }
}
