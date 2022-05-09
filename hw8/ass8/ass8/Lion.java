import java.awt.*;
import java.util.*;

public class Lion extends Critter {
   private Random r;
   private int count;
   private Color lionColor;  
   
   public Lion() {
      r = new Random();
      getColor();
   }
   
   //always infect if an enemy is in front, otherwise if a wall is in front or to the right, then turn left, otherwise if a fellow Lion is in front, then turn right, otherwise hop.
   public Action getMove(CritterInfo info) {
      count++;     
      if(info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
         return Action.LEFT;
      } else if (info.getFront() == Neighbor.SAME) {
         return Action.RIGHT;
      } else {
         return Action.HOP;
      }
   }
   
   //for every three moves, randomly picks one of three colors:RED, GREEN, BLUE
   public Color getColor() {      
      if (count % 3 == 0) {
         int move = r.nextInt(3);
         if (move == 0) {
            lionColor = Color.RED;
         } else if (move == 1) {
            lionColor = Color.GREEN;
         } else {
            lionColor = Color.BLUE;
         }
      }
      return lionColor;
   }
   
   public String toString() {
      return "L";
   }
}