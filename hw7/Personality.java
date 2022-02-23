import java.util.*;
import java.io.*;
//read name, read original result AB; convert to AB counts two arrays
//convert to percentage of B; map to personality type;
//add intro; swap constant for four;
//check coding style

public class Personality {
    //main method reads from original data, capturing name and line
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner (new File ("personality.txt"));
        while (input.hasNextLine()) {
            String name = input.nextLine();
            String line = input.nextLine();
            System.out.println(name + ": ");  
            //System.out.println(line);
            //int[] countAResults = bPecent(line);
            int[] countBPercent = bPecent(line);
            System.out.println(Arrays.toString(countBPercent));
            //String typeTest = typeTest (countBPercent, i);
           
            //System.out.println(Arrays.toString(countBResults));
        }
    }
    
    //this method reads from line and pinpoint the index of the character to test in four catagories
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
            String s = typeTest(countBPercent, i); // test type for four results
            System.out.println(s);
        }
        return countBPercent; // return array of percentage directly
    }
    
    //this method tests the character and calculate three counter accordingly
    public static void testCount(char next, int i, int[] countANumber, int[] countBNumber) {
        if (next == 'a' || next == 'A') {   // ' ' single quote for char
            countANumber[i] ++;
        } else if (next == 'b' || next == 'B') {
            countBNumber[i] ++;
        }
    }       
    
    public static String typeTest (int[] countBPercent, int i) {
 
         if (i == 0 && countBPercent[i] > 50) {
               return "I"; 
         } else if (i == 0 && countBPercent[i] < 50) {
               return "E"; 
         } else if (i == 1 && countBPercent[i] > 50) {
               return "N"; 
         } else if (i == 1 && countBPercent[i] < 50) {
               return "S";  
         } else if (i == 2 && countBPercent[i] > 50) {
               return "F"; 
         } else if (i == 2 && countBPercent[i] < 50) {
               return "T";  
         } else if (i == 3 && countBPercent[i] > 50) {
               return "P"; 
         } else if (i == 3 && countBPercent[i] < 50) {
               return "J";
         } else {
            return "X";
         }   
    }
}
