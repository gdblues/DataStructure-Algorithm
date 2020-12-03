import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class lee_003 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        //存放不重复子串的长度
        int len=0;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if(map.containsKey(c1)){
                len=map.size()>len?map.size():len;
                Integer temp = map.get(c1);
                map.clear();
                for (int j = temp+1; j < i; j++) {
                    map.put(s.charAt(j),j);
                }
            }
            map.put(c1,i);
        }
        return map.size()>len?map.size():len;
    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        String s = "abvavsc";
        int i = lee_003.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
