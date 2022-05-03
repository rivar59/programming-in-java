package agh.ii.prinjava.lab01.lst01_02;

import java.math.BigDecimal;
import java.util.List;

/**
 * Inheritance demo
 */
public class Main {
    public static void main(String[] args) {
        RichDad richDad = new RichDad("R", "Doe", BigDecimal.valueOf(1), List.of("School Mate"));
        richDad.increaseWealth();
        //...

        RichDadsKid richDadsKid =
                new RichDadsKid("Mike", richDad.surname, richDad.getFortune(), richDad.getContacts());
        //...
        richDadsKid.setUpSuccessfulCompany();
        richDadsKid.increaseWealth();

            try{
                throw new NumberFormatException();
            }catch (RuntimeException a){
                System.out.println("C");
            }catch (Exception a){
                System.out.println("D");
            }finally {
                System.out.println("E");
            }
            System.out.println("F");

    }
}
