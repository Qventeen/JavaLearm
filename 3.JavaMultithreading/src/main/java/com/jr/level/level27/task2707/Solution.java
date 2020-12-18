package com.jr.level.level27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread thread1 = new Thread(()-> {
            solution.someMethodWithSynchronizedBlocks(o1, o2);
        });

        Thread thread2 = new Thread(()-> {
            synchronized (o1) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }
                synchronized (o2) {}
            }
        });
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread2.start();
        thread1.start();
        Thread.sleep(50);

        if(Thread.State.BLOCKED == thread2.getState()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
