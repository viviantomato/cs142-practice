/*
Define a Critter class called Cat. 
It should always infect if an enemy is in front of it. 
Otherwise it should hop if there is a critter of another species either to its left, its right, or behind it. 
Otherwise it should turn right. 
Its color should alternate between green and white on successive moves and it should be displayed as a "C".
*/

import java.awt.*;

public class Cat extends Critter {
    private int count;
    
    public Action getMove(CritterInfo info) {
        count++;       
        if (info.frontThreat()) {
        //if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getBack() == Neighbor.OTHER || info.getLeft() == Neighbor.OTHER || info.getRight() == Neighbor.OTHER) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        } 
     }

    public Color getColor() {
       if (count % 2 == 0) {
         return Color.GREEN;
       } else {
         return Color.WHITE;
       }
    }


    public String toString() {
        return "C";
    } 
}
