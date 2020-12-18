package level.level09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        StackTraceElement[] e = Thread.currentThread().getStackTrace();
        //join интересный способ соединения строк
        System.out.println(String.join(": ", e[2].getClassName(), e[2].getMethodName(), s));
    }
}
