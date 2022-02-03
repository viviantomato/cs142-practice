import java.io.*;
import java.util.*;
import java.awt.*;

public class Names {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("names.txt"));
      Scanner console = new Scanner(System.in);
      giveIntro();
      //form searchCombo with name+space+sex (uppercase)
      System.out.print("name? ");
      String name1 = console.nextLine();
      String s1 = name1.substring(0, 1).toUpperCase();
      String name = (s1 + name1.substring(1));
      System.out.print("sex (M or F)? ");
      String sex = console.nextLine().toUpperCase();
      String searchCombo = name + " " + sex;      
      //find searchCombo in input file. If there is a matching output, construct a drawing panel.
      //If there is no matching output, print not found message.
      String line = find(input, searchCombo);
      if (line.length() > 0) {
         drawGraph (line,searchCombo);
      } else {
         System.out.println("name/sex combination not found");
      }
   }
   
   // introduces the purpose of the program to the user
   public static void giveIntro() {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since 1880.");
      System.out.println();
   }
   
   // searches for formatted data that starts with searchCombo
   // return line if found; return empty if not found
   public static String find(Scanner input, String searchCombo) {
      while (input.hasNextLine()) {
         String line = input.nextLine();
         //format token, and compare token based with search combo
         String dataCombo = tokenFormat(line);
         if (dataCombo.startsWith(searchCombo)) {
            return line;
         }
      }
      return "";
   }
   
   //format data as datacombo
   public static String tokenFormat(String line) {
      Scanner data = new Scanner(line);
      String nameFromData = data.next();
      String sexFromData = data.next();
      String dataCombo = nameFromData + " " + sexFromData;
      return dataCombo;
   }
   
   //construct a DrawingPanel, passing line as parameter
   public static void drawGraph (String line, String searchCombo) {
      DrawingPanel panel = new DrawingPanel(70*14, 550);
      panel.setBackground(Color.WHITE);
      Graphics g = panel.getGraphics();
      g.drawLine(0, 25, 14 * 70, 25);
      g.drawLine(0, 550 - 25, 14 * 70, 550 - 25);
      for (int i = 0; i < 14; i++) {
         g.drawLine(0 + 70 * i, 0, 0 + 70 * i, 550);
      }
      for (int i = 0; i < 14; i++) {
         g.drawString("" + (1880 + i * 10), 0 + i * 70, 550);
      }      
      g.setColor(Color.RED);
      int rank1 = 0;
      int rank2 = 0;
      int yCoord = 0;
      Scanner data = new Scanner(line);
      while (data.hasNext()) {
         String throwAway = data.next();
         String throwAway2 = data.next();          
         for (int i = 0; i < 14; i++) {                                                                                                                                                                                                                                                                                                                                                                                                               
            rank1 = data.nextInt();
            if (rank1 % 2 == 0 && rank1 != 0) {
            yCoord = (rank1 - 2) / 2 + 25;
            } else if (rank1 % 2 == 1) {
            yCoord = (rank1 - 1) / 2 + 25;  
            } else {
            yCoord = 525;
            }
            
            g.drawString(searchCombo + " " + rank1, 0 + 70 * i,  yCoord); 
            //rank2 = data.nextInt();
            //g.drawLine(0 + 70 * i, Math.round (rank1 / 2) + 25, 0 + 70 *(i + 1), Math.round (rank2 / 2) + 25);         
         }
      }
   }
}
