package algorithm.other;

/**
 * 给定一个搜索二叉树的后序遍历posArr数组，根据数组还原二叉树
 * 搜索二叉树：左子树的值比根节点小，右子树的值比根节点大
 * @author guojiaxin
 * @create 2020/12/7 13:12
 */
class BiTree{
    int data;
    BiTree left;
    BiTree right;

    public BiTree(){}

    public BiTree(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BiTree{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
public class CreateSearchTreeByPos_001{
    /**
     * 时间复杂度O(n2)
     * @param posArr
     * @param L
     * @param R
     * @return
     */
    public static BiTree process(int[] posArr,int L,int R){
        if(L>R){
            return null;
        }
        BiTree head = new BiTree(posArr[R]);
        if(L==R){
            return head;
        }
        //为了防止棒状树，如果只有右子树没有左子树的话，根节点左面的数就都比根节点大，没有小于的部分
        //下面的循环出来就还是默认值，因为没有进行赋值，当M=L-1的时候，没有左子树就会是process(posArr, L, L-1),正好赋值为null
        int M = L-1;
        for (int i = 0; i < posArr.length-1; i++) {
            if(posArr[i]<posArr[R]){
                M = i;
            }
        }
        //for循环出来以后，L--M代表的就是左子树，M+1--R-1代表的就是右子树
        head.left = process(posArr, L, M);
        head.right = process(posArr, M + 1, R - 1);
        return head;
    }

    /**
     * 运用了二分查找，时间复杂度O(n*logn)
     * @param posArr
     * @param L
     * @param R
     * @return
     */
    public static BiTree process1(int[] posArr,int L,int R){
        if(L>R){
            return null;
        }
        BiTree head = new BiTree(posArr[R]);
        if(L==R){
            return head;
        }
        int M = L-1;
        int left = L;
        int right = R-1;
        while (left<=right){
            int mid = left+((right-left)>>1);
            if(posArr[mid]<posArr[R]){
                M = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        head.left = process1(posArr, L, M);
        head.right = process1(posArr, M+1, R-1);
        return head;
    }
    public static void main(String[] args) {
        int[] posArr = new int[]{1,2,3,4,5};
//        BiTree process = process(posArr, 0, posArr.length - 1);
        BiTree process = process1(posArr, 0, posArr.length - 1);
        System.out.println(process);
    }
}
