package cn.itcast.utils;

/**
 * @author amy
 * @date 2019/9/27 15:00
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        MyRunnable5 mr5 = new MyRunnable5();
        Thread t1 = new Thread(mr5);
        Thread t2 = new Thread(mr5);

        t1.start();
        t2.start();
    }
}

class MyRunnable5 implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(ticket>0) {
                synchronized (this) {
                    ticket--;
                    try {
                        Thread.sleep (100);
                    } catch (InterruptedException e) {
                        e.printStackTrace ( );
                    }
                    System.out.println ("您购买的票剩余" + ticket + "张" + Thread.currentThread ( ).getName ( ));
                }
            }
        }
    }
}