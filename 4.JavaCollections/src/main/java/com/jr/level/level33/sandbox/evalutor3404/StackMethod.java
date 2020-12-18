package com.jr.level.level33.sandbox.evalutor3404;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Рекурсия для мат. выражения
*/
public class StackMethod {
    private Stack<Double> argS = new Stack<>();
    private Stack<Character> opS = new Stack<>();

    private String expression = "";
    private int pos = 0;
    private char ch = '\0';

    public static void main(String[] args) {
        StackMethod recurse = new StackMethod();
        recurse.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
        recurse.recurse("(sin(253))", 0);

    }

    public void recurse(final String expr, int countOperation) {
        if (countOperation == 0) {
            countOperation = countOperations(expr);
        }
        init();
        expression = expr;

        expression();
        if(ch != 0){
            errorA("Неожиданное завершение выражения", expression, pos - 1);
        }
        System.out.println(format(argS.pop()) + " " + countOperation);
    }

    private void init(){
        argS.clear();
        opS.clear();
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

    public StackMethod() {
        //don't delete
    }

    private void expression() {
        read();
        if(ch == '-' || ch == '+'){
            opS.push(ch); read();
        } else {
            opS.push('+');
        }
        terminus();
        argS.push(unoOp());
        while(ch == '+' || ch == '-'){
            opS.push(ch); read();
            terminus();
            argS.push(binaryOp());
        }
    }

    private void terminus() {
        multiple();
        while(ch == '*' || ch == '/'){
            opS.push(ch); read();
            multiple();
            argS.push(binaryOp());
        }
    }

    private void multiple() {
        number();
        if(ch == '^'){
            opS.push(ch); read();
            multiple();
            argS.push(binaryOp());
        }

    }

    private void number() {
        if(ch == '('){
            expression(); read();
        } else if (Character.isAlphabetic(ch)){
            function();
        } else {
            real();
        }
    }

    private void function() {
        opS.push(identifier().charAt(0));
        expression(); read();
        argS.push(unoOp());
    }

    private void real() {
        StringBuilder sb = new StringBuilder();
        sb.append(integer());
        if (ch == '.') {
            sb.append(ch); read();
            sb.append(integer());
        }

        argS.push(Double.parseDouble(sb.toString()));
    }

    private String integer() {
        StringBuilder sb = new StringBuilder();
        if (!Character.isDigit(ch)) {
            errorA("Ожидается цифра", expression, pos - 1);
        }
        while (Character.isDigit(ch)) {
            sb.append(ch); read();
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

    //Semantic operations
    private double unoOp(){
        double x = argS.pop();
        char op = opS.pop();
        switch (op){
            case '+': x = x; break;
            case '-': x = -x; break;
            case 's': x = Math.sin(Math.toRadians(x)); break;
            case 'c': x = Math.cos(Math.toRadians(x)); break;
            case 't': x = Math.tan(Math.toRadians(x)); break;
            default:
                errorS(String.format("Неизвестная унарная операция %s", op));
        }
        return x;
    }

    private double binaryOp(){
        double x2 = argS.pop();
        double x1 = argS.pop();
        char op = opS.pop();
        double result = 0;
        switch (op){
            case '+': result = x1 + x2; break;
            case '-': result = x1 - x2; break;
            case '*': result = x1 * x2; break;
            case '/': result = x1 / x2; break;
            case '^': result = Math.pow(x1, x2); break;
            default:
                errorS(String.format("Неизвестная бинарная операция %s", op));
        }
        return result;
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

    //Ошибка при синтаксическом анализе
    public void errorA(String message, String expression, Integer errPos) {
        char[] chars = new char[errPos];
        Arrays.fill(chars, ' ');
        StringBuilder sb = new StringBuilder(message);
        sb.append('\n')
                .append(expression)
                .append('\n')
                .append(chars)
                .append('^')
                .append('\n');

        System.err.println(sb.toString());
        throw new RuntimeException();
    }

    //Ошибка при семантической интерпретации
    private void errorS(String message){
        System.err.println(message);
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



