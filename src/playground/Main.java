import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public  static void main(String[] args) {

        int desiredIconWidth = 100;
        int desiredIconHeight = 100;
        ImageIcon icon = new ImageIcon("../icon/AI-logo.png");
        ImageIcon image = new ImageIcon("../icon/machine-vision.jpg");
        Image originalImage = image.getImage();
        Image resizedImage = originalImage.getScaledInstance(desiredIconWidth, desiredIconHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        Border border = BorderFactory.createLineBorder(Color.green, 3);

//        frame.getContentPane().setBackground(new Color(0x123456));

        JLabel label = new JLabel();
        label.setText("Bro, I'm here to assist you to annotate images");
        label.setIcon(resizedIcon);
        label.setHorizontalTextPosition(JLabel.CENTER);  // set text left, center of right
        label.setVerticalTextPosition(JLabel.TOP);  // set text TOP, CENTER or BOTTOM
        label.setForeground(new Color(0x00FF00));
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label.setIconTextGap(-25);  // set gap of text to image
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 0, 250, 250);

//        Create JPannel in Java
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(600, 600, 250, 250);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // exit out of application
        frame.setSize(1080 / 2, 720 / 2);
        frame.setTitle("AI assisted annotation tool");
        frame.setIconImage(icon.getImage());
        frame.setLayout(null);  // remove this one will result in centered labels and icons
//        frame.setResizable(false); // prevent resizing
        frame.setVisible(true);
        frame.add(redPanel);
        frame.add(label);
//        frame.pack();  // add all components before packing
    }
}