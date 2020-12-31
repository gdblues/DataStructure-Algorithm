package algorithm.offer;

/**
 * 题目:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组{3,4,5,1,2为{1,2,3,4,5}的一个旋转,该数组的最小值为1。
 * 思路:二分查找
 * @author guojiaxin
 * @create 2020/12/31 13:14
 */
public class Offer_11 {
    public static Integer printReverse(int[] arr){
        if(arr.length==0||arr==null){
            return null;
        }
        if(arr.length==1){
            return arr[0];
        }
        int i = 0;
        int j = arr.length-1;
        while (i<j-1){
            int mid = i+((j-i)>>1);
            //第一个元素小于最后一个元素的时候说明数组没有经过旋转，直接返回
            if(arr[i]<arr[j]){
                return arr[i];
            }
            //三个元素值相等
            if((arr[i]==arr[j])&&(arr[i]==arr[mid])){
                //只能用顺序查找
                int result = arr[i];
                for (int k = i+1; k <= j; k++) {
                    if(arr[k]<arr[mid]){
                        result = arr[k];
                    }
                }
                return result;
            }
            //第一个元素大于等于最后一个元素
            else if(arr[i]>=arr[j]){
                //mid定位到了前一个递增数组上
                if(arr[i]<=arr[mid]&&arr[j]<=arr[mid]){
                    i = mid;
                    //后一个递增数组上
                }else if(arr[mid]<=arr[i]&&arr[mid]<=arr[j]){
                    j = mid;
                }
            }
        }
        return arr[j];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,4};
        System.out.println(printReverse(arr));
    }
}
