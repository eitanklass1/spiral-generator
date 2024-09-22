// Name: Eitan Klass
// USC NetID: 1166-0584-70
// CS 455 PA1
// Fall 2024


import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.Point;

/**
   class SpiralGenerator
   
   Generates a "rectangular" spiral, using Java display coordinate system, moving 
   outward from the center of the spiral in a counter-clockwise direction.
   That is, it will head rightward on screen, then, upward, then left, then down, etc.
  
   Length of initial line is unitLength.
   Padding between "layers" of the spiral is also unitLength.
   
   NOTE: we have provided the public interface for this class.  Do not change
   the public interface.  You can add private instance variables, constants, 
   and private methods to the class.  You will also be completing the 
   implementation of the methods given. 
   
 */
public class SpiralGenerator {
   
   private Point curPosition;
   private int unitLength;
   private int size = 1;
   private int increaseSize = 1;
   private int curDirection = 0;
   private int[][] directions = { {1, 0}, {0, -1}, {-1, 0}, {0, 1} };


   /**
      Creates a SpiralGenerator starting at startPosition, with length of first segnment and 
      distance between "layers" both given as unitLength.  Both values are assuming the Java 
      graphics coordinate system.
      @param startPosition starting point of the first segment in the spiral
      @param unitLength in pixels, must be > 0
   */
   public SpiralGenerator(Point startPosition, int unitLength) {
      this.curPosition = startPosition;
      this.unitLength = unitLength;
   }

   /**
      Return the coordinates of the next line segment in the spiral.
      
    */
   public Line2D nextSegment() {
      int x1 = (int)this.curPosition.getX();
      int y1 = (int)this.curPosition.getY();

      int directionX = directions[curDirection][0];
      int directionY = directions[curDirection][1];

      int x2 = x1 + (this.unitLength * size) * directionX;
      int y2 = y1 + (this.unitLength * size) * directionY;

      Point2D.Double a = new Point2D.Double(x1, y1);
      Point2D.Double b = new Point2D.Double(x2, y2);

      Line2D.Double segment = new Line2D.Double(a, b);

      if (curDirection == 3) {
         curDirection = -1;
      }
      curDirection++;
      
      if (increaseSize % 2 == 0) {
         size++;
      }
      increaseSize++;

      curPosition.setLocation(b);
      return segment;
   }

}
