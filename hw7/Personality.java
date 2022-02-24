import java.util.*;
import java.io.*;
//read name, read original result AB; convert to AB counts two arrays
//convert to percentage of B; map to personality type;
//add intro; swap constant for four;
//check coding style

public class Personality {   
    //main method reads from original data, capturing name and line
    public static void main(String[] args) throws FileNotFoundException {            
        //print program intro
        System.out.print("This program processes a file of answers to the\nKeirsey Temperament Sorter. It converts the \nvarious A and B answers for each person into \na sequence of B-percentages and then into a \nfour-letter personality type.");
        //read from input
        System.out.print("input file name? ");
        Scanner console = new Scanner(System.in);
        String inputFile = console.next();
        
        //read from output
        System.out.print("output file name? ");
        
        Scanner input = new Scanner (new File (inputFile));
        while (input.hasNextLine()) {
            String name = input.nextLine();
            String line = input.nextLine();
            System.out.print(name + ": ");
            int[] countBPercent = bPecent(line);
            System.out.print(Arrays.toString(countBPercent));
            System.out.print(" = " );
            String[] type = typeTest (countBPercent);
            for (int k = 0; k < type.length; k++) {
                System.out.print(type[k]);
            }
            System.out.println();
            
            
        }
    }
    
    //this method reads from line and pinpoint the index of the character to test in four catagories, return array of B percentage
    public static int[] bPecent(String line) {
        int[] countANumber = new int [4];
        int[] countBNumber = new int [4];
        int[] countBPercent = new int [4];
        for (int i = 0; i < 4; i++) {  // loop 0-3 for new array
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
    
    public static String[] typeTest (int[] countBPercent) {
        String[] type = new String [4];
        
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
}
