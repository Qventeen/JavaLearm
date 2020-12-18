package com.jr.level.level29.sandbox29;

public class AutoboxingTest {
    public static void main(String[] args) {
        boolean f = true;
        byte b = 100;
        char c = 100;
        short s = 100;
        int i = 100;
        long l = 100L;
        float fl = 100.0F;
        double d = 100.0;
        Boolean F = f;
        Byte B = b;
        Character C = c;
        Short S = s;
        Integer I = i;
        Long L = l;
        Float Fl = fl;
        Double D = d;

        //only to own type
        F = f;
        B = b;
        S = s;

        D = 200.0;
        d = D;
        d = I;
        d = D;
        d = S;
        d = C;

        //test in methods
        testW(d);
        //test on primitives (standard result)
        testD(d); testD(fl);testD(i);testD(s);testD(c);

        //test on wrappers -> result all wrappers autoboxing to primitives
        testD(D);testD(Fl); testD(L);testD(I);testD(S);testD(B);


    }
    static void testW(Double i){}
    static void testB(byte b){}
    static void testC(char c){}
    static void testS(short s){}
    static void testI(int i){}
    static void testL(long l){}
    static void testF(float f){}
    static void testD(double d){}
}
