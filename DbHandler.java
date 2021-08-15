import java.sql.*;
import javax.swing.*;


class DbHandler {

	public boolean validString(String name) {
      name = name.toLowerCase();
      char[] charArray = name.toCharArray();
      for (int i = 0; i < charArray.length; i++) {
         char ch = charArray[i];
         if (!(ch >= 'a' && ch <= 'z')) {
            return false;
         }
      }
      return true;
   }
   


public static void addStudent(int rno, String name, int marks1, int marks2, int marks3) {
		
try {
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "abc123");

   
String sql = "insert into Student values(?, ?, ?, ?, ?)";

DbHandler db = new  DbHandler();
boolean bool = db.validString(name);


if(rno < 0 ) 
		JOptionPane.showMessageDialog(new JDialog(), " Roll no should be greater than 0 "); 
else if (name.length() < 1) 
		JOptionPane.showMessageDialog(new JDialog(), " Enter Student Full Name "); 
else if (!bool) 
		JOptionPane.showMessageDialog(new JDialog(), " Name should only contain alphabets "); 
else if (marks1 < 0 || marks1 > 100 ) 
		JOptionPane.showMessageDialog(new JDialog(), " Invalid marks "); 
else if (marks2 < 0 || marks2 > 100) 
		JOptionPane.showMessageDialog(new JDialog(), " Invalid marks "); 
else if (marks3 < 0 || marks3 > 100) 
		JOptionPane.showMessageDialog(new JDialog(), " Invalid marks "); 	
else {
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setInt(1, rno);
	pst.setString(2, name);
	pst.setInt(3, marks1);
	pst.setInt(4, marks2);
	pst.setInt(5, marks3);
	pst.executeUpdate();
	JOptionPane.showMessageDialog(new JDialog(), " record added ");
	}
	
	con.close();
}
catch(SQLException e) {
	JOptionPane.showMessageDialog(new JDialog(), "issue" + e);
}
catch(RuntimeException e)
{
	JOptionPane.showMessageDialog(new JDialog(), "issue " +e);
}
}

public static String getStudent() {
String data = "";
try {
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "abc123");

String sql = "select *from Student";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);
while(rs.next())
	data = data + " Rno = " + rs.getInt(1) + " Name = " + rs.getString(2) + " Marks1 = " + rs.getInt(3) + " Marks2 = " + rs.getInt(4) + " Marks3 = " + rs.getInt(5) + "\n";
con.close();
}
catch(SQLException e) {
JOptionPane.showMessageDialog(new JDialog(), "issue" + e);
}
return data;
}


public static void updateStudent(int rno, String name, int marks1, int marks2, int marks3) {
try {
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "abc123");

	String sql = "update Student set name = ?, marks1 = ?, marks2 = ?,  marks3 = ? where rno = ?";
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setString(1, name);
	pst.setInt(2, marks1);
	pst.setInt(3, marks2);
	pst.setInt(4, marks3);
	pst.setInt(5, rno);
	
DbHandler db = new DbHandler();
boolean bool1 = db.validString(name);
if(rno < 0 ) 
		JOptionPane.showMessageDialog(new JDialog(), "Roll no should be greater than 0"); 
else if ( name.length() < 2) 
		JOptionPane.showMessageDialog(new JDialog(), "The length of name should be greater than 2"); 
else if (!bool1) 
		JOptionPane.showMessageDialog(new JDialog(), "Name should only contain alphabets");
else if (marks1 < 0 || marks1 > 100) 
		JOptionPane.showMessageDialog(new JDialog(), "Invalid marks1"); 
else if (marks2 < 0 || marks2 > 100) 
		JOptionPane.showMessageDialog(new JDialog(), "Invalid marks2"); 
else if (marks3 < 0 || marks3 > 100) 
		JOptionPane.showMessageDialog(new JDialog(), "Invalid marks3"); 
else {
	int r = pst.executeUpdate();
	JOptionPane.showMessageDialog(new JDialog(), r + " record updated");
	}
	con.close();
}
catch(SQLException e) {
JOptionPane.showMessageDialog(new JDialog(), "issue" + e);
}
}

public static void deleteStudent(int rno) {
try {
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "abc123");

	String sql = "delete from Student where rno = ?";
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setInt(1, rno);

	if( rno <= 0) {
			JOptionPane.showMessageDialog(new JDialog(), " Record Does not Exists ");
	}

	else {
	int r = pst.executeUpdate();
	JOptionPane.showMessageDialog(new JDialog(), r + " Record Deleted ");
	}
	con.close();
}

catch(SQLException e) {
JOptionPane.showMessageDialog(new JDialog(), "issue" + e);
}
}
}