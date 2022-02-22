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
      System.out.println(name);//output1
      System.out.println(line);
      //convert String into int[], use counter for results
      
      //*int[] countResults = countResults(line);
    
      //*System.out.println(Arrays.toString(countAB)); 
   }  
   }
    public static int[] countResults(String line) {
       int[] countAResults = new int [4];//String needs ()
       //int[] countBResults = new int [4];
         for (int i = 0; i < 4; i++) { //loop 0-3 for new array
       
         for (int j = 0; j < 70 / 7; j++) { //loop 0-9 for index in line
            if (i == 0) {
                int index = j * 7;  
                char next = line.charAt(index); //read char from index position
                test (next); // test char for a, b, - and increase counter
            }
            
            else {

                int index = j * 7 + 2 * i - 1;
                int index2 = j * 7 + 2 * i;
                char next = line.charAt(index);
                char next = line.charAt(index2);
            }
            
         }
        }        

                 
          //char next = line.charAt(i);
          
       }
//           if (next.toLowerCase == 'a') {// ' ' single quote for char
//           else if (next.toLowerCase == 'b') 
//           else (next.toLowerCase == '-') 
             
          }
//          
//       }
//       return countAB;
    }
}
}
}