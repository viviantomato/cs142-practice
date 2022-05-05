import java.awt.*;

public class Husky extends Critter {
   private int move;
   
   public Husky() {
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
      return Color.PINK;
   }
   
   public String toString() {
      if(move <= 3) {
         return "MonkeyEight";
      } else if (move <= 6) {
         return "GoodBobo";
      } else if (move <= 9) {
         return "Turtle";
      } else {
         return "CycleBobo";
      }
   }
   
   public void countMoves(){
      if (move == 12){
         move = 1;
      } else {
         move++;
      }
   }
}