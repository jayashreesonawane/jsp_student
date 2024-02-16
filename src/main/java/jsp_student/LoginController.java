package jsp_student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		StudentCRUD crud = new StudentCRUD();

		try {
			String dbPassword = crud.getStudent(email);
			RequestDispatcher dispatcher = null;
			if (dbPassword != null) {
				if (password.equals(dbPassword)) 
				{
					List<Student> list = crud.getAllStudents();
					req.setAttribute("list", list);
					dispatcher = req.getRequestDispatcher("success.jsp");
				} else {
					req.setAttribute("message", "Login Failed, Invallid Password");
					dispatcher = req.getRequestDispatcher("login.jsp");
				}

			} else {
				req.setAttribute("message", "User is not exist, Signup");
				dispatcher = req.getRequestDispatcher("signup.jsp");

			}
			dispatcher.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
	
