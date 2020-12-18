package com.jr.level.level33.sandbox.evalutor3404;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    private static List<String[]> tests = new ArrayList<>();

    public static void main(String[] args) {
        tests.add(new String[]{"tan(45)", "1 1\n"});
        tests.add(new String[]{"tan(-45)", "-1 2\n"});
        tests.add(new String[]{"0.305", "0.3 0\n"});
        tests.add(new String[]{"0.3051", "0.31 0\n"});
        tests.add(new String[]{"(0.3051)", "0.31 0\n"});
        tests.add(new String[]{"1+(1+(1+1)*(1+1))*(1+1)+1", "12 8\n"});
        tests.add(new String[]{"tan(44+sin(89-cos(180)^2))", "1 6\n"});
        tests.add(new String[]{"-2+(-2+(-2)-2*(2+2))", "-14 8\n"});
        tests.add(new String[]{"sin(80+(2+(1+1))*(1+1)+2)", "1 7\n"});
        tests.add(new String[]{"1+4/2/2+2^2+2*2-2^(2-1+1)", "6 11\n"});
        tests.add(new String[]{"10-2^(2-1+1)", "6 4\n"});
        tests.add(new String[]{"2^10+2^(5+5)", "2048 4\n"});
        tests.add(new String[]{"1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", "72.96 8\n"});
        tests.add(new String[]{"0.000025+0.000012", "0 1\n"});
        tests.add(new String[]{"-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)", "-3 16\n"});
        tests.add(new String[]{"cos(3 + 19*3)", "0.5 3\n"});
        tests.add(new String[]{"2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)", "8302231.36 14\n"});
        tests.add(new String[]{"(-1 + (-2))", "-3 3\n"});
        tests.add(new String[]{"-sin(2*(-5+1.5*4)+28)", "-0.5 7\n"});
        tests.add(new String[]{"sin(100)-sin(100)", "0 3\n"});
        tests.add(new String[]{"-(-22+22*2)", "-22 4\n"});
        tests.add(new String[]{"-2^(-2)", "-0.25 3\n"});
        tests.add(new String[]{"-(-2^(-2))+2+(-(-2^(-2)))", "2.5 10\n"});
        tests.add(new String[]{"(-2)*(-2)", "4 3\n"});
        tests.add(new String[]{"(-2)/(-2)", "1 3\n"});
        tests.add(new String[]{"sin(-30)", "-0.5 2\n"});
        tests.add(new String[]{"cos(-30)", "0.87 2\n"});
        tests.add(new String[]{"tan(-30)", "-0.58 2\n"});
        tests.add(new String[]{"2+8*(9/4-1.5)^(1+1)", "6.5 6\n"});
        tests.add(new String[]{"0.005", "0.01 0\n"});
        tests.add(new String[]{"0.0049", "0 0\n"});
        tests.add(new String[]{"0+0.304", "0.3 1\n"});
        tests.add(new String[]{"sin(45) - cos(45)", "-0 3\n"});
        tests.add(new String[]{"0/(-3)", "-0 2\n"});

        for (String[] test : tests) {
            String expr = test[0];
            String expected = test[1];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(baos);
            PrintStream oldOut = System.out;
            System.setOut(out);
            new StackMethod().recurse(expr,0);
            //new RecurseMethod().recurse(expr,0);
            //new Solution().recurse(expr, 0);
            System.setOut(oldOut);
            String actual = new String(baos.toByteArray(), StandardCharsets.UTF_8);
            actual = actual.trim(); expected = expected.trim();
            actual = actual.replaceAll(",", ".");
            if (!expected.equals(actual)) {
                System.err.println("Test failed: expr = " + expr + "; expected = " + expected + "; actual = " + actual);
            }
        }
    }
}
