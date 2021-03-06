import java.util.*;
import java.io.*;
//read name, read original result AB; convert to AB counts two arrays
//convert to percentage of B; map to personality type;
//add intro; swap constant for four;
//check coding style

public class Personality {
    public static final int arraySize = 4;
    //main method reads from original data, capturing name and line
    public static void main(String[] args) throws FileNotFoundException {
        //print program intro
        System.out.print("This program processes a file of answers to the\nKeirsey Temperament Sorter.  It converts the \nvarious A and B answers for each person into \na sequence of B-percentages and then into a \nfour-letter personality type.\n");
        System.out.println();
        //read from input
        System.out.print("input file name? ");
        Scanner console = new Scanner(System.in);
        String inputFile = console.next();
        Scanner input = new Scanner (new File (inputFile));
        //create output
        System.out.print("output file name? ");
        String outputFile = console.next();
        PrintStream output = new PrintStream(new File (outputFile));
        while (input.hasNextLine()) {
            String name = input.nextLine();
            String line = input.nextLine();
            output.print(name + ": ");
            int[] countBPercent = bPecent(line);
            output.print(Arrays.toString(countBPercent));
            output.print(" = " );
            String[] type = typeTest (countBPercent);
            print(output, type);
        }
    }
    
    //this method reads from line and pinpoint the index of the character to test in four catagories, return array of B percentage
    public static int[] bPecent(String line) {
        int[] countANumber = new int [arraySize];
        int[] countBNumber = new int [arraySize];
        int[] countBPercent = new int [arraySize];
        for (int i = 0; i < arraySize; i++) {  // loop 0-3 for new array
            for (int j = 0; j < 70 / 7; j++) { // loop 0-9 for index in line
                if (i == 0) {
                    char next = line.charAt(j * 7); // read char from calculated index position
                    testCount (next, i, countANumber, countBNumber); // test char for a, b, - and increase counter
                } else {
                    char next = line.charAt(j * 7 + 2 * i - 1);  //1st
                    testCount (next, i, countANumber, countBNumber);
                    char next2 = line.charAt(j * 7 + 2 * i);  //2nd
                    testCount (next2, i, countANumber, countBNumber);
                }
            }
            countBPercent[i] = (int) Math.round((double) countBNumber[i] / (countANumber[i] + countBNumber[i]) * 100);
        }
        return countBPercent;
    }
    
    //this method tests the character and calculate three counter accordingly
    public static void testCount(char next, int i, int[] countANumber, int[] countBNumber) {
        if (next == 'a' || next == 'A') {   // ' ' single quote for char
            countANumber[i] ++;
        } else if (next == 'b' || next == 'B') {
            countBNumber[i] ++;
        }
    }
    
    //this method generates letter stands for type based on countBPercent
    public static String[] typeTest (int[] countBPercent) {
        String[] type = new String [arraySize];
        if (countBPercent[0] > 50) {
            type[0] = "I";
        } else if (countBPercent[0] < 50) {
            type[0] = "E";
        } else {
            type[0] = "X";
        }
        if (countBPercent[1] > 50) {
            type[1] = "N";
        } else if (countBPercent[1] < 50) {
            type[1] = "S";
        } else {
            type[1] = "X";
        }
        if (countBPercent[2] > 50) {
            type[2] = "F";
        } else if (countBPercent[2] < 50) {
            type[2] = "T";
        } else {
            type[2] = "X";
        }
        if (countBPercent[3] > 50) {
            type[3] = "P";
        } else if (countBPercent[3] < 50) {
            type[3] = "J";
        } else {
            type[3] = "X";
        }
        return type;
    }
    
    //print each letter from String[] type  
    public static void print(PrintStream output, String[] type) {
        for (int k = 0; k < arraySize; k++) {
            output.print(type[k]);
        }
        output.println();
    }
}
