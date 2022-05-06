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
   
   //if polar bear is true, color set to white; if not, color set to blace.
   public Color getColor() {
      // refer to this polar from fields
      if (polar) {
         return Color.WHITE;
      } else {
         return Color.BLACK;
      }
   }
   
   //always infect if an enemy is in front, otherwise hop if possible, otherwise turn left.
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
   
   // alternate between a slash character (/) and a backslash character (\) starting with a slash
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
