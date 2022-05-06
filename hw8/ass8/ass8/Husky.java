import java.awt.*;

public class Husky extends Critter {
   private int move;
   
   public Husky() {
      move = 1;
      getColor();
   }
   
   //always infect if an enemy is in front, otherwise hop if front is empty, otherwise turn right.
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
   
   //every three moves, rotate between displays: "MonkeyEight", "GoodBobo", "Turtle", "CycleBobo".
   public String toString() {
      if(move <= 10) {
         return "MonkeyEight";
      } else if (move <= 20) {
         return "GoodBobo";
      } else if (move <= 30) {
         return "Turtle";
      } else {
         return "CycleBobo";
      }
   }
   
   public void countMoves(){
      if (move == 40){
         move = 1;
      } else {
         move++;
      }
   }
}