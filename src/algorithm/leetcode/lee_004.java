package algorithm.leetcode;

import java.util.ArrayList;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lee_004 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int x = 0;
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            while (j!=nums2.length){
                if(nums1[i]>=nums2[j]){
                    list.add(nums2[j]);
                    j++;
                }else{
                    list.add(nums1[i]);
                    x = 1;
                    break;
                }
            }
            if(x==1){
                x=2;
                continue;
            }
            list.add(nums1[i]);
        }
        while (j<nums2.length){
            list.add(nums2[j]);
            j++;
        }
        /*for (Integer integer : list) {
            System.out.println(integer);
        }*/
        double num = Double.parseDouble("" + list.get(list.size() / 2));
        //System.out.println(num);
        if(list.size()%2==1){
            return num;
        }else{
            double num1 = Double.parseDouble("" + list.get(list.size() / 2-1));
            return  (num+num1)/2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0};
        int[] nums2 = new int[]{0,0};
        System.out.println(findMedianSortedArrays(nums1,nums2));
        double a=0;

        System.out.println(a/2);
    }
}
