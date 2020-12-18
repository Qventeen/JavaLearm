package level.level03.task0307;

/* 
Привет Starcraft!
*/

public class Solution {
    public static void main(String[] args) {
        Zerg[] zerg = new Zerg[10];
        for (int k = 0; k<10; k++){
            zerg[k] = new Zerg();
            zerg[k].name = "zerg" + k;
        }
        Protoss[] protoss = new Protoss[5];
        for (int k = 0; k<5; k++){
            protoss[k] = new Protoss();
            protoss[k].name = "protoss" + k;
        }
        Terran[] terran = new Terran[12];
        for (int k = 0; k < 12; k++){
            terran[k] = new Terran();
            terran[k].name = "terran" + k;
        }
/*
        Zerg z1 = new Zerg(); z1.name = "z1";
        Zerg z2 = new Zerg(); z2.name = "z2";
        Zerg z3 = new Zerg(); z3.name = "z3";
        Zerg z4 = new Zerg(); z4.name = "z4";
        Zerg z5 = new Zerg(); z5.name = "z5";
        Zerg z6 = new Zerg(); z6.name = "z6";
        Zerg z7 = new Zerg(); z7.name = "z7";
        Zerg z8 = new Zerg(); z8.name = "z8";
        Zerg z9 = new Zerg(); z9.name = "z9";
        Zerg z10 = new Zerg(); z10.name = "z10";
        
        Protoss p1 = new Protoss(); p1.name = "p1";
        Protoss p2 = new Protoss(); p2.name = "p2";
        Protoss p3 = new Protoss(); p3.name = "p3";
        Protoss p4 = new Protoss(); p4.name = "p4";
        Protoss p5 = new Protoss(); p5.name = "p5";
        
        Terran t1 = new Terran(); t1.name = "t1";
        Terran t2 = new Terran(); t2.name = "t2";
        Terran t3 = new Terran(); t3.name = "t3";
        Terran t4 = new Terran(); t4.name = "t4";
        Terran t5 = new Terran(); t5.name = "t5";
        Terran t6 = new Terran(); t6.name = "t6";
        Terran t7 = new Terran(); t7.name = "t7";
        Terran t8 = new Terran(); t8.name = "t8";
        Terran t9 = new Terran(); t9.name = "t9";
        Terran t10 = new Terran(); t10.name = "t10";
        Terran t11 = new Terran(); t11.name = "t11";
        Terran t12 = new Terran(); t12.name = "t12";
*/
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
