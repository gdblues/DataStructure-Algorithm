package algorithm.offer;

import java.util.Arrays;
import java.util.List;

/**
 * 合并两个有序数组arr1,arr2
 * 假设arr1有足够的空间容纳arr2
 * @author guojiaxin
 * @create 2020/12/28 13:14
 */
public class Offer_06 {
    public static int[] merge(int[] arr1, int[] arr2){
        //记录arr1的有效长度
        int m = 0;
        //记录arr2的有效长度
        int n = arr2.length;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]==0){
                m = i;
                break;
            }
        }
        //相当于合并后的数组下标，需要减去1，因为是length
        int k = m+n-1;
        while (true){
            if(arr1[m-1]>arr2[n-1]){
                arr1[k] = arr1[m-1];
                k--;
                m--;
            }else{
                arr1[k] = arr2[n-1];
                k--;
                n--;
            }
            if(m<1||n<1){
                break;
            }
        }
        //arr1已经合并完了，直接合并arr2
        if(m<1){
            while (true){
                arr1[k--] = arr2[n-1];
                n--;
                if(n<1){
                    return arr1;
                }
            }
        }
        //arr2已经合并完了，直接合并arr1
        if(n<1){
            while (true){
                arr1[k--] = arr1[m-1];
                m--;
                if(m<1){
                    return arr1;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        arr1[0] = 3;
        arr1[1] = 6;
        arr1[2] = 9;
        int[] arr2 = new int[]{1,2,4,5,7,8,10};
        int[] merge = merge(arr1, arr2);
        for (int i = 0; i < merge.length; i++) {
            System.out.print(merge[i]+" ");
        }
    }
}
