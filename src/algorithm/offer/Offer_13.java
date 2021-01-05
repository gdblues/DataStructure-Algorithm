package algorithm.offer;

/**题目:地上有一个m行n列的方格。
 * 一个机器人从坐标(0,0)的格子开始移动，它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * 但它不能进入方格(35,38)，因为3+5+3+8=19.请问该机器人能够到达多少个格子?
 * @author guojiaxin
 * @create 2021/1/5 12:33
 */
public class Offer_13 {
    public static int hasPath(int rows,int cols,int k){
        if(rows<=0||cols<=0||k<0){
            return -1;
        }
        boolean[][] isVisited = new boolean[rows][cols];
        return hasPathScore(k,0,0,rows,cols,isVisited);
    }

    public static int hasPathScore(int k, int row, int col, int rows, int cols, boolean[][] isVisited) {
        int count = 0;
        if(row>=0&&row<rows&&col>=0&&col<cols&&!isVisited[row][col]&&(getScore(row)+getScore(col)<=k)){
            isVisited[row][col] = true;
            count = 1 + hasPathScore(k, row+1, col, rows, cols, isVisited)
                    + hasPathScore(k, row-1, col, rows, cols, isVisited)
                    + hasPathScore(k, row, col-1, rows, cols, isVisited)
                    + hasPathScore(k, row, col+1, rows, cols, isVisited);
        }
        return count;
    }

    /**
     * 获取横纵坐标得分
     * @param number
     * @return
     */
    public static int getScore(int number){
        int sum = 0;
        while (number>0){
            sum += number%10;
            number = number/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(hasPath(1,22, 6));
    }
}
