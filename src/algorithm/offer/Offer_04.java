package algorithm.offer;

/**
 * 给定一个二维数组，从左到右 从上到下分别升序排列，再给定一个数，要求找出这个数的位置
 * @author guojiaxin
 * @create 2020/12/24 13:16
 */
public class Offer_04 {
    public static int[] getPos(int[][] matrix,int number){
        //行
        int row = matrix.length;
        //列
        int col = matrix[0].length;
        int count = 0;
        //先从二维数组右上角开始查找，如果比目标数大，剔除那一列反之剔除那一行
        while (true){
            //比目标数大，注意要做好边界条件的判断
            if(matrix[row-1][count]>number){
                if(row--==1){
                    return new int[]{-1,-1};
                }
            }else if(matrix[row-1][count]<number){
                if(count++==(col-1)){
                    return new int[]{-1,-1};
                }
            }else {
                return new int[]{row-1,count};
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,3,5,9},
                {2,4,7,10},
                {6,8,11,13}
        };
        int[] pos = getPos(matrix, 1);
        for (int i = 0; i < pos.length; i++) {
            System.out.print(pos[i]+" ");
        }
        String s = new String("abd add");
        String replace = s.replace(" ", "%20");
        System.out.println(replace);
    }
}
