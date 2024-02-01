package Login;

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

/**
 * Servlet implementation class welcome
 */
public class welcome extends HttpServlet {
	Connection conn;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public welcome() {
        super();
        // TODO Auto-generated constructor stub
    }
   /* public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");
		      conn= DriverManager.getConnection("jdbc:postgresql://localhost:5433/"+"creatdb","postgres","Vinay@123");
		      
		}catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void /*doGet*/doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s1=request.getParameter("uname");
		PrintWriter pw=response.getWriter();
		pw.println("<html><body><style>\n"
				+ "        body{\n"
				+ "            background-color: bisque;\n"
				+ "            color: rgb(23, 9, 150);\n"
				+ "        \n"
				+ "        }\n"
				+ "        \n"
				+ "    h1{\n"
				+ "            text-align: center;\n"
				+ "        } </style><h1>");
		
		pw.println("Welcome "+s1);
		pw.println("</h1></body><html>");
		// TODO Auto-generated method stub
	}

}
