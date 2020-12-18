package level.level06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        final int count = 5;
        String result = "";
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            buf.append(s);
        }
        result = buf.toString();
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(s);
        }
        result = buf.toString();

        return result;
    }

    public static void main(String[] args) {
        
    }
}
