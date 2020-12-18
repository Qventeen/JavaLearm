package com.jr.level.level21.task2104;


import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        return last != null ? last.equals(solution.last) : solution.last == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }
    //    @Override
//    public boolean equals(Object n) {
//        if(n==this) return true;
//        if(n == null) return false;
//
//        if(this.getClass()n.getClass())){
//            return false;
//        }
//        Solution sol = (Solution) n;
//
//        return (first == sol.first || (first != null && first.equals(sol.first))
//            && (last == sol.last || last != null && last.equals(sol.last)));
//    }
//
//    public int hashCode() {
//        return 31 * first.hashCode() + last.hashCode();
//    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
