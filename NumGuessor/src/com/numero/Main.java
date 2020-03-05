package com.numero;
// I AM FULLY AWARE THAT MY CODE IS SPAGHETTI AND IT COULD BE MADE EASIER AND MORE EFFICIENT BUT I AM NOT THE BEST PROGRAMMER UNDER THE SUN.
// CODE WRITTEN BY GITHUB USER ITSJERAS. (M16)
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        boolean discovered = false;
        variables.counter = 0;
        // Generate guessed number:
        variables.guessedNum = genNum(0,99999);
        variables.smallerNumBorder = 0;
        variables.largerNumBorder = 99999;
        variables.startPoint = true;
        variables.startPointFound = false;
        while (!discovered){
            // CODE:
            if (variables.startPointFound) {
                variables.counter = variables.counter + 1;
                System.out.println("ATTEMPT: " + variables.counter);
            }
            //  Generate "border points"
            borderPoints();
            variables.startPointFound = true;
            System.out.println("Small num border: " + variables.smallerNumBorder);
            System.out.println("Large num border: " + variables.largerNumBorder);
            System.out.println("Guessed num: " + variables.guessedNum);
            System.out.println("+----------------------------------------------------+");
            // Breaking the loop:
            variables.GNum = variables.largerNumBorder - 1;
            if (compare(variables.GNum,variables.guessedNum) == "Equal"){
                System.out.println("GUESSING FINISHED AT ATTEMPT " + variables.counter);
                discovered = true;
            }
        }
    }

    //                          COMPARE NUMBERS
    public static String compare (int firstNum, int secondNum){
        String result;
        if (firstNum < secondNum){
            result = "Smaller";
        } else if (firstNum > secondNum){
            result = "Larger";
        } else if (firstNum == secondNum) {
            result = "Equal";
        } else {
            result = "ERROR";
        }
        return result;
    }
    //                          GENERATE BORDER POINTS:
    public static void borderPoints () {
        if (variables.startPointFound = false) {
                variables.smallInt = genNum(variables.smallerNumBorder, variables.guessedNum);
                variables.largeInt = genNum(variables.guessedNum, variables.largerNumBorder);
        }

        if (variables.smallerNumBorder < variables.guessedNum && variables.largerNumBorder > variables.guessedNum){

            variables.smallInt = genNum(variables.smallerNumBorder, variables.largerNumBorder);
            variables.largeInt = genNum(variables.smallerNumBorder, variables.largerNumBorder);

        } else {
            variables.smallerNumBorder = variables.smallInt +1;
            variables.largerNumBorder = variables.largeInt -1;
        }
        if (variables.smallerNumBorder < variables.smallInt && variables.smallInt < variables.guessedNum) {
            variables.smallerNumBorder = variables.smallInt;
        }

        if (variables.largerNumBorder > variables.largeInt && variables.largeInt > variables.guessedNum) {
            variables.largerNumBorder = variables.largeInt;
        }
    }

    //                          GENERATE RANDOM NUMBER THAT IS BETWEEN MAXIMAL AND MINIMAL VALUE
    public static int genNum (int min, int max){
        int result = ThreadLocalRandom.current().nextInt(min, max + 1);
        return result;
    }

    //                          PUBLIC VARIABLES
    public static class variables {
        public static int largerNumBorder;
        public static int smallerNumBorder;
        public static int smallInt;
        public static int largeInt;
        public static int guessedNum;
        public static int counter;
        public static int GNum;
        public static boolean startPoint;
        public static boolean startPointFound;
    }
}
