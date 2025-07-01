package org.alexeidiaconu;
import org.alexeidiaconu.intoperations.IntOperations;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        IntOperations calc = new IntOperations();
        int a = (int)(Math.random() *10);
        int b = (int)(Math.random() *10);

        System.out.println("Number a = " + a);
        System.out.println("Number b = " + b);

        System.out.println("The Biggest number is = " + calc.biggestNumber(a,b));

        System.out.println("Number a " + (calc.isEven(a)? "is Even" : "is Not Even"));
        System.out.println("Number b " + (calc.isEven(b)? "is Even" : "is Not Even"));

        }
}
