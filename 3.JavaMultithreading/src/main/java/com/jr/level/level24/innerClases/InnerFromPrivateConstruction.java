package com.jr.level.level24.innerClases;

public class InnerFromPrivateConstruction {
    private InnerFromPrivateConstruction(){}
    public class InnerFromPrivate {
        public void printString(){
            System.out.println("Hello World!");
        }
    }
    public static InnerFromPrivateConstruction getInnerFromPrivate(){
        return new InnerFromPrivateConstruction();
    }
}
class TestConcept{
    public static void main(String[] args){
        InnerFromPrivateConstruction ifpc = InnerFromPrivateConstruction.getInnerFromPrivate();
        InnerFromPrivateConstruction.InnerFromPrivate innerFromPrivate = ifpc.new InnerFromPrivate();
        innerFromPrivate.printString();
    }
}
