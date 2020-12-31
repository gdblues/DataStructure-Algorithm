package algorithm.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列模拟栈
 * @author guojiaxin
 * @create 2020/12/30 13:02
 */
public class Offer_10 {
    private static Queue<Integer> queue1 = new LinkedList<>();
    private static Queue<Integer> queue2 = new LinkedList<>();
    //往模拟栈中压入元素
    public static void push(Integer num){
        if(!queue1.isEmpty()){
            queue1.add(num);
        }else {
            queue2.add(num);
        }
    }
    //弹出模拟栈中的元素
    public static void pop(){
        if(queue1.isEmpty()&&queue2.isEmpty()){
            throw new RuntimeException("栈中没有数据了。。");
        }
        if(queue1.isEmpty()){
           //把queue2中的元素转移到queue1，保留最后一个进入队列的元素并删除
           while (queue2.size()!=1){
               queue1.add(queue2.remove());
           }
            System.out.println(queue2.remove());
        }else {
            //把queue1中的元素转移到queue1，保留最后一个进入队列的元素并删除
            while (queue1.size()!=1){
                queue2.add(queue1.remove());
            }
            System.out.println(queue1.remove());
        }
    }

    public static void main(String[] args) {
        push(2);
        push(3);
        push(4);
        push(5);
        push(6);
        push(7);
        push(8);
        pop();
        pop();
        pop();
        pop();
        push(9);
        push(10);
        push(11);
        pop();
        pop();
        pop();
        pop();
        pop();
        pop();
        pop();
        pop();
    }
}
