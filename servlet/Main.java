package smaple;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Main")

public class Main extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException  {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sharmi","root","root");
			String q = "insert into user( name ,phone,email,password )values(?,?,?,?);";
			PreparedStatement ps = c.prepareStatement(q);
			

			String name =req.getParameter("name");
			String phone =req.getParameter("phone");
			String email =req.getParameter("email");
			String password =req.getParameter("password");
			
			
			
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, password);
			PrintWriter out = res.getWriter();
			
			int r = ps.executeUpdate();
			
			res.setContentType("text/tml");
			if(r>0) {
			out.print("<h3>Successfully registered</h3>");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}