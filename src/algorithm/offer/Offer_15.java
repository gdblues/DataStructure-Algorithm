package algorithm.offer;

import static java.lang.Math.pow;

/**
 * 题目:给你一根长度为n的绳子，请把绳子剪成m段(m、n都是整数,
 * n>1并且m>1)，每段绳子的长度记为K[0],k[1],…H[m]。请问k[0]×k[1]×…×k[m]可能的最大乘积是多少?
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段,此时得到的最大乘积是18。
 * @author guojiaxin
 * @create 2021/1/5 13:31
 */
public class Offer_15 {
    /**
     * 使用动态规划解决
     * @param n
     * @return
     */
    public static int dynamicSolve(int n){
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        //数组记录了各个长度的最优解
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            //取一半来避免不必要的运算
            for (int j = 1; j <= i/2; j++) {
                int temp = result[j]*result[i-j];
                if(max<temp){
                    max = temp;
                }
                result[i] = max;
            }
        }
        return result[n];
    }

    /**
     * 用贪心算法，尽可能的多剪长度为3的绳子
     * @param n
     * @return
     */
    public static int greedySolve(int n){
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int x = n%3;
        int y = n/3;
        //正好能全分成长度为3的绳子
        if(x==0){
            return (int) pow(3,y);
        }
        //这种情况下能分成y-1个长度为3的和一个长度为4的，可以把这个长度为4的再分成两个2
        else if(x==1){
            return (int) (2*2*pow(3,y-1));
        }
        //最后一种情况分成y个3和1个2
        else {
            return (int) (2*pow(3,y));
        }
    }
    public static void main(String[] args) {
        System.out.println(dynamicSolve(3));
        System.out.println(greedySolve(3));
    }
}
