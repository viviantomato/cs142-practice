import java.util.*;
import java.io.*;
//read name, read original result AB; convert to AB counts two arrays
//convert to percentage of B; map to personality type;
//add intro; swap constant for four;
//check coding style

public class Personality {
   public static void main(String[] args) throws FileNotFoundException {
   //String 70 chars - turn into two array, for line based file
   Scanner input = new Scanner (new File ("personality.txt"));
   while (input.hasNextLine()) {
      String name = input.nextLine();
      String line = input.nextLine();
      System.out.println(name);
      System.out.println(line);
      //convert String into int[]
      //*int[] countAB = computeCountAB(line);
      //use counter or cumulative sum to test condition; 
      //*System.out.println(Arrays.toString(countAB)); 
   }  
   }
//    public static computeCountAB(String line ) {
//       int[] countAB = new int [line.length()];//String needs ()
//       //String travasal
//       for (int i = 0; i < line.length(); i++) {
//          //do sth with line.charAt(i), all initial to zero in array
//          char next = linecharAt(i);
//          //if (line.charAT(i) is a 1) { // ' ' single quote for char
//             //scores[i] = number;
//          }
//          
//       }
//       return countAB;
//    }
}