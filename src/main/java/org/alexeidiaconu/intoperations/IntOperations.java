package org.alexeidiaconu.intoperations;

public class IntOperations {

    public int biggestNumber (int a, int b) {
        if (a > b) {
            return a;
        }
        else {
            return b;
        }
    }

    public boolean isEven (int a) {
        if (a % 2 ==0)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
