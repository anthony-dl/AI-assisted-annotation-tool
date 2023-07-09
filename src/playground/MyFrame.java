import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MyFrame extends JFrame {
    MyFrame(){
        this.setSize(1080 / 2, 720 / 2);
        this.setTitle("AI assisted annotation tool");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // exit out of application
        this.setResizable(false); // prevent resizing
        this.setVisible(true);

        ImageIcon image = new ImageIcon("../icon/AI-logo.png");
        this.setIconImage(image.getImage());

        this.getContentPane().setBackground(new Color(0x123456));
    }
}
