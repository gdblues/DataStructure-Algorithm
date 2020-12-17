package algorithm.offer;

/**
 * 创建单例模式
 * DCL单例 性能比直接加锁要高
 */
class Singleton{
    private Singleton(){
        System.out.println("单例模式已经启动！");
    }
    public static volatile Singleton instance = null;
    //不进行加锁的话会产生多个实例
    public static Singleton get_Instance1(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
    //只检查一次的话会同样会产生多个实例,多个线程都进入了if
    //锁加到全部代码上的话又会浪费性能
    public static Singleton get_Instance2() throws InterruptedException {
        if(instance==null){
            synchronized (Singleton.class){
                Thread.sleep(1000);
                instance = new Singleton();
            }
        }
        return instance;
    }
    //DCL单例解决了多线程环境下的单例模式创建问题,并且用volatile关键字来禁止指令重排序
    public static Singleton get_Instance3(){
        try {
            if(instance==null){
                synchronized(Singleton.class){
                    if (instance==null){
                        Thread.sleep(1000);
                        instance = new Singleton();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
public class Offer_03 {
    public static void main(String[] args) {
        /*Singleton instance = Singleton.get_Instance();
        System.out.println(instance);*/
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    System.out.println(Singleton.get_Instance3());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
