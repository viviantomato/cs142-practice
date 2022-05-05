import java.awt.*;

public class Giant extends Critter {
   private int move;
    
   public Giant() {
      move = 1;
      getColor();
   }

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
    public void countMoves(){
        if (move == 24){
            move = 1;
        } else {
            move++;
        }
    }
}