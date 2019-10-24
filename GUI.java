import javax.swing.*;
import java.awt.*;
public class GUI{
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JButton d4 = new JButton("D4");

		f.setSize(500,500);
		f.getContentPane().add(BorderLayout.NORTH, d4);
		f.setVisible(true);
	}
}
