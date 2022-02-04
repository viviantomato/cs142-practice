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
   
   //format data as datacombo to match searchcombo
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
      //draw outer frame
      g.drawLine(0, 25, 14 * 70, 25);
      //draw 14 lines for each section
      g.drawLine(0, 550 - 25, 14 * 70, 550 - 25);
      for (int i = 0; i < 14; i++) {
         g.drawLine(0 + 70 * i, 0, 0 + 70 * i, 550);
      }
      //draw strings for each decade
      for (int i = 0; i < 14; i++) {
         g.drawString("" + (1880 + i * 10), 0 + i * 70, 550);
      }
      //draw strings for name and sex and rank in red
      g.setColor(Color.RED);
      int rank1 = 0;
      int rank2 = 0;
      int yCoord1 = 0;
      int yCoord2 = 0;
      Scanner data = new Scanner(line);
      String throwAway = data.next();
      String throwAway2 = data.next();
      //print the first string, get original (x1,y1)
      rank1 = data.nextInt();
      yCoord1 = convertToYCoord(rank1);
      g.drawString(searchCombo + " " + rank1, 0,  yCoord1);
      //print redline and string from the second, store the previous y coordinate 
      for (int i = 1; i < 14; i++) {
         rank2 = data.nextInt();
         yCoord2 = convertToYCoord(rank2);         
         g.drawString(searchCombo + " " + rank2, 0 + 70 * i,  yCoord2);
         g.drawLine(70 *(i - 1), yCoord1, 70 * i,  yCoord2);
         yCoord1 = yCoord2;
      }
   }
   public static int convertToYCoord (int rank) {
      int yCoord = 0;
      if (rank  % 2 == 0 && rank != 0) {
         yCoord = (rank - 2) / 2 + 25;
      } else if (rank % 2 == 1) {
         yCoord = (rank - 1) / 2 + 25;
      } else {
         yCoord = 525;
      }
      return yCoord;
   }
}
