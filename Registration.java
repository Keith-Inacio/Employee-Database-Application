package empServlet;

import java.io.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OraclePreparedStatement;


/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String first = request.getParameter("FirstName").toString();
		String last = request.getParameter("LastName").toString();
		String salary = request.getParameter("Salary").toString();
		String position = request.getParameter("Position").toString();
		String telephone = request.getParameter("Telephone").toString();
		String address = request.getParameter("Address").toString();
		String email = request.getParameter("Email").toString();
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:pace", "system","Pacedb33Pacedb33");
		String sqlComm = "insert into employee values('" + empID + "','" + password + "','" + last + "','" + first + "','"
				+ email + "','" + position + "','" + salary + "','" + telephone + "','" + address+ "')";

		OraclePreparedStatement state = (OraclePreparedStatement) con.prepareStatement(sqlComm);
		state.execute();
		
		out.println("Employee " + first+" "+last+" registered sucessfully.");
		String link="<br><a href='http://localhost:8080/DBMS/login.jsp'><p style=text-align:'center'><font color ='Red'>Click To Login</font></p></a>";
		out.println(link);
		
		}catch(Exception e) {
			out.println(e);
	}
	}
}
