import java.io.*;
import java.util.*;
import java.awt.*;

public class Names {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("names.txt"));
      Scanner console = new Scanner(System.in);
      giveIntro();
      System.out.print("name? ");
      String name = console.nextLine().toUpperCase();
      System.out.print("sex (M or F)? ");
      String sex = console.nextLine().toUpperCase();
      String searchCombo = name + " " + sex;//searchcombo is all upper case with space inbetween
      //System.out.println(searchcombo);
      
     //find combo in input file
      String line = find(input, searchCombo);         
          if (line.length() > 0) {
            System.out.print(line);
            //print(line);
            line = find(input, searchCombo);
            }
        }
   
    // introduces the program to the user
    public static void giveIntro() {
        System.out.println("This program allows you to search through the");
        System.out.println("data from the Social Security Administration");
        System.out.println("to see how popular a particular name has been");
        System.out.println("since 1880.");
        System.out.println();
    }
    
    // searches for and returns the combination of the given input that contains
    // the name and sex; returns a not found message if not found
    public static String find(Scanner input, String searchCombo) {
        while (input.hasNextLine()) {
            String line = input.nextLine().toUpperCase();
            //format token, and compare token based with search combo           
            String dataCombo = tokenFormat(line);
            if (dataCombo.startsWith(searchCombo)) {               
                return line;
            }
        }
        return "name/sex combination not found";
    }  
    
    public static String tokenFormat(String line) {
      Scanner data = new Scanner(line);
      String nameFromData = data.next();
      String sexFromData = data.next();
      String dataCombo = nameFromData + " " + sexFromData;
      return dataCombo;
    }
    
    //print line to leave single space between the int 
    //public static void print(String Line) {
    
    }
      //while (data.hasNextInt()) {
         //System.out.println(data.next() + " ");      
      //}
      //return " ";
//}            
