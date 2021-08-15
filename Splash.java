import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Splash extends JFrame {
Container c;
JLabel lbl_msg;

Splash() {
c = getContentPane();
c.setLayout(new FlowLayout());


Font f = new Font("Arial" , Font.BOLD,70);
lbl_msg = new JLabel("<html><center>Welcome<br>to<br>SMS</center></html>");
lbl_msg.setForeground(Color.WHITE);
lbl_msg.setFont(f);
c.add(lbl_msg);

new Thread() {
	public void run() {
		try {
			Thread.sleep(2000);
			dispose();
			main m = new main();
		}catch(Exception e) { }
	}
}.start();

c.setBackground(new Color(245,170,170));
setUndecorated(true);
setSize(500, 400);
setLocationRelativeTo(null);
setVisible(true);
}
}