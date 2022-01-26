import java.awt.*;

//produce image of CafeWall.
public class CafeWall {
   public static final int mortar = 1;
   public static void main(String[] args) {
      
      DrawingPanel panel = new DrawingPanel(650,400);
      panel.setBackground(Color.GRAY);
      Graphics g = panel.getGraphics();
      
      //structure of the image.
      drawRow(g, 0, 0, 20, 4);
      drawRow(g, 50, 70, 30, 5);
      drawGrid(g, 10, 150, 25, 4, 8, 0);
      drawGrid(g, 250, 200, 25, 3, 6, 10);
      drawGrid(g, 425, 180, 20, 5, 10, 10);
      drawGrid(g, 400, 20, 35, 2, 4, 35);
   }
   
   //draw rows 0f squares.
   public static void drawRow(Graphics g, int x, int y, int size, int pairs) {
      for (int rep = 0; rep < pairs; rep++) {
         g.setColor(Color.BLACK);
         int StartPoint = 2 * rep * size;
         int EndPoint = (2 * rep + 1) * size;
         g.fillRect(x + StartPoint, y, size, size);
         g.setColor(Color.BLUE);
         g.drawLine(x + StartPoint, y, x + EndPoint, y + size);
         g.drawLine(x + StartPoint, y + size, x + EndPoint, y);
         g.setColor(Color.WHITE);
         g.fillRect(x + EndPoint, y, size, size);
      }
   }
   
   //draw Grid of squares with mortar in y and offset in x.
   public static void drawGrid(Graphics g, int x, int y, int size, int pairs, int lines, int offset) {
      for (int i = 0; i < lines; i++) {
         drawRow(g, x + i % 2 * offset, y + i * (size + mortar), size, pairs);
      }
   }
}