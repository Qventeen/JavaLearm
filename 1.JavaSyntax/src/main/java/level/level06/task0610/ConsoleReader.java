package level.level06.task0610;

import java.util.Scanner;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int readInt() throws Exception {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static double readDouble() throws Exception {
        return new Scanner(System.in).nextDouble();
    }

    public static boolean readBoolean() throws Exception {
        return new Scanner(System.in).nextBoolean();
    }

    public static void main(String[] args) {

    }
}
