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
        //为了防止棒状树，如果只有右子树没有左子树的话，根节点右面的数就都比根节点大，没有小于的部分
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
    /**
     * 给出搜索二叉树的前序遍历，还原搜索二叉树
     */
    public static BiTree process2(int[] posArr,int L,int R){
        if(R<L){
            return null;
        }
        //posArr[L]是根节点 用此节点的值作为比较值
        BiTree node = new BiTree(posArr[L]);
        if(L==R){
            return node;
        }
        int M = R+1;
        int left = L+1;
        int right = R;
        //动right 找出比目标值大的数，最后M的值就是处于右半段的第一个
        while (left<=right){
            int mid = left+((right-left)>>1);
            if(posArr[L]>posArr[mid]){
                left = mid+1;
            }else{
                right = mid-1;
                M=mid;
            }
        }
        node.left = process2(posArr,L+1,M-1);
        node.right = process2(posArr,M,R);
        return node;
    }


    /**
     * 直观打印二叉树
     * @param head
     */
    public static void printTree(BiTree head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 10);
        System.out.println();
    }

    public static void printInOrder(BiTree head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.data + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }


    public static void main(String[] args) {
        int[] posArr = new int[]{4,2,1,3,7,6};
//        BiTree process = process(posArr, 0, posArr.length - 1);
        BiTree process = process2(posArr, 0, posArr.length - 1);
//        System.out.println(process);
        printTree(process);
    }
}
