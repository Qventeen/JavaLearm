package level.level04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[3];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(rd.readLine());
        }
        boobleSort(num);
        for(int i = 0; i < num.length-1; i++){
            System.out.print(num[i] + " ");
        }
        System.out.print(num[num.length-1]);
    }

    //Пузырьковая сортировка работа через ссылочную переменную
    //Фактически для сортировки передается объект int[]
    public static int[] boobleSort(int[] mass){
        int r;
        for (int i = 0; i < mass.length-1; i++) {
            for (int j = i+1; j < mass.length; j++) {
                if(mass[i] < mass[j]){
                    r = mass[i];
                    mass[i] = mass[j];
                    mass[j] = r;
                }
            }
        }
        return mass;
    }
}
