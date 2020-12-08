package algorithm.other;

/**
 * 给定两个字符串，一个str一个aim 需要从str中找出和aim相匹配的字符串，顺序可以不一样
 * @author guojiaxin
 * @create 2020/12/8 13:38
 */
public class slide_window_002 {
    public static int matching_01(String str,String aim){
        char[] strs = str.toCharArray();
        char[] aims = aim.toCharArray();
        if(aim.length()>str.length()||str==null||aim==null){
            return -1;
        }
        //表明无效还款情况
        int validDate = 0;
        int R = 0;
        //存放标志位的数组
        int[] count = new int[256];
        //先打出“欠债单”，然后str再一个一个还
        for (int i = 0; i < aims.length; i++) {
            count[aims[i]]++;
        }
        //让窗口拥有目标数组的全部标志 (0,len-1)
        for (; R < aims.length; R++) {
            if(count[strs[R]]-- <= 0){
                validDate--;
            }
        }
        for (; R < strs.length; R++) {
            //说明窗口中的字母正好和aim中的一样
            if(validDate==0){
                return R-aims.length;
            }
            //标志位数组中，每有一个相同的，标记减一，但如果小于0的话，说明发生了无效退还，validDate--；
            if(count[strs[R]]-- <= 0){
                validDate--;
            }
            if(count[strs[R-aims.length]]++ < 0){
                validDate++;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String str = "abckfbca";
        String aim = "cbf";
        System.out.println(matching_01(str,aim));
    }
}
