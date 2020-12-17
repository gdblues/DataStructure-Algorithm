package algorithm.offer;

/**
 * 把一个字符串转换成整数
 */
public class Offer_01 {
    public static int toNum(String str){
        char[] array = str.toCharArray();
        int num=0;
        for (int i = 0; i < array.length; i++) {
            num = num*10+array[i]-'0';
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(toNum("990"));
    }
}
