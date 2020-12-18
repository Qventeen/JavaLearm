package com.jr.level.level21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        clone = solution.clone();
        System.out.println(solution);
        System.out.println(clone);

        System.out.println(solution.users);
        System.out.println(clone.users);
    }

    @Override
    public Solution clone(){
        Solution sol = new Solution();
        for(Map.Entry<String, User> pair : users.entrySet()){
            sol.users.put(
                    pair.getKey(),
                    pair.getValue() != null? pair.getValue().clone(): null
            );
        }
        return sol;
    }



    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof User)) return false;

            User user = (User) o;
            if(age != user.age) return false;
            return (name != null? name.equals(user.name): user.name == null);
        }

        @Override
        public int hashCode(){
            int result = age;
            return 31 * result + (name != null? name.hashCode(): 0);
        }

        @Override
        public User clone(){
            return new User(age, name);
        }
    }
}
