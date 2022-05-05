import java.awt.*;

public class Bear extends Critter {
   private String display;
   private int count;
   private boolean polar;
   
   public Bear(boolean polar) {
      display = "/";
      count = 0;
      this.polar = polar;  //parameter name same as field name, use this to refer to field, shadowing.
   }
   
   public Color getColor() {
      // refer to this polar from fields
      if (polar) {
         return Color.WHITE;
      } else {
         return Color.BLACK;
      }
   }
   
   
   public Action getMove(CritterInfo info) {
      count++;
      if(info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getBack()==Neighbor.OTHER) {
         return Action.HOP;
      } else {
         return Action.LEFT;
      }
   }
   
   public String toString() {
      if (count % 2 == 0) {
         display = "/";
         return display;
      } else {
         display = "\\";
         return display;
      }
   }
}
