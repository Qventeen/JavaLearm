package com.jr.level.level36.task3611;

import java.util.HashSet;
import java.util.Set;

/* 
Сколько у человека потенциальных друзей?
*/

public class Solution {
    private boolean[][] humanRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humanRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              // Expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           // Expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        /**
         * Идеи для решения
         * Путь обхода массива
         * 4,0 -> 4,1 -> 4,2 -> 4,3 -> 4,4 (блок) -> 5,4 -> 6,4 -> 7,4 стоп
         *
         * Вариант 1 (Горизонтальный обход графа)
         * Создать Текущую очередь и положить в нее стартовый сет
         * Пройти по массиву данных указанным способом попутно вкладывая подходящие индексы в парную очередь
         * одновременно вкладывая данные индексы и в итоговый сет
         * Завершив текущую итерацию глубины увеличиваем счетчик глубины
         * Делаем обмен очередями и запускаем итерацию следующей очереди
         *
         * Вариант 2 (Вертикальный обход графа)
         * Создать дополнительный рекурсивный метод с условием погружения на указанную глубину
         * Выход из метода по превышении глубины.
         * Условие работы получив входной индекс и итоговый сет пройти по данным при обнаружении
         * подходящих данных дополнить итоговый сет подходящим индексом и выполнить рекурсивный спуск
         *
         */
        //Создать и подготовить набор индексов
        Set<Integer> res = new HashSet<>();
        recursSearchOfFriends(res, index, deep, index);
        return res;
    }

    private void recursSearchOfFriends(Set<Integer> res, int index, int deep, int parent){
        if(deep <= 0) return;
        for(int i = 0; i < humanRelationships.length; i++){
            //Блокировка обратного вызова
            if(parent == i) continue;

            if(i < index && humanRelationships[index][i]){
                res.add(i);
                recursSearchOfFriends(res, i,deep - 1, index);

            } else if(i > index && humanRelationships[i][index]){
                res.add(i);
                recursSearchOfFriends(res, i, deep -1, index);
            }
        }
    }

    // Remove from the set the people with whom you already have a relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humanRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    // Return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}
