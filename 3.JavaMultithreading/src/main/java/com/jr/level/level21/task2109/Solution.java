package com.jr.level.level21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
        @Override
        public int hashCode(){
            return 31 * i + j;
        }
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof A)) return false;
            A a = (A) o;
            return this.i == a.i && this.j == a.j;
        }
        @Override
        public A clone() throws CloneNotSupportedException{
            return new A(i,j);
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public int hashCode(){
            int result = super.hashCode();
            return 31 * result + (name != null? name.hashCode():0);
        }
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof B)) return false;
            B b = (B) o;
            if(!super.equals(b)) return false;
            return name != null? name.equals(b.name): b.name == null;
        }
        @Override
        public B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public int hashCode(){
            return super.hashCode() ^ 7;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof C)) return false;
            C c = (C) o;
            return super.equals(c);
        }

        @Override
        public C clone(){
            return new C(getI(),getJ(),getName());
        }
    }



    public static void main(String[] args) {

    }
}
