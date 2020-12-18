package com.jr.level.level27.task2712;

import com.jr.level.level27.task2712.kitchen.Dish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //Выводит строку в консоль
    public static void writeMessage(String message){
        System.out.println(message);
    }

    //Читает строку из консоли
    public static String readString() throws IOException {
        return reader.readLine();
    }
    //Получает заказ у пользователя
    public static List<Dish> getAllDishesForOrder() throws IOException{
        writeMessage("Список блюд нашего ресторана:");
        writeMessage(Dish.allDishesToString());
        writeMessage("Для завершения заказа введите exit");

        List<Dish> listDishes = new ArrayList<>();
        String tmpName = "";
        Dish tmpDish;
        while (true){
            tmpName = readString();
            try{
                //Попытка создать блюдо по имени
                tmpDish = Dish.valueOf(tmpName.trim());
                listDishes.add(tmpDish);
            }catch(IllegalArgumentException e){
                //Корявая проверка ввода через исключение
                if("exit".equals(tmpName))
                    return listDishes;
                else
                    writeMessage("К сожалению такого блюда в меню нет.");
            }
        }
    }


}
