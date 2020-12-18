package com.jr.level.level13.task1313;

import java.awt.*;

/* 
Лисица — это такое животное
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
       abstract Color getColor();
    }

    public abstract static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }
}
