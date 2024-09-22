import java.util.Scanner;

import javax.swing.JFrame;

public class SpiralViewer {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter length of initial segment: ");
    int initialLength;
    initialLength = sc.nextInt();

    // Error handing
    while (initialLength <= 0) {
      System.out.println("ERROR: value must be > 0");
      System.out.print("Enter length of initial segment: ");
      initialLength = sc.nextInt();
    }

    System.out.print("Enter number of segments: ");
    int numOfSegments;
    numOfSegments = sc.nextInt();

    // Error handing
    while (numOfSegments <= 0) {
      System.out.println("ERROR: value must be > 0");
      System.out.print("Enter number of segments: ");
      numOfSegments = sc.nextInt();
    }
    
    sc.close();

    // Create a JFrame window for displaying the spiral
    JFrame frame = new JFrame();

    frame.setSize(800, 500);
    frame.setTitle("Spiral");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a SpiralComponent object that will handle the drawing of the spiral
    SpiralComponent component = new SpiralComponent(initialLength, numOfSegments);
    frame.add(component);

    frame.setVisible(true);
  }

}
