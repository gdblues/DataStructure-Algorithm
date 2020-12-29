package algorithm.offer;

/**
 * 求链表数组中倒数第k个节点
 * 思路：可以设置两个指针，一个从k开始 一个从1开始
 * 当right指针走到头的时候left指针指向的就是倒数第k个节点
 */
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
public class Offer_02 {
    public static int getKNum(Node head,int k){
        int temp_num = k;
        //右指针
        Node right = head;
        //左指针
        Node left = head;
        if(k<1){
            return -1;
        }
        while (temp_num>1&&right.next!=null){
            right = right.next;
            temp_num--;
        }
        //边界判定，输入的k大于链表的容量
        if(right.next==null&&temp_num>1){
            return -1;
        }
        while (right.next!=null){
            left = left.next;
            right = right.next;
        }
        return left.data;
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
        System.out.println(Offer_02.getKNum(node1,7));
    }
}
