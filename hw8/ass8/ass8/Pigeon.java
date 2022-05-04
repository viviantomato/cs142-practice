/* Define a Critter class called Pigeon. 
The instances of the Pigeon class always hop when possible and otherwise randomly choose between turning left and turning right, with each choice being equally likely. Their
appearance changes over time. 
Each Pigeon initially displays as an asterisk ("*"). 
Then as each Pigeon chooses a move, it changes its appearance to match that move. If its most recent move was a hop, it displays as
"H". 
If its most recent move was to turn left, it displays as "L". 
And if its most recent move was to turn right, it displays as "R". 
Its color should be the default color for critters. */

import java.awt.*;
import java.util.*;

public class Pigeon extends Critter {
   private String display;
   private Random r;
 
   public Pigeon () {
      display = "*";
      r = new Random();
   }  
   
   public Action getMove(CritterInfo info) {
       
      if(info.getFront() == Neighbor.EMPTY) {
         display = "H";
         return Action.HOP;                
          
      } else {
          int turn = r.nextInt(2);
          if (turn == 0) {
              display = "L";
              return Action.LEFT; 
          } else {
              display = "R";   
              return Action.RIGHT; 
             
      }
   }
}
      public String toString() {
         return display;
 }
}