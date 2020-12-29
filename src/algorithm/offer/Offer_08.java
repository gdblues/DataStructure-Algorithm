package algorithm.offer;

import java.util.Arrays;

/**
 * 根据前序遍历和中序遍历还原二叉树
 * @author guojiaxin
 * @create 2020/12/29 12:56
 */
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
    }
    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
public class Offer_08 {
    public static TreeNode build(int[] preArr,int[] inArr){
        if(preArr==null||inArr==null||preArr.length!=inArr.length){
//            throw new RuntimeException("输入异常！");
            return null;
        }
        //先把前序遍历的第一个节点当作根节点
        int rootValue = preArr[0];
        TreeNode root = new TreeNode(rootValue);
        root.left = null;
        root.right = null;
        if(preArr.length==1&&inArr.length==1){
            return root;
        }
        //遍历中序遍历的数组找到根节点,i代表中序遍历中根节点的位置
        int i = 0;
        for (; i < inArr.length; i++) {
            if(inArr[i]==rootValue){
                break;
            }
        }
        if(i==inArr.length){
            throw new RuntimeException("输入异常！");
        }
        int leftLength = i;
        int rightLength = inArr.length-i-1;
        //找出前序遍历中的左子树，然后递归
        if(leftLength>0){
            int[] preArr1 = new int[leftLength];
            int[] inArr1 = new int[leftLength];
            System.arraycopy(preArr,1,preArr1,0,leftLength);
            System.arraycopy(inArr,0,inArr1,0,leftLength);
            root.left = build(preArr1,inArr1);
        }
        //找出前序遍历中的右子树，然后递归
        if(rightLength>0){
            int[] preArr1 = new int[rightLength];
            int[] inArr1 = new int[rightLength];
            System.arraycopy(preArr,i+1,preArr1,0,rightLength);
            System.arraycopy(inArr,i+1,inArr1,0,rightLength);
            root.right = build(preArr1,inArr1);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preArr = new int[]{1,2,4,7,3,5,6,8};
        int[] inArr = new int[]{4,7,2,1,5,3,8,6};
        System.out.println(build(preArr,inArr));
    }
}
