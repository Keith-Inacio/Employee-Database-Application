package empServlet;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String empID = request.getParameter("EmpID").toString();
		String password = request.getParameter("password").toString();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:pace", "system",
					"Pacedb33Pacedb33");
			String sqlComm = "select * from Employee where EmpID='" + empID + "'and Password='" + password + "'";
			OraclePreparedStatement state = (OraclePreparedStatement) con.prepareStatement(sqlComm);
			OracleResultSet result = (OracleResultSet) state.executeQuery();
			if (result.next()) {
				HttpSession sesh = request.getSession(true);
				sesh.setAttribute("employee", empID);
				response.sendRedirect("/DBMS/Display");
			} else {
				out.println("INVALID LOGIN");
			}
		} catch (Exception e) {
			out.println(e);
		}
		
	}
}
