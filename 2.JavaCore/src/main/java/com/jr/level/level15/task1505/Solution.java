package com.jr.level.level15.task1505;

import java.util.ArrayList;
import java.util.List;

/* 
ООП - исправь ошибки в наследовании
*/

public class Solution {
    public static interface Alive {
        Object containsBones();
    }

    public static class BodyPart implements Alive {
        private String name;

        public BodyPart(String name) {
            this.name = name;
        }
        @Override
        public Object containsBones() {
            return "Yes";
        }
        @Override
        public String toString() {
            String str;
            if("Yes".equals(containsBones()))
                str = name + " содержит кости";
            else
                str = name + " не содержит кости";
            return str;
        }
    }

    public static class Finger extends BodyPart {
        private boolean isArtificial;

        public Finger(String name, boolean isArtificial) {
            super(name);
            this.isArtificial = isArtificial;
        }
        @Override
        public Object containsBones() {
            String str;
            if("Yes".equals(super.containsBones()) && !isArtificial)
                str = "Yes";
            else
                str = "No";
            return str;
        }
    }

    public static void main(String[] args) {
        printlnFingers();
        printlnBodyParts();
        printlnAlives();
    }

    private static void printlnAlives() {
        System.out.println(new BodyPart("Рука").containsBones());
    }

    private static void printlnBodyParts() {
        List<BodyPart> bodyParts = new ArrayList<BodyPart>(5);
        bodyParts.add(new BodyPart("Рука"));
        bodyParts.add(new BodyPart("Нога"));
        bodyParts.add(new BodyPart("Голова"));
        bodyParts.add(new BodyPart("Тело"));
        System.out.println(bodyParts.toString());
    }

    private static void printlnFingers() {
        List<Finger> fingers = new ArrayList<Finger>(5);
        fingers.add(new Finger("Большой", true));
        fingers.add(new Finger("Указательный", true));
        fingers.add(new Finger("Средний", true));
        fingers.add(new Finger("Безымянный", false));
        fingers.add(new Finger("Мизинец", true));
        System.out.println(fingers.toString());
    }
}

