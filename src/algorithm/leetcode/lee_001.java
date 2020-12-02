package algorithm.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，
 * 并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class lee_001 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            //HashMap中存放跟nums数组中一一对应的补数
            //先进行包含判断，如果map中有将要进入的nums[i]值
            //说明下标为i的数和map中,key为nums[i]的value对应的nums中的值  互为补数
            if(map.containsKey(nums[i])){
                arr[0]=map.get(nums[i]);
                arr[1]=i;
                return arr;
            }
            //HashMap中存放跟nums数组中一一对应的补数
            map.put((target-nums[i]),i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,5,11};
        int[] solute = twoSum(nums, 10);
        for (int i = 0; i < 2; i++) {
            System.out.println(solute[i]);
        }

    }
}
