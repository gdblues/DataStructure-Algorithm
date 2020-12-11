package algorithm.other;

/**
 * 给定一个数组[1,2,3],有n2种排列方式
 * (1,1) (1,2)....
 * 对这些数组进行排序，第一个相同的就比第二个，最后排好序
 * 返回第k小的数组
 * @author guojiaxin
 * @create 2020/12/11 13:34
 */
public class Return_Karr_004 {
    public static int[] getArr(int[] arr,int k){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int[] ans = new int[2];
        if(k%arr.length==0){
            int i = k / arr.length;
            int arr1 = arr[i - 1];
            int arr2 = arr[arr.length-1];
            ans[0] = arr1;
            ans[1] = arr2;
        }else{
            int arr1 = arr[k/arr.length];
            int arr2 = arr[k%arr.length];
            ans[0] = arr1;
            ans[1] = arr2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,3,4};
        int[] arr1 = getArr(arr, 4);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }
    }
}
