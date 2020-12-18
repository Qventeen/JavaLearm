package com.jr.level.level28.task2805;


public class MyThread extends Thread {
    private static int curentPriority = 0;
    {
        curentPriority++;
        curentPriority = (curentPriority % (MAX_PRIORITY +1)) == 0 ? 1 : curentPriority;
        int maxPriority = MAX_PRIORITY;
        if(getThreadGroup()!=null){
            maxPriority = getThreadGroup().getMaxPriority();
        }
        this.setPriority(curentPriority <= maxPriority? curentPriority: maxPriority);
    }

    public MyThread() {

    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
