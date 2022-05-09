import java.awt.*;

public class Giant extends Critter {
   private int move;
   
   public Giant() {
      move = 1;
      getColor();
   }
   
   //always infect if an enemy is in front, otherwise hop if possible, otherwise turn right.
   public Action getMove(CritterInfo info) {      
      if(info.getFront() == Neighbor.OTHER) {
         countMoves();
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         countMoves();
         return Action.HOP;
      } else {
         countMoves();
         return Action.RIGHT;
      }
   }
   
   public Color getColor() {
      return Color.GRAY;
   }
   
   //for every 6 moves, display alternate between "fee", "fie", "foe", "fum".
   public String toString() {
      if(move <= 6) {
         return "fee";
      } else if (move <= 12) {
         return "fie";
      } else if (move <= 18) {
         return "foe";
      } else {
         return "fum";
      }
   }
   
   //reset move count every 24 counts
   public void countMoves(){
      if (move == 24){
         move = 1;
      } else {
         move++;
      }
   }
}