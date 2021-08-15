import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class delete extends JFrame {
Container c;
JLabel lbl_rno;
JTextField txt_rno;
JButton btn_save, btn_back;
public void reset() {
		txt_rno.setText("");
}
delete() {

c = getContentPane();
c.setLayout(null);

Font f = new Font("Times New Roman", Font.BOLD , 20);

lbl_rno = new JLabel("Enter your Roll No");

txt_rno = new JTextField(20);
btn_save = new JButton("SAVE");
btn_back = new JButton("BACK");

lbl_rno.setBounds(110,30,265,25);
lbl_rno.setFont(f);
lbl_rno.setBackground(new Color(245, 245, 245));
c.add(lbl_rno);

txt_rno.setBounds(65,60,265,25);
txt_rno.setFont(f);
txt_rno.setBackground(new Color(245, 245, 245));
c.add(txt_rno);

btn_save.setBounds(140,100,100,25);
btn_save.setFont(f);
btn_save.setBackground(new Color(245, 245, 245));
c.add(btn_save);

btn_back.setBounds(140,130,100,25);
btn_back.setFont(f);
btn_back.setBackground(new Color(245, 245, 245));
c.add(btn_back);

ActionListener a1 = (ae) -> { 

try {
	String rno = txt_rno.getText();
	DbHandler.deleteStudent(Integer.parseInt(rno));
	reset();
}	
catch(NumberFormatException e) {
JOptionPane.showMessageDialog(new JDialog(), " Field Should Not Be Empty " + e);
reset();
}
};
btn_save.addActionListener(a1);


ActionListener a2 = (ae) -> { main m = new main(); dispose(); };
btn_back.addActionListener(a2);

setTitle("Delete Student");
setSize(400,500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
c.setBackground(new Color(245,170,190));
}
}
