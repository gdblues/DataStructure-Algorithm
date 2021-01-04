package algorithm.offer;

/**
 * 题目:请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * @author guojiaxin
 * @create 2021/1/4 12:56
 */
public class Offer_12 {

    public static boolean hasPath(char[][] matrix,char[] nums){
        if(matrix==null||nums==null){
            return false;
        }
        //维护一个二维数组，记录走过的路径
        int rows = matrix.length;
        int cols = matrix[0].length;
        int pathLength = 0;
        boolean[][] isVisited = new boolean[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if(hasPathScore(matrix,nums,rows,cols,row,col,pathLength,isVisited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean hasPathScore(char[][] matrix,char[] nums,int rows,int cols,
                                       int row,int col,int pathLength,boolean[][] isVisited){
        //说明已经走到头了
        if(pathLength==nums.length){
            return true;
        }
        boolean path = false;
        //满足第一个条件，往后递归，如果出错再回溯
        if(row>=0&&col>=0&&row<=rows&&col<=cols&&matrix[row][col]==nums[pathLength]&&!isVisited[row][col]){
            pathLength++;
            isVisited[row][col]=true;
            //如果第一个元素相同，再递归他的上下左右
            path = hasPathScore(matrix,nums,rows,cols,row+1,col,pathLength,isVisited)
                    ||hasPathScore(matrix,nums,rows,cols,row-1,col,pathLength,isVisited)
                    ||hasPathScore(matrix,nums,rows,cols,row,col-1,pathLength,isVisited)
                    ||hasPathScore(matrix,nums,rows,cols,row,col+1,pathLength,isVisited);
            //说明没有找到，回溯，length-1
            if(!path){
                pathLength--;
                isVisited[row][col]=false;
            }
        }
        return path;
    }
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}
        };
        char[] nums = new char[]{'b','f','c','f'};
        System.out.println(hasPath(matrix,nums));
    }
}
