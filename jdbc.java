package sample;
import java.sql.*;
public class jdbc {
	public static void main(String[] args) throws SQLException {
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
		
		String q="insert into student (id,name,age) values(?,?,?);";
		
		PreparedStatement ps=c.prepareStatement(q);
		
		ps.setInt(1, 9);
		ps.setString(2,"rose");
		ps.setInt(3, 22);
		
		int r=ps.executeUpdate();
		if(r>0) {
			System.out.println("value iserted");
		}
		else {
			System.out.println("value not iserted");
		}
	
	}

}
