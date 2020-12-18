package com.jr.level.level33.sandbox.evalutor3404;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Рекурсия для мат. выражения
*/
public class RecurseMethod {
    private String expression = "";
    private int pos = 0;
    private char ch = '\0';

    public static void main(String[] args) {
        RecurseMethod recurse = new RecurseMethod();
        recurse.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
        recurse.recurse("(sin(253))", 0);

    }

    public void recurse(final String expr, int countOperation) {
        if (countOperation == 0) {
            countOperation = countOperations(expr);
        }
        init();
        expression = expr;

        Double result = expression();
        if(ch != 0){
            error("Неожиданное завершение выражения", expression, pos - 1);
        }
        System.out.println(format(result) + " " + countOperation);
    }

    private void init(){
        this.ch = 0;
        this.pos = 0;
    }

    private int countOperations(String expression) {
        //Подсчитать количество операций в подвыражении
        Pattern pattern = Pattern.compile("(sin|cos|tan|\\*|\\/|\\^|\\+|\\-)");
        Matcher matcher = pattern.matcher(expression);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    private String format(Double x) {
        DecimalFormat format = new DecimalFormat("##########.##");
        format.setRoundingMode(RoundingMode.HALF_UP);
        return format.format(x);
    }

    public RecurseMethod() {
        ch = '\0';
        pos = 0;

        //don't delete
    }

    private double expression() {
        double result;
        read();
        if (ch == '-') {
            read();
            result = -terminus();
        } else {
            result = terminus();
        }
        while (ch == '+' || ch == '-') {
            if (ch == '+') {
                read();
                result += terminus();
            } else {
                read();
                result -= terminus();
            }
        }
        return result;
    }

    private double terminus() {
        double result = multiple();
        while (ch == '*' || ch == '/') {
            if (ch == '*') {
                read();
                result *= multiple();
            } else {
                read();
                result /= multiple();
            }
        }
        return result;
    }

    private double multiple() {
        double result = number();
        if (ch == '^') {
            read();
            result = Math.pow(result, multiple());
        }
        return result;
    }

    private double number() {
        double result = 0;
        if(Character.isAlphabetic(ch)){
            result = function();
        }else if (ch == '(') {
            result = expression();
            if (ch != ')') {
                error("Ожидается закрывающая скобка", expression, pos - 1);
            } else {
                read();
            }
        } else if(Character.isDigit(ch)){
            //Если открывающей скобки нет то читаем простое число
            result = real();
        } else {
            error("Неожиданный символ", expression, pos - 1);
        }
        return result;
    }

    private double function() {
        String fName = identifier();
        double result = expression();
        if(ch != ')') {
            error("Ожидается закрывающая скобка", expression, pos - 1);
        } else {
            read();
        }
        result = Math.toRadians(result);
        switch (fName){
            case "cos":
                result = Math.cos(result);
                break;
            case "sin":
                result = Math.sin(result);
                break;
            case "tan":
                result = Math.tan(result);
                break;
            default:
                error("Неизвестное имя функции", expression, pos - 1);
        }
        return result;
    }

    private double real() {
        StringBuilder sb = new StringBuilder();
        sb.append(integer());
        if (ch == '.') {
            sb.append(ch);
            read();
            sb.append(integer());
        }

        return Double.parseDouble(sb.toString());
    }

    private String integer() {
        StringBuilder sb = new StringBuilder();
        //Если первый символ число не цифра
        if (!Character.isDigit(ch)) {
            //Ошибка
            error("Ожидается цифра", expression, pos - 1);
        }
        while (Character.isDigit(ch)) {
            sb.append(ch);
            read();
        }
        return sb.toString();
    }

    private String identifier() {
        StringBuilder sb = new StringBuilder();
        do{
            sb.append(ch);
            read();
        }while(Character.isAlphabetic(ch));
        return sb.toString();
    }

    //Generic functions
    public void read() {
        if(pos >= expression.length())
            ch = '\0';

        while (pos < expression.length()) {
            ch = expression.charAt(pos++);
            if(!Character.isWhitespace(ch)) {
                break;
            }
        }

    }

    public void error(String message, String expression, Integer errPos) {
        char[] chars = new char[errPos];
        Arrays.fill(chars, ' ');
        StringBuilder sb = new StringBuilder(message);
        sb.append('\n')
                .append(expression)
                .append('\n')
                .append(chars)
                .append('^')
                .append('\n');

        System.out.println(sb.toString());
        throw new RuntimeException();
    }
}

    /**
     * Решение задачи через преобразование в польскую запись
     * Решение должно быть рекурсивным
     * Решение должно пошагово преобразовывать входящее выражение в итоговый результат
     * который в глубине рекурсии выводится на экран
     *
     * Дано
     * Математическое скобочное выражение выражение
     *
     * Не терминальные символы
     * E = expression = выражение
     * A = [+-] additional
     * M = [/*] multiplicative
     * P = [^] exponential
     * N = [numbers (recursion)]
     * D = [digits]
     *
     * Граматика
     * E -> TA
     * A -> e | +TA | -TA
     * T -> MB
     * B -> e | *MB | /MB
     * M -> NC
     * C -> e | ^N
     * N -> dF | +dF | -dF | (E)
     * F -> e | dF | .dF | (E)
     * d -> 0|1|2|3|4|5|6|7|8|9
     *
     */



