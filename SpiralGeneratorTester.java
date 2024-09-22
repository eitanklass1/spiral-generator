import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Point;

/**
   class SpiralGeneratorTester
   
   This is the tester file for SpiralGenerator.java. This file tests for
   if segments are horizontal or vertical, are connected, and are perpendicular.
 */

public class SpiralGeneratorTester {

  public static void main(String[] args) {
    System.out.println("The following are my unit tests:\n");

    System.out.println("Testing different kinds of starting points, number of segments, and segment lengths:\n");

    System.out.println("Spiral #1\n");
    Point startingPoint1 = new Point(400, 250);
    int unitLength1 = 10;
    printSegments(startingPoint1, unitLength1, 10);

    System.out.println("\nSpiral #2\n");
    Point startingPoint2 = new Point(0, 20000);
    int unitLength2 = 1;
    printSegments(startingPoint2, unitLength2, 100);

    System.out.println("\nSpiral #3\n");
    Point startingPoint3 = new Point(100, 300);
    int unitLength3 = 100;
    printSegments(startingPoint3, unitLength3, 3);

    // System.out.println("");
    // Point2D.Double pointA = new Point2D.Double(400, 300);
    // Point2D.Double pointB = new Point2D.Double(5000, 310);
    // Line2D.Double segmentAB = new Line2D.Double(pointA, pointB);
    // horizontalOrVerticalTest(segmentAB);

    // Point2D.Double pointC = new Point2D.Double(200, 385);
    // Point2D.Double pointD = new Point2D.Double(200,63);
    // Line2D.Double segmentCD = new Line2D.Double(pointC, pointD);
    // horizontalOrVerticalTest(segmentCD);

    // System.out.println("");
    // connectedTest(segmentAB, segmentCD);

    // Point2D.Double pointE = new Point2D.Double(200, 63);
    // Point2D.Double pointF = new Point2D.Double(345,426);
    // Line2D.Double segmentEF = new Line2D.Double(pointE, pointF);
    // connectedTest(segmentCD, segmentEF);

    // System.out.println("");
    // Point2D.Double pointG = new Point2D.Double(200, 63);
    // Point2D.Double pointH = new Point2D.Double(300, 63);
    // Line2D.Double segmentGH = new Line2D.Double(pointG, pointH);

    // Point2D.Double pointI = new Point2D.Double(300, 63);
    // Point2D.Double pointJ = new Point2D.Double(300, 400);
    // Line2D.Double segmentIJ = new Line2D.Double(pointI, pointJ);
    // perpendicularTest(segmentGH, segmentIJ);

    // System.out.println("");

    // Point2D.Double pointK = new Point2D.Double(300, 63);
    // Point2D.Double pointL = new Point2D.Double(301, 400);
    // Line2D.Double segmentKL = new Line2D.Double(pointK, pointL);
    // perpendicularTest(segmentGH, segmentKL);

  }

  public static void printSegments(Point startingPoint, int unitLength, int numberOfSegments) {
    System.out.println("Making a spiral starting from " + startingPoint + " with a unit length of " + unitLength + ", and made up of " + numberOfSegments + " segments:\n");
    SpiralGenerator spiral = new SpiralGenerator(startingPoint, unitLength);
    Line2D currSeg = spiral.nextSegment();
    System.out.println("Segment #" + 0 + " " + currSeg.getP1() + " " + currSeg.getP2());
    horizontalOrVerticalTest(currSeg);
    Line2D prevSeg = currSeg;
    for (int i = 1; i <= numberOfSegments - 1; i++) {
      currSeg = spiral.nextSegment();
      System.out.println("Segment #" + i + " " + currSeg.getP1() + " " + currSeg.getP2());
      horizontalOrVerticalTest(currSeg);
      if (horizontalOrVerticalTest(currSeg) == "failed") {
        connectedTest(prevSeg, currSeg);
        perpendicularTest(prevSeg, currSeg);
      }
      prevSeg = currSeg;
    }
  }

  public static String horizontalOrVerticalTest(Line2D segment) {
    Point2D p1 = segment.getP1();
    Point2D p2 = segment.getP2();
    if (p1.getX() == p2.getX() || p1.getY() == p2.getY()) {
      if (p1.getX() == p2.getX()) {
        return "horizontal";
      } else {
        return "vertical";
      }
    } else {
      System.out.println("FAILED: Segment is neither vertical or horizontal");
      return "failed";
    }
  }

  public static String connectedTest(Line2D segment1, Line2D segment2) {
    Point2D firstSegmentEndpoint = segment1.getP2();
    Point2D secondSegmentStartpoint = segment2.getP1();

    if (firstSegmentEndpoint.equals(secondSegmentStartpoint)) {
      return "connected";
    } else {
      System.out.println("FAILED: Segments aren't connected");
      return "not connected";
    }
  }

  public static void perpendicularTest(Line2D segment1, Line2D segment2) {
    if (connectedTest(segment1, segment2) == "connected") {
      if (horizontalOrVerticalTest(segment1) == "vertical") {
        if (horizontalOrVerticalTest(segment2) != "horizontal") {
          System.out.println("FAILED: Last two segments are not perpendicular");
        }
      } else if (horizontalOrVerticalTest(segment2) == "vertical") {
        if (horizontalOrVerticalTest(segment1) != "horizontal") {
          System.out.println("FAILED: Last two segments are not perpendicular");
        }
      } else {
        System.out.println("FAILED: Last two segments are not perpendicular");
      }
    } else {
      System.out.println("FAILED: Last two segments are not perpendicular");
    }
  }
}