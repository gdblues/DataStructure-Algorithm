package algorithm.offer;

import java.util.Stack;

/**
 * 倒序输出一个链表(可以是用栈或者是递归)
 * @author guojiaxin
 * @create 2020/12/29 12:41
 */
public class Offer_07 {
    /**
     * 使用栈来进行输出
     * @param head
     */
    public static void print1(Node head){
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while (temp!=null){
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    /**
     * 使用递归来输出
     * @param head
     */
    public static void print2(Node head){
        Node temp = head;
        if(temp==null){
            return;
        }
        print2(head.next);
        System.out.println(temp.data);
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        print1(node1);
    }
}
