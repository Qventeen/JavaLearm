package com.jr.level.level33.sandbox.evalutor3404;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Рекурсия для мат. выражения

Решение согласно условий задания из JR
Метод решения.
Многократное послойное решение скобочных подвыражений
Распознание слоев выполняется за счет активного использования
регулярных выражений.
Краткий механизм

Выделяем самое верхнее скобочное подвыражение

Вызываем вычислитель выражения
  Выполняем вычисление предварительно подготовленных функций вида (sin|cos|tan)[-]?\\d+(\\.\\d+)?
  Вычисляем слой возведения в степень
  Вычисляем мультипликативный слой
  Вычисляем аддитивный слой
  Возвращаем итоговое значение подвыражения
Заменяем вычисляемое подвыражение найденным значением
Делаем рекурсивный вызов передаем модифицированное выражения на довычисление

Глубина рекурсии зависит от количества скобочных подвыражений независимо от глубины вложения
Вычисления завершаются когда выражение модифицируется до состояния единственного значения

*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recurse(final String expression, int countOperation) {
        if(countOperation == 0){
            countOperation = countOperations(expression);
        }
        //Очистить выражение от пробелов
        String expr = expression.replaceAll("\\s","");
        String subExpr = getSubExpression(expr);
        StringBuilder sb;
        //Если подвыражение существует
        if(subExpr.startsWith("(")){
            //Удаляем скобки
            sb = new StringBuilder(subExpr.substring(1,subExpr.length()-1));
        }else{
            //Вычисляем подвыражение на текущем уровне
            sb = new StringBuilder(subExpr);
        }

        evalSubExpr(sb);

        expr = expr.replace(subExpr,sb.toString());
        //Если входящее выражение одинарное число
        if (expr.matches("^[-]?\\d+(\\.\\d+)?$")){
            //Вывести результат и завершить рекурсию
            System.out.println(format(Double.parseDouble(expr)) + " " + countOperation);
        } else{
            //Выполнить рекурсивный вызов
            recurse(expr,countOperation);
        }
    }

    private static String getSubExpression(String expression){
        //Поиск самих глубоких скобок выражений
        Pattern pS = Pattern.compile("\\([^()]*\\)");
        Matcher mS = pS.matcher(expression);
        //Найти подвыражение верхних скобок
        if(mS.find()){
            return expression.substring(mS.start(),mS.end());
        }
        return expression;
    }

    private static void evalSubExpr(StringBuilder sb){
        //Вычислить подвыражение
        evalFunction(sb);
        evalPower(sb);
        evalMult(sb);
        evalAdd(sb);
    }

    private static void evalFunction(StringBuilder expr){
        //Паттерн поиска функций с готовым числом
        Pattern pF = Pattern.compile("(sin|cos|tan)[-]?\\d+(\\.\\d+)?");
        Matcher matcher = pF.matcher(expr);
        String sub;
        while(matcher.find()){
            sub = expr.substring(matcher.start(), matcher.end());

            double result = Math.toRadians(Double.parseDouble(sub.substring(3)));
            switch (sub.substring(0,3)){
                case "sin":
                    result = Math.sin(result);
                    break;
                case "cos":;
                    result = Math.cos(result);
                    break;
                case "tan":
                    result = Math.tan(result);
                    break;
            }
            expr.replace(matcher.start(), matcher.end(), getString(result, ""));
            matcher = pF.matcher(expr);
        }
    }

    private static void evalPower(StringBuilder expr){
        //Поиск выражений приведения в степень
        Pattern pP = Pattern.compile("(\\d+(\\.\\d+)?)\\^([-]?\\d+(\\.\\d+)?)");
        Matcher matcher = pP.matcher(expr);

        //Пока находится бинарные операции приведения в степень
        while(matcher.find()){
            String [] nums = expr.substring(matcher.start(), matcher.end()).split("\\^");
            Double result = Math.pow(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
            expr.replace(matcher.start(), matcher.end(), getString(result, "%f"));
            matcher = pP.matcher(expr);
        }
    }

    private static void evalMult(StringBuilder expr){
        //Поиск мультипликативного выражения
        Pattern pM = Pattern.compile("([-]?\\d+(\\.\\d+)?)[/*]([-]?\\d+(\\.\\d+)?)");
        Matcher matcher = pM.matcher(expr);
        while(matcher.find()){
            String sub = expr.substring(matcher.start(), matcher.end());
            boolean flag = sub.contains("*");
            String [] num = sub.split("([*/])");
            Double result;
            if(flag){
                result = Double.parseDouble(num[0]) * Double.parseDouble(num[1]);
            }else{
                result = Double.parseDouble(num[0]) / Double.parseDouble(num[1]);
            }
            expr.replace(matcher.start(), matcher.end(), getString(result, ""));
            matcher = pM.matcher(expr);
        }
    }

    private static void evalAdd(StringBuilder expr){
        //Поиск аддитивного выражения
        Pattern pA = Pattern.compile("[-]?\\d+(\\.\\d+)?[-+][-]?\\d+(\\.\\d+)?");
        Matcher matcher = pA.matcher(expr);
        while(matcher.find()){
            String sub = expr.substring(matcher.start(), matcher.end());
            boolean flag = sub.contains("+");
            String [] num = sub.split("(?<=[\\d])[+\\-]");
            Double result;
            if(flag){
                result = Double.parseDouble(num[0]) + Double.parseDouble(num[1]);
            }else{
                result = Double.parseDouble(num[0]) - Double.parseDouble(num[1]);
            }
            expr.replace(matcher.start(), matcher.end(), getString(result, ""));
            matcher = pA.matcher(expr);
        }
    }

    private static int countOperations(String expression){
        //Подсчитать количество операций в подвыражении
        Pattern pattern = Pattern.compile("(sin|cos|tan|\\*|\\/|\\^|\\+|\\-)");
        Matcher matcher = pattern.matcher(expression);
        int counter = 0;
        while(matcher.find()){
            counter++;
        }
        return counter;
    }

    private static String getString(Double x, String format){
        String form;
        if("".equals(format)) form = "%f";
        else form = format;
        return String.format(Locale.US, form, x);
    }

    private static String format(Double x){
        DecimalFormat format = new DecimalFormat("##########.##");
        format.setRoundingMode(RoundingMode.HALF_UP);
        return format.format(x);
    }

    public Solution() {
        //don't delete
    }
}


