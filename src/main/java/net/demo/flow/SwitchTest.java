package net.demo.flow;

public class SwitchTest {
    public static void main(String[] args) {
       /*int letter = 1;
       switch (letter) {
           case 1:
               System.out.println("a");
           case 2:
               System.out.println("b");
       }*/

        LOOP: for (char i=0;i<5;i++){
            switch(i++){
                case 0: System.out.println("A"); break;
                case 1: System.out.println("B"); break LOOP;
                case 2: System.out.println("C"); break;
                case 3: System.out.println("D"); break;
                case 4: System.out.println("E");
                case 'E' : System.out.println("F");
            }
        }
    }
}
