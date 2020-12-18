package level.level09.task0903;

/* 
Кто меня вызывал?
*/
//Поговорим
//Нужна строка вызова каждого текущего метода
//Значит нужно получить элемент стека который отражает текущий метод
//Там должна быть такая строка

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static int method1() {
        method2();
        return  (Thread.currentThread().getStackTrace())[2].getLineNumber();
    }

    public static int method2() {
        method3();
        return  (Thread.currentThread().getStackTrace())[2].getLineNumber();
    }

    public static int method3() {
        method4();
        return  (Thread.currentThread().getStackTrace())[2].getLineNumber();
    }

    public static int method4() {
        method5();
        return  (Thread.currentThread().getStackTrace())[2].getLineNumber();
    }

    public static int method5() {
//        StackTraceElement[] e = Thread.currentThread().getStackTrace();
//        for (StackTraceElement s: e){
//            System.out.println(s);
//            System.out.println(s.getMethodName());
//            System.out.println(s.getLineNumber());
//        }
        return (Thread.currentThread().getStackTrace())[2].getLineNumber();
    }
}
