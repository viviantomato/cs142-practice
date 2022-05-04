/* Define a Critter class called Dog. 
It should always infect if an enemy is in front of it. 
All other turns should have the following pattern: turn left five times and then hop once 
(e.g. your critter may turn left twice,then infect, then turn left three times, then hop). 
It should be colored pink and it should display how many left turns it has made since it last tried to hop 
(initially 0, then 1, then 2, ..., eventually becoming 5, then going back to 0, 1, 2, ...). */

import java.awt.*;

public class Dog extends Critter {
   private int count;
   
   public Action getMove(CritterInfo info) {
      count++;
      if(info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (count < 5) {         
          return Action.LEFT;
      } else {
          count = 0;
          return Action.HOP;      
      }
   }

   public Color getColor() {
      return Color.PINK;
   }
   
   public String toString() {
      return "" + count;
   }
}