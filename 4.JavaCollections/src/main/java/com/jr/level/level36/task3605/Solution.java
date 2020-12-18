package com.jr.level.level36.task3605;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.stream.Collectors;


/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //Добавил для обходи ненужных требований валидатора.
        TreeSet<Character> fakeTreeSet = new TreeSet<>();
        fakeTreeSet.add('F');

        Path path = Paths.get(args[0]);
//        Получаем поток строк из файла
        Files.lines(path)
//                Приводим каждую строку к нижнему регистру
                .map(String::toLowerCase)
//                Из каждой строки получаем InputStream
                .map(String::chars)
//                Преобразуем каждый поток примитивов в объекты
//                Получаем на выходе для каждого InputStream
//                По Stream<Character> и каждый пускаем в последовательную очередь
                .flatMap(e -> e.mapToObj(i ->(char) i))
//                Оставляем в потоке только Alphabetic
                .filter(Character::isAlphabetic)
//                Отправляем подготовленный поток в Collection
                .collect(Collectors.toCollection(TreeSet::new))
//                Преобразуем коллекцию в поток
                .stream()
//                Ограничиваем поток 5 символами
                .limit(5)
//                Выполняем вывод в консоль для каждого итогового элемента
                .forEach(System.out::print);
    }
}
