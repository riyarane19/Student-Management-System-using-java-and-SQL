import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.io.File;
import java.io.IOException;


class Charts extends JFrame {

Charts() {


try
      {
          
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "abc123");
        final String SQL = "SELECT rno, name, marks1, marks2, marks3 FROM Student";
        final CategoryDataset dataset = new JDBCCategoryDataset(con, SQL);
        JFreeChart ch = ChartFactory.createBarChart("Student Performance","Subject","Marks",dataset,PlotOrientation.VERTICAL , true, true, true);
        ChartPanel cp = new ChartPanel(ch);
		setContentPane(cp);
		File f = new File("Student.jpeg");
		ChartUtilities.saveChartAsPNG(f, ch, 700, 400 );
      }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
	setTitle("CHART");
	setSize(700,400);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true); 
	
       
}
}

class ChartsTest
{
public static void main(String args[])
{
Charts c= new Charts();
}
}
