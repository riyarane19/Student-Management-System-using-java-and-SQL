import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class main extends JFrame {
Container c;
JButton btn_add, btn_view, btn_update, btn_delete, btn_charts;


main() {

c = getContentPane();
c.setLayout(null);

Font f = new Font("Times New Roman", Font.BOLD, 20);

btn_add = new JButton("ADD");
btn_view = new JButton("VIEW");
btn_update = new JButton("UPDATE");
btn_delete = new JButton("DELETE");
btn_charts = new JButton("CHARTS");

btn_add.setBounds(50,20,150,40);
btn_add.setFont(f);
btn_add.setBackground(new Color(245, 245, 245));
c.add(btn_add);

btn_view.setBounds(290,20,150,40);
btn_view.setFont(f);
btn_view.setBackground(new Color(245, 245, 245));
c.add(btn_view);

btn_update.setBounds(50,100,150,40);
btn_update.setFont(f);
btn_update.setBackground(new Color(245, 245, 245));
c.add(btn_update);

btn_delete.setBounds(290,100,150,40);
btn_delete.setFont(f);
btn_delete.setBackground(new Color(245, 245, 245));
c.add(btn_delete);

btn_charts.setBounds(175,190,150,40);
btn_charts.setFont(f);
btn_charts.setBackground(new Color(245, 245, 245));
c.add(btn_charts);

ActionListener a1 = (ae) -> { add a = new add();  dispose(); };
btn_add.addActionListener(a1);

ActionListener a2 = (ae) -> { view a = new view();  dispose(); };
btn_view.addActionListener(a2);

ActionListener a3 = (ae) -> { update a = new update();  dispose(); };
btn_update.addActionListener(a3);

ActionListener a4 = (ae) -> { delete a = new delete();  dispose(); };
btn_delete.addActionListener(a4);

ActionListener a5 = (ae) -> { Charts a = new Charts();  };
btn_charts.addActionListener(a5);


setTitle("S.M.S");
setSize(500, 400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
c.setBackground(new Color(142, 195, 229));
//c.setBackground(Color.PINK);
}
}




