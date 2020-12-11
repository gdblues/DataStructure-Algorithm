package algorithm.other;

/**
 * 创建一个数组,输入数组的最大容量来创建
 * 要求i<K<j的情况下
 * arr[i]+arr[j]!=2*arr[k]
 * 假设已经创建出了这样的一个数组 那么它的每一个数组都+1也同样符合要求
 * 每个数组都*2也同样符合要求，那么就能用分治的思想先创建出元素只有一个的数组，然后再创建出前半部分是奇数，后半部分是偶数的数组
 * 再拿这个数组做奇变换，偶变换。。。。知道创建出符合要求的size数组
 * @author guojiaxin
 * @create 2020/12/11 13:02
 */
public class Distinct_arr_003 {
    public static int[] create_arr(int size){
        if(size==1){
            return new int[]{1};
        }
        //向上取整 如果要创建长度为9的数组 可以采用5+4的方式而不能使用4+4+1的方式
        int halfSize = (size+1)/2;
        //base创建出来的是半个符合要求的数组
        int[] base = create_arr(halfSize);
        //ans用来存放完全的数组，先把base数组进行奇变换，再进行偶变换
        int[] ans = new int[size];
        int index=0;
        //先进行奇变换
        for (; index < base.length; index++) {
            ans[index] = base[index]*2-1;
        }
        //再进行偶变换
        for (int i=0; index < size; index++,i++) {
            ans[index] = base[i]*2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = create_arr(8);
        //进行暴力验证
        for (int i = 0; i < arr.length; i++) {
            for (int k = i+1; k < arr.length; k++) {
                for (int j = k+1; j < arr.length; j++) {
                    if(arr[i]+arr[j]==2*arr[k]){
                        System.out.println("验证错误");
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
