import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class view extends JFrame {
Container c;
TextArea ta_data;
JButton btn_back;

view() {
c = getContentPane();
c.setLayout(new FlowLayout());
Font f = new Font("Times New Roman", Font.BOLD , 20);

ta_data = new TextArea(20,35);
btn_back = new JButton("Back");


c.add(ta_data);

btn_back.setBounds(140,355,100,25);
btn_back.setFont(f);
btn_back.setBackground(new Color(245, 245, 245));
c.add(btn_back);

String data = DbHandler.getStudent();
if(data.length() == 0)
	ta_data.setText("no record");
else
	ta_data.setText(data);

ActionListener a1 = (ae) -> {main a = new main(); dispose(); };
btn_back.addActionListener(a1);
setTitle("View Student");
setSize(400, 500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}