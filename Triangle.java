package NervousShapes;
import java.awt.Color;

import java.awt.Graphics;

public class Triangle extends Shape
{
private int length;

public Triangle(int x, int y, Color color, int length)
{
  super(x, y, color);
  this.length = length;
}

public void draw(Graphics g)
{
  g.setColor(getColor());
  int[] yCoor = {getY(), getY(), getY() + (int) (length / 2 * Math.sqrt(3))};
  int[] xCoor= {getX(), getX() + length, getX() + length / 2};

  g.fillPolygon(xCoor, yCoor, 3);
}

public int getHeight()
{
  return length;
}

public int getWidth()
{
  return length;
}
}