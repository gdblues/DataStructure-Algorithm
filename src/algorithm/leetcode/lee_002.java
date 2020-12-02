package algorithm.leetcode;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class lee_002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //node是头节点，不能变，所以再创建一个temp
        ListNode node = new ListNode();
        ListNode temp = node;
        //carry是进位
        int carry = 0;
        while (l1!=null||l2!=null||carry!=0){
            int l1val = l1!=null?l1.val:0;
            int l2val = l2!=null?l2.val:0;
            int sum = l1val+l2val+carry;
            //carry就是进位，如果sum大于10的话就为1，相当于下一回进一
            carry = sum/10;
            ListNode NewNode = new ListNode(sum%10);
            temp.next=NewNode;
            temp=NewNode;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(4,node1);
        ListNode node3 = new ListNode(5,node2);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(9,node4);
        ListNode node6 = new ListNode(9,node5);
        ListNode node = addTwoNumbers(node3, node6);
        System.out.println(node);
    }
}
class ListNode {
    int val;
    ListNode next;

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}