package jsp_student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateController extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentCRUD crud = new StudentCRUD();

		try 
		{
			Student student = crud.getEmployee(id);
			if (student != null) 
			{
				req.setAttribute("stud", student);
				RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
				dispatcher.forward(req, resp);
			}
		} 
		
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		} 
	}
}

