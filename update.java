import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class update extends JFrame {
Container c;
JLabel lbl_rno, lbl_name, lbl_marks1 ,lbl_marks2, lbl_marks3;
JTextField txt_rno, txt_name, txt_marks1 ,txt_marks2, txt_marks3; 
JButton btn_save, btn_back;
public void reset() {
		txt_rno.setText("");
		txt_name.setText("");
		txt_marks1.setText("");
		txt_marks2.setText("");
		txt_marks3.setText("");
}
update() {

c = getContentPane();
c.setLayout(null);

Font f = new Font("Times New Roman", Font.BOLD , 20);

lbl_rno = new JLabel("Enter your Roll No");
lbl_name = new JLabel("Enter your Name");
lbl_marks1 = new JLabel("Enter your marks1");
lbl_marks2 = new JLabel("Enter your marks2");
lbl_marks3 = new JLabel("Enter your marks3");

txt_rno = new JTextField(20);
txt_name = new JTextField(20);
txt_marks1 = new JTextField(20);
txt_marks2 = new JTextField(20);
txt_marks3 = new JTextField(20);

btn_save = new JButton("SAVE");
btn_back = new JButton("BACK");

lbl_rno.setBounds(110,30,265,25);
lbl_rno.setFont(f);
lbl_rno.setBackground(new Color(245, 245, 245));
c.add(lbl_rno);

txt_rno.setBounds(65,55,265,25);
txt_rno.setFont(f);
txt_rno.setBackground(new Color(245, 245, 245));
c.add(txt_rno);

lbl_name.setBounds(110,90,265,25);
lbl_name.setFont(f);
lbl_name.setBackground(new Color(245, 245, 245));
c.add(lbl_name);

txt_name.setBounds(65,115,265,25);
txt_name.setFont(f);
txt_name.setBackground(new Color(245, 245, 245));
c.add(txt_name);

lbl_marks1.setBounds(110,150,265,25);
lbl_marks1.setFont(f);
lbl_marks1.setBackground(new Color(245, 245, 245));
c.add(lbl_marks1);

txt_marks1.setBounds(65,175,265,25);
txt_marks1.setFont(f);
txt_marks1.setBackground(new Color(245, 245, 245));
c.add(txt_marks1);

lbl_marks2.setBounds(110,210,265,25);
lbl_marks2.setFont(f);
lbl_marks2.setBackground(new Color(245, 245, 245));
c.add(lbl_marks2);

txt_marks2.setBounds(65,235,265,25);
txt_marks2.setFont(f);
txt_marks2.setBackground(new Color(245, 245, 245));
c.add(txt_marks2);

lbl_marks3.setBounds(110,270,265,25);
lbl_marks3.setFont(f);
lbl_marks3.setBackground(new Color(245, 245, 245));
c.add(lbl_marks3);

txt_marks3.setBounds(65,295,265,25);
txt_marks3.setFont(f);
txt_marks3.setBackground(new Color(245, 245, 245));
c.add(txt_marks3);

btn_save.setBounds(140,325,100,25);
btn_save.setFont(f);
btn_save.setBackground(new Color(245, 245, 245));
c.add(btn_save);

btn_back.setBounds(140,355,100,25);
btn_back.setFont(f);
btn_back.setBackground(new Color(245, 245, 245));
c.add(btn_back);

ActionListener a1 = (ae) -> {

try {
	String rno = txt_rno.getText();
	String name = txt_name.getText();
	String marks1 = txt_marks1.getText();
	String marks2 = txt_marks2.getText();
	String marks3 = txt_marks3.getText();
	DbHandler.updateStudent(Integer.parseInt(rno),name,Integer.parseInt(marks1),Integer.parseInt(marks2),Integer.parseInt(marks3));
	reset();
}
catch(NumberFormatException e) {
JOptionPane.showMessageDialog(new JDialog(), " Field Should Not Be Empty " + e);
reset();
}
};
btn_save.addActionListener(a1);

ActionListener a2 =  (ae) -> { main a= new main(); dispose(); };
btn_back.addActionListener(a2);
	
setTitle("Update Student");
setSize(400,500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
c.setBackground(new Color(240,205,140));
}
}

