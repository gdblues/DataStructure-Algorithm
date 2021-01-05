package algorithm.offer;

/**
 * 求斐波那契数列的第n项(非递归)
 * @author guojiaxin
 * @create 2021/1/5 13:20
 */
public class Offer_14 {
    /**
     * 使用递归求解太浪费资源，造成很多不必要的运算，可以自底向上保存结果
     * @param n
     * @return
     */
    public static int getFib(int n){
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n ; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(getFib(4));
    }
}
