package algorithm.structure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author guojiaxin
 * @create 2020/12/25 10:21
 */
class Node{
    int date;
    Node left;
    Node right;
    public Node(int date){
        this.date = date;
    }
}
public class Tree {
    /**
     * 递归创建
     * @param list
     * @return
     */
    public static Node CreateTree(LinkedList<Integer> list){
        Node head = null;
        if(list==null||list.isEmpty()){
            return null;
        }
        Integer date = list.removeFirst();
        if(date!=null){
            head = new Node(date);
            head.left = CreateTree(list);
            head.right = CreateTree(list);
        }
        return head;
    }
    public static void prePrint(Node head){
        if(head==null){
            return;
        }
        System.out.println(head.date);
        prePrint(head.left);
        prePrint(head.right);
    }
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        Node node = CreateTree(linkedList);
        prePrint(node);

    }
}
