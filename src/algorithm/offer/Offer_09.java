package algorithm.offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 * @author guojiaxin
 * @create 2020/12/30 12:43
 */
public class Offer_09 {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();
    //往队列尾部添加数据
   public static void appendTail(Integer num){
       //stack1用来添加数据
       stack1.push(num);
   }
   //删除队列头部数据
    public static void deleteHead(){
        //删除数据的时候把stack1中的数据依次出栈并转移到stack2中，此时stack1中FILO的元素就成了stack2中的FIFO
        if(stack1.isEmpty()&&stack2.isEmpty()){
            throw new RuntimeException("队列中无数据");
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        System.out.println(stack2.pop());
    }

    public static void main(String[] args) {
        appendTail(3);
        appendTail(4);
        deleteHead();
        deleteHead();
        appendTail(5);
        appendTail(6);
        appendTail(7);
        appendTail(8);
        deleteHead();
        deleteHead();
        deleteHead();
    }
}
