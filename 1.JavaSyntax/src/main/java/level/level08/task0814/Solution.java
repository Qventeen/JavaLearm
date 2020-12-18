package level.level08.task0814;

//import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.util.HashSet;
import java.util.function.Predicate;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(i+1);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //Подготовка предиката для удаления данных из множества HashSet
        Predicate<Integer> filter = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 10;
            }
        };
        set.removeIf(filter);
        return set;
    }

    public static void main(String[] args) {

    }
}
