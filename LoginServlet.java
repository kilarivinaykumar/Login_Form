package regis;

import jakarta.servlet.RequestDispatcher;
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
import java.sql.ResultSet;

/**
 * Servlet implementation class loginservlet
 */

public class loginservlet extends HttpServlet {
	Connection conn;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String s1=request.getParameter("uname");
			String s2=request.getParameter("pword");
			PreparedStatement ps=conn.prepareStatement("select * from smaple_data where uname=? and pword=?");
			ps.setString(1, s1);
			ps.setString(2, s2);
			ResultSet rs=ps.executeQuery();
			PrintWriter pw=response.getWriter();
			//pw.println("<html><center><body><h1>");
			
			if(rs.next()) {
				RequestDispatcher ed=request.getRequestDispatcher("welcome");
				ed.forward(request, response);
				//pw.println("Welcome to loging page "+ s1);
				//response.sendRedirect("welcome");
				
			}else {
				RequestDispatcher ed=request.getRequestDispatcher("log.html");
				ed.include(request, response);
				
				pw.println("Invalid uname or pword");
			}
			//pw.println("</h1></body></center></html>");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
