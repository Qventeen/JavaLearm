package level.level07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }
    /**Даный метод фиксит значения списка строк**/
    public static ArrayList<String> fix(ArrayList<String> list) {

        //Получаем ссылку на строку затем ищем нужные символы
        //строке и в зависимости от результата меняем список
        //Думаю список foreach здесь не подойдет
        String s;
        int k = list.size();
        int i = 0;
        while(i < k){
            s = list.get(i);
            if(s.indexOf('р') >= 0 && s.indexOf('л') >= 0){
            }
            else if(s.indexOf('р') >= 0){
                list.remove(i);
                i--;k--;
            }else if(s.indexOf('л') >= 0){
                list.add(i, list.get(i));
                i++;k++;
            }
            i++;
        }
        return list;
    }
}
