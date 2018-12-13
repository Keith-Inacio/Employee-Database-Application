package empServlet;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 * Display implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Display() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:pace", "system",
					"Pacedb33Pacedb33");

			String sqlComm = "select EmpId, FirstName, LastName, Position, Salary, Telephone, Address, Email from employee Order By EmpID ASC";

			OraclePreparedStatement state = (OraclePreparedStatement) con.prepareStatement(sqlComm);
			OracleResultSet result = (OracleResultSet) state.executeQuery();
			String table = "<h1 align='center'>EMPLOYEE DATABASE PORTAL</h1><table align='center' cellpadding='5' cellspacing='5' border='1'><tr><th>Employee ID</th><th>First Name</th><th>Last Name</th><th>Position</th>"
					+ "<th>Salary</th><th>Telephone</th><th>Address</th><th>Email</th></tr>";

			while (result.next()) {

				String EmpID = result.getString(1);
				String FirstName = result.getString(2);
				String LastName = result.getString(3);
				String Position = result.getString(4);
				String Salary = result.getString(5);
				String Telephone = result.getString(6);
				String Address = result.getString(7);
				String Email = result.getString(8);

				table += "<tr><td>" + EmpID + "</td><td>" + FirstName + "</td><td>" + LastName + "</td><td>" + Position
						+ "</td><td>" + Salary + "</td><td>" + Telephone + "</td><td>" + Address + "</td><td>" + Email
						+ "</td></tr>";

			}

			table += "</table><br><br><a href='http://localhost:8080/DBMS/logout.jsp'><p align='center'>"
					+ "<font color='red'>LOGOUT</font></p></a>";

			out.print(table);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print(e);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
