import java.io.*;
import java.util.*;
import java.awt.*;

public class Names {
   public static final int numOfDecades   = 14;
   public static final int startingYear   = 1880;
   public static final int widthPerDecade = 70;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("names.txt"));
      Scanner console = new Scanner(System.in);
      giveIntro();
      //form searchCombo with name+space+sex (uppercase), read from user output.
      System.out.print("name? ");
      String name1 = console.nextLine();
      String name = (name1.substring(0, 1).toUpperCase() + name1.substring(1));
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
      System.out.println("since " + startingYear + " .");
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
      DrawingPanel panel = new DrawingPanel(widthPerDecade*14, 550);
      panel.setBackground(Color.WHITE);
      Graphics g = panel.getGraphics();
      //draw outer frame
      g.drawLine(0, 25, numOfDecades * widthPerDecade, 25);
      //draw line for each section
      g.drawLine(0, 550 - 25, numOfDecades * widthPerDecade, 550 - 25);
      for (int i = 0; i < numOfDecades; i++) {
         g.drawLine(0 + widthPerDecade * i, 0, 0 + widthPerDecade * i, 550);
      }
      //draw strings for each decade
      for (int i = 0; i < numOfDecades; i++) {
         g.drawString("" + (startingYear + i * 10), 0 + i * widthPerDecade, 550);
      }
      //draw strings for name and sex and rank in red, read from line
      g.setColor(Color.RED);
      int rank1 = 0;
      int rank2 = 0;
      int yCoord1 = 0;
      int yCoord2 = 0;
      Scanner data = new Scanner(line);
      String throwAway = data.next();
      String throwAway2 = data.next();
      //print the first string, get original (x1,y1), draw string original
      rank1 = data.nextInt();
      yCoord1 = convertToYCoord(rank1);
      g.drawString(searchCombo + " " + rank1, 0,  yCoord1);
      //print redline and string from the second, store the previous y coordinate
      for (int i = 1; i < numOfDecades; i++) {
         rank2 = data.nextInt();
         yCoord2 = convertToYCoord(rank2);
         g.drawString(searchCombo + " " + rank2, 0 + widthPerDecade * i,  yCoord2);
         g.drawLine(widthPerDecade *(i - 1), yCoord1, widthPerDecade * i,  yCoord2);
         yCoord1 = yCoord2;
      }
   }
   //convert rank output to Y coordinate 
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
