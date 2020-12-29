package algorithm.offer;

/**
 * 字符串替换，把空格转换成%20
 * @author guojiaxin
 * @create 2020/12/28 12:53
 */
public class Offer_05 {
    public static String transfer(String s){
        char[] chars = s.toCharArray();
        if(chars.length==0||chars==null){
            return "-1";
        }
        //记录出现了多少次空格
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==' '){
                count++;
            }
        }
        //创建一个新的数组,长度是原来的加上空格出现次数*2(每个空格由一个单位变成了三个单位,所以要加二)
        char[] arr = new char[chars.length+2*count];
        int j = chars.length-1;
        int i = arr.length-1;
        //从后往前赋值
        while (true) {
            if(chars[j]!=' '){
                arr[i] = chars[j];
                i--;
                j--;
            }else {
                arr[i--] = '0';
                arr[i--] = '2';
                arr[i--] = '%';
                j--;
            }
            if(j<0){
                break;
            }
        }
        return String.valueOf(arr);
    }
    public static void main(String[] args) {
        System.out.println(transfer("adddd"));
    }
}
