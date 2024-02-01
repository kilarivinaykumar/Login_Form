package regis;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Reeservlet
 */

public class Reeservlet extends HttpServlet {
	Connection conn;
	private static final long serialVersionUID = 1L;
       
    
	public void init(ServletConfig config) throws ServletException {
		try {
			 Class.forName("org.postgresql.Driver");
		      conn= DriverManager.getConnection("jdbc:postgresql://localhost:5433/"+"creatdb","postgres","Vinay@123");
		      
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String s1=request.getParameter("fname");
			String s2=request.getParameter("lname");
			String s3=request.getParameter("uname");
			String s4=request.getParameter("pword");
			PreparedStatement ps=conn.prepareStatement("insert into smaple_data values(?,?,?,?)");
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			ps.setString(4, s4);
			ps.executeUpdate();
			PrintWriter pw=response.getWriter();
			pw.println("<html><body><h1><a href=log.html>Login</a>");
			pw.println("Successfully register");
			pw.println("</h1></body></html>");
			
		
	}catch(Exception e) {
		e.printStackTrace();
	}

}
}
