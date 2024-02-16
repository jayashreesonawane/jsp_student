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
@WebServlet("/edit")
public class EditController extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setEmail(email);
		student.setPassword(password);

		StudentCRUD crud = new StudentCRUD();
		try {
			int count = crud.updateEmployee(student);
			if (count != 0) {
				List<Student> list = crud.getAllStudents();
				req.setAttribute("list",list);
				RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

