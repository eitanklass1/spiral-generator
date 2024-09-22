import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Point;
import java.awt.geom.Line2D;

public class SpiralComponent extends JComponent {

  // instance variables
  private int numOfSegments;
  private int curLength;

  public SpiralComponent(int initialLength, int numOfSegments) {
    this.curLength = initialLength;
    this.numOfSegments = numOfSegments;
  }

  public void paintComponent(Graphics g) {

    Graphics2D g2 = (Graphics2D) g;

    int windowWidth = getWidth();
    int windowHeight = getHeight();

    int startX = windowWidth / 2;
    int startY = windowHeight / 2;
    SpiralGenerator spiral = new SpiralGenerator(new Point(startX, startY), curLength);
    for (int i = 0; i < numOfSegments; i++) {
      Line2D segment = spiral.nextSegment();
      g2.draw(segment);
    }
  }
}
