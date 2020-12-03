package algorithm.leetcode;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class lee_003 {
    public static int lengthOfLongestSubstring(String s) {
        //使用滑动窗口
        HashMap<Character,Integer> map = new HashMap<>();
        //存放滑动窗口的起始位置
        int start = 0;
        //存放窗口的最大长度
        int ans=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //先进行包含判断，如果包含，去除重复的和它之前的元素
            if(map.containsKey(c)){
                //如果出现重复元素的话才会动start，start会到第一次出现的下一个元素位置
                start = Math.max(start,map.get(c));
            }
            ans = Math.max(ans,i-start+1);
            //这里存放的是加一，因为可以正好赋值给start。有重复的话start会变到第一次出现位置的下一个元素
            map.put(c,i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        String s = "";
        int i = lee_003.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
