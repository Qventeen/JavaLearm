package com.jr.level.level20.task2007;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* 
Как сериализовать JR?
*/
public class Solution {
    public static class JR implements Serializable {
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) {

    }
}
