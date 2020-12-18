package level.level06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        x1 = x1-x2;
        x1 = x1 < 0? -x1 : x1;

        y1 = y1-y2;
        y1 = y1 < 0? -y1 : y1;
        
        double tmp = x1*x1 + y1*y1;
        return Math.sqrt(tmp);
    }

    public static void main(String[] args) {

    }
}
