package com.jr.level.level20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        ArmstrongDigits arm = new ArmstrongDigits(N);
        arm.calcArmstrongDigits();
        List list = arm.getArmstrongDigits();
        for (int i = 0; i < list.size(); i++) {
            long tmp = (long) list.get(i);
            if(tmp >= N) {
                list.remove(i);
                i--;
            }
        }
        long[] result = new long[list.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = (long) list.get(k);
        }
        Arrays.sort(result);
        return result;

    }

    public static void main(String[] args) {

        for (long ln : getNumbers(9223372036854775807L)) {
            System.out.println(ln);
        }
//        System.out.println(Long.MAX_VALUE);
        /*0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407,
        1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725,
        4210818, 9800817, 9926315, 24678050, 24678051, 88593477,
        146511208, 472335975, 534494836, 912985153.*/

    }


    static class ArmstrongDigits {
        private List<Integer> maxDigit;             //Максимальное число поиска
        private int maxCountOrder;                  //Максимально число порядоков (опционально)
        private List<Integer> curentArrayDigits;    //Текущее число счетчика
        private List<Integer> setStoreArm;
        private List<Long> storeArmstrong;          //хранлище для чисел армстронга
        private long[][] powerTable;               //Таблица степеней
        private int[] setOfDigits;

        public ArmstrongDigits(long maxDigit) {
            this.maxDigit = getDigits(maxDigit, new ArrayList<Integer>(20));
            this.maxCountOrder = this.maxDigit.size();
            //Счетчикам изначально задается необходимая емкость
            this.curentArrayDigits = new ArrayList<Integer>(maxCountOrder);
            this.curentArrayDigits.add(0);

            setOfDigits = new int[maxCountOrder];
            this.setStoreArm = new ArrayList<Integer>(maxCountOrder);
            this.storeArmstrong = new LinkedList<Long>();
            //Инициализация нулем. Любое число >=0;
            //this.storeArmstrong.add((long) 0);

            //Таблица степеней
            powerTable = new long[10][];
            for (int i = 0; i < powerTable.length; i++)
                powerTable[i] = new long[maxCountOrder + 1];

            long tmp;
            for (int i = 1; i < powerTable.length; i++) {
                tmp = 1;
                for (int j = 1; j < maxCountOrder + 1; j++) {
                    tmp *= i;
                    powerTable[i][j] = tmp;
                }
            }
        }

        public void calcArmstrongDigits() {
            //Назначить стартовое значение из счетчика
            //Выполнять пока значение счетчика не превысит граничное число
            //???
            // TODO: возможно переполнение long при вычислении значения текущего счетчика

            while (compareTo(curentArrayDigits,maxDigit)< 0) {
                nextNumber();
                long candidate = nextArDigit();
                if (candidate > 0 && isArmstrong(candidate)) {
                    storeArmstrong.add(candidate);
                }
            }
        }

        public List<Long> getArmstrongDigits() {
            return new ArrayList<Long>(storeArmstrong);
        }

        //============================================================================================
        //Увеличивает значение curentArrayDigits до следующего значения
        private void nextNumber() {

            List<Integer> setCounter = curentArrayDigits;
            int rMax = 9;
            boolean flag = true;
            int tmp, i;
            for (i = 0; flag; i++) {
                // Счет количества измененных разрядов
                if (i >= curentArrayDigits.size()) {
                    curentArrayDigits.add(0);
                    break;
                }
                tmp = curentArrayDigits.get(i);
                // Если текущее значение > 9 то
                if (tmp < rMax) {
                    tmp++;
                    curentArrayDigits.set(i, tmp);
                    flag = false;
                }
            }
            // Если добавился разряд обнулить все предыдущие разряды
            // Обнуление необходимо поскольку подсчет чисел Армстронга
            // Считается суммированием значений разрядов приведенных в степень их количества
            // Посему каждый новый разряд требует пересчета ранее уже вычисленных значений
            if (flag) {
                for (i = curentArrayDigits.size() - 2; i >= 0; i--) {
                    curentArrayDigits.set(i, 0);
                }
                curentArrayDigits.set(0,1);
            }
            // Иначе привести все предыдущие значения счетчика к величине
            // Последнего рабочего разряда
            else if (i > 1) {
                tmp = curentArrayDigits.get(--i);
                for (; i > 0; i--) {
                    curentArrayDigits.set(i - 1, curentArrayDigits.get(i));
                }
            }
        }

        //Если имеет место переполнение возвращает -1
        private long nextArDigit() {
            long result = 0;
            for (int k = 0; k < curentArrayDigits.size(); k++) {
                try {
                    result = Math.addExact(result, powerTable[curentArrayDigits.get(k)][curentArrayDigits.size()]);
                } catch (ArithmeticException e) {
                    //В случае переполнения вернуть -1
                    return -1;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    System.out.println("Выход за пределы массива");
                    System.out.println(curentArrayDigits);
                    System.out.println("k= " + k);
                    System.out.println("Разрядность текущего числа = " + curentArrayDigits.size());
                    System.out.println("Размер таблицы степеней " +
                            powerTable.length + " на " + (powerTable[0]).length);
                    System.out.println("И что же мне делать?");
                    throw e2;
                }
            }
            return result;
        }

        //True если возвращается число Армстронга
        private boolean isArmstrong(long armCandidat) {
            //Очистить хранилище авог
            setStoreArm.clear();
            //Наполнить хранилище авог новыми значениями
            getDigits(armCandidat, setStoreArm);
            //Если разрядность счетчика не совпадает с разрадностью хранилища
            //числа однозначно не равны потому выход
            if (setStoreArm.size() != curentArrayDigits.size()) {
                return false;
            }
            for (int i = 0; i < curentArrayDigits.size(); i++) {
                setOfDigits[i] = curentArrayDigits.get(i);
            }
            //Выполняем сортировку по маске
            boolean flag = false;
            int tmp1, tmp2;
            for (int k = 0; k < setStoreArm.size(); k++) {
                tmp1 = setStoreArm.get(k);
                flag = false;
                for (int i = k; i < setStoreArm.size(); i++) {
                    if (tmp1 == setOfDigits[i]) {
                        tmp2 = setOfDigits[k];
                        setOfDigits[k] = setOfDigits[i];
                        setOfDigits[i] = tmp2;
                        flag = true;
                        break;
                    }
                }
                if (!flag) return false;

            }
            return flag;
        }


//============================================================================================
        //Получить набор цифр из переданного числа

        public static List<Integer> getDigits(long N, List<Integer> digits) {
            final int dec = 10;
            while (N > 0) {
                digits.add((int) (N % dec));
                N /= dec;
            }

            return digits;
        }

        //Поразрядное сравнение
        public static int compareTo(List<Integer> one, List<Integer> two) {
            //Предполагается что счетчик не имеет нулей в старших разрядах
            //Для моей задачи это именно так
            if (one.size() < two.size()) return -1;
            else if (one.size() > two.size()) return 1;
            int res = 0;
            int i = 0;
            try{
                for (i = one.size()-1; i >= 0; i--) {
                    if (one.get(i) < two.get(i)) {
                        res = -1;
                        break;
                    } else if (one.get(i) > two.get(i)) {
                        res = 1;
                        break;
                    }
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println("Размер 1 =" + one.size());
                System.out.println("Размер 2 =" + two.size());
                System.out.println("Значение 1" + i);
                System.out.println("Значение текущего счетчика");
                System.out.println(one);
                System.out.println("Значение Максимального числа");
                System.out.println(two);
                throw e;
            }

            return res;
        }

        //Получить число из массива цифр
//        public static long getValue(List<Integer> digits) {
//            int i = digits.size() - 1;
//            long tmp = digits.get(i);
//            while (i-- > 0) {
//                tmp = tmp * 10 + digits.get(i);
//            }
//
//            return tmp;
//        }



    }

}

/*              Мысли и заметки
 * ============================================================================================
 *
 * 26.07.2018
 * Задание
 * Получить значение числа
 * Найти все числа Армнстронга в диапазоне от 0 до заданного числа
 * Число Армстронга - N == n1^k+n2^k+...+nn^k
 * 			Где N - проверяемое число
 * 				n - цифра текущего разряда
 * 				k - степень == количеству разрядов текущего N
 *
 * Мое видение решения
 *
 * Получить предельное N
 * Вычислить количество разрядов N
 * Создать 2 мерный массив степеней числа
 * 	Значение степене цифр 0..9 заданных количеством разрядом числа
 * 	не может вызвать переполнения
 *
 * На базе имеющихся данных построить счетчик (а ля водяной)
 * Изменение счетчика должно быть последовательным. Нужен метод next()
 * 	Инициализируется в конструкторе числом N -> предельное число поиска
 * 	Задача счетчика выдавать число которое после вышеперечисленных вычислений
 * 	будет всегда давать новое число
 *
 *
 *
 *
 * Варианты решения
 *
 * 1 ТОПОР
 * Пока число меньше N делать
 *   Разложыть число на массив цифр
 *   Привести каждую цифру в степень количества их в масиве числа
 *   Суммировать полученный массив
 *   ЕСЛИ текущее число == полученной сумме
 *       Добавить его в выходной массив
 *
 *
 *   Дополним данный алгоритм некоторыми эвристиками
 *   1 Используем быстрое возведение в степень
 *       В библиотеке java наверника такая функция есть
 *   2 Исключаем перестановки
 *       Число = набор из n цифр от 0 до 9
 *       Набор может иметь n! перестанавок
 *       Для нашей задачи взаиморасположение цифр роли не играет (2*2 + 8*8) = (8*8+2*2)
 *       посему исключаем перестановки равенством K1 <= K2 <= K3 ...
 *       При каждом добавлении разряда обнуляем весь счетчик кроме старшей еденицы
 *
 * Улучшеный вариант
 * Общее
 *   Получить входное проверяемое число
 *   Вычислить количество разрядов числа
 *   Построить тапбицу степеней согласно количества разрядов
 *
 * Построение счетчика 1 ( k1 <= k2 <= k3)
 *   Строим числовой счетчик работающий по принципу K1 <= K2 <= k3 ...
 *   Итерация путем суммирования разности поразрядных данных и таблицы степеней
 *   При добавлении новых разрядов обнуляем весь счетчик кроме нового старшего разряда
 *   Вычисляем максимальное значение текущего разряда счетчика (для сравнения при счете)
 *       Нужно для пересчета чисел с учетом изменившейся степени пересчета
 *       То есть каждый новый разряд включает все предыдущие но с новой степени
 *       Явно рекурсивная постановка
 *   После каждой итерации получаем проверочное число.
 *   Если число полученное число превышает величину текущего разряда
 *       Обнуляем счетчик и считем следующий разряд.
 *
 *   Проверка на равность 1 (очень не эффективна для больших значений)
 *       Проводим все возможные перестановки текущего счетчика
 *       Возводим каждую к значащему числу
 *       Сравниваем
 *
 *   Проверка на равность 2 (Более эффективна по моему мнению)
 *       Раскладываем проверяемое число на разряды
 *       Выполняем поразрядный поиск втекущем счетчике
 *       Если все разряды найдены то это число Армстронга
 *       Иначе продолжаем.
 *
 *       Данный вариант выглядит значительно короче чем полный перебор.
 *       Я понмаю что разложение числа на разряды это достаточно затратная операция
 *       Но лучше 1 на 1 число чем n!-n для каждого.
 *
 *
 * Простой перебор с дополнениями.
 * Получить число
 * Разложить на разряды (узнать количество)
 * Построить таблицу степеней
 * Построить простой счетчик
 * Вычисляемое условное значение производим путем порязрядного суммирования разности
 *   Недостаток Перебор всех значений
 * Сравнение Поулченое значение == Паралельный счетчик числа
 *
 * Достоинства: Операции просты для вычисления
 * Все действия выполняются за счет операций суммирования и разности
 *
 * Недостаток: Необходим полный перебор.
 * Перебор множеста заведомо ложных значений
 *
 * */


