import java.awt.*;
import java.util.*;


public class Lion extends Critter {
   private Random r;
   private int move;
   private int count;
   
   
      
   public Lion() {
      r = new Random();
      
   }
   
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
    
    public Color getColor() {
       int move = r.nextInt(3);
       
       if (move == 0) {
         return Color.RED;
       } else if (move == 1) {
         return Color.GREEN;
       } else {
         return Color.BLUE;
       }
    }   
    
    public String toString() {
        return "L";
    }

}