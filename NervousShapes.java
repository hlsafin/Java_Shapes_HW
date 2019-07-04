


package NervousShapes;
import java.awt.*;

public class NervousShapes {

private static final int DELAY = 100;

private static final int MAX_SIZE = 40;
    
private static final int MIN_SIZE = 10;
    
private static final int NUM_SHAPES = 90;
 
private static final int WINDOW_SIZE = 400;


private static final int CHANGE_RANGE = 2;


private static DrawingPanel panel;
private static Graphics g;
    
private static Shape shapes[] = new Shape[NUM_SHAPES];
    




private static void createWindow() {
   
   panel = new DrawingPanel(WINDOW_SIZE, WINDOW_SIZE);

    
    g = panel.getGraphics();
}


private static void createShapes() {
    for (int i = 0; i < shapes.length; i++) {
    
      int red = generateRandomInt(0, 255);
      int green = generateRandomInt(0, 255);
      int blue = generateRandomInt(0, 255);
      Color color = new Color(red, green, blue);
      
      double randomValue = Math.random();
     
      if (randomValue < 0.333){
   
        int diameter = generateRandomInt(MIN_SIZE, MAX_SIZE);
        int x = generateRandomInt(0, WINDOW_SIZE - diameter);
        int y = generateRandomInt(0, WINDOW_SIZE - diameter);
        shapes[i] = new Circle(x, y, color, diameter);
      }
      else if (randomValue < 0.666)
      {
        
        int width = generateRandomInt(MIN_SIZE, MAX_SIZE);
        int height = generateRandomInt(MIN_SIZE, MAX_SIZE);
        int x = generateRandomInt(0, WINDOW_SIZE - width);
        int y = generateRandomInt(0, WINDOW_SIZE - height);
        shapes[i] = new Rectangle(x, y, color, width, height);
      }
      else
      {

       int length = generateRandomInt(MIN_SIZE, MAX_SIZE);
          int x = generateRandomInt(0, WINDOW_SIZE - length);
          int y = generateRandomInt(0, WINDOW_SIZE - length);
          shapes[i] = new Triangle(x, y, color, length);
      }
    }
}


private static void animateShapes() {
    while (true) {

      g.setColor(Color.white);
      g.fillRect(0, 0, WINDOW_SIZE - 1, WINDOW_SIZE - 1);
      for (int i = 0; i < shapes.length; i++) {
      
        int dx = generateRandomInt(-CHANGE_RANGE, +CHANGE_RANGE);
        int newX = shapes[i].getX() + dx;
        if (newX >= 0 &&
            newX + shapes[i].getWidth() < WINDOW_SIZE)
          shapes[i].move(dx, 0);

       
        int dy = generateRandomInt(-CHANGE_RANGE, +CHANGE_RANGE);
        int newY = shapes[i].getY() + dy;
        if (newY >= 0 &&
            newY + shapes[i].getHeight() < WINDOW_SIZE)
          shapes[i].move(0, dy);


        shapes[i].draw(g);
      }
   
      panel.sleep(DELAY);

    }
}

private static int generateRandomInt(int min, int max) {
    return (int) ((max - min + 1) * Math.random()) + min;
}


public static void main(String[] args) {
    createWindow();
    createShapes();
    animateShapes();
}
}

