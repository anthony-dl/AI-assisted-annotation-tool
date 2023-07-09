import java.awt.*;
import java.awt.event.*;
 
// An AWT GUI program inherits the top-level container java.awt.Frame
public class AWTBorderLayoutDemo extends Frame {
   private Button btnNorth, btnSouth, btnCenter, btnEast, btnWest;
 
   // Constructor to setup GUI components and event handlers
   public AWTBorderLayoutDemo () {
      setLayout(new BorderLayout(3, 3));
         // "super" Frame sets layout to BorderLayout,
         // horizontal and vertical gaps of 3 pixels
 
      // The components are added to the specified zone
      btnNorth = new Button("NORTH");
      add(btnNorth, BorderLayout.NORTH);
      btnSouth = new Button("SOUTH");
      add(btnSouth, BorderLayout.SOUTH);
      btnCenter = new Button("CENTER");
      add(btnCenter, BorderLayout.CENTER);
      btnEast = new Button("EAST");
      add(btnEast, BorderLayout.EAST);
      btnWest = new Button("WEST");
      add(btnWest, BorderLayout.WEST);
 
      setTitle("BorderLayout Demo"); // "super" Frame sets title
      setSize(280, 150);             // "super" Frame sets initial size
      setVisible(true);              // "super" Frame shows
   }
 
   // The entry main() method
   public static void main(String[] args) {
      new AWTBorderLayoutDemo();  // Let the constructor do the job
   }
}
