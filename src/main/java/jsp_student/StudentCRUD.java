package jsp_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentCRUD {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "root");
	}

	public int signup(Student student) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getName());
		preparedStatement.setLong(3, student.getPhone());
		preparedStatement.setString(4, student.getAddress());
		preparedStatement.setString(5, student.getEmail());
		preparedStatement.setString(6, student.getPassword());

		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;

	}

	public String getStudent(String email) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE EMAIL=?");
		preparedStatement.setString(1, email);

		ResultSet resultset = preparedStatement.executeQuery();
		String password = null;
		while (resultset.next()) {
			password = resultset.getString("password");
		}
		connection.close();
		return password;
	}

	public List<Student> getAllStudents() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT");
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Student> list = new ArrayList<>();
		while (resultSet.next()) {
			Student student = new Student();
			student.setId(resultSet.getInt("id"));
			student.setName(resultSet.getString("name"));
			student.setPhone(resultSet.getLong("phone"));
			student.setAddress(resultSet.getString("address"));
			student.setEmail(resultSet.getString("email"));
			student.setPassword(resultSet.getString("password"));

			list.add(student);
		}
		connection.close();
		return list;
	}

	public int delete(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM STUDENT WHERE ID=?");
		preparedStatement.setInt(1, id);
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}

	public Student getEmployee(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE ID=?");
		preparedStatement.setInt(1, id);

		ResultSet resultset = preparedStatement.executeQuery();
		Student student = new Student();
		while (resultset.next()) {
			student.setId(resultset.getInt("id"));
			student.setName(resultset.getString("name"));
			student.setPhone(resultset.getLong("phone"));
			student.setAddress(resultset.getString("address"));
			student.setEmail(resultset.getString("email"));
			student.setPassword(resultset.getString("password"));
		}
		connection.close();
		return student;
	}

	public int updateEmployee(Student student) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE STUDENT SET NAME=?,PHONE=?,ADDRESS=?,EMAIL=?,PASSWORD=? WHERE ID=?");
		preparedStatement.setString(1, student.getName());
		preparedStatement.setLong(2, student.getPhone());
		preparedStatement.setString(3, student.getAddress());
		preparedStatement.setString(4, student.getEmail());
		preparedStatement.setString(5, student.getPassword());
		preparedStatement.setInt(6, student.getId());
		
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;

	}
}

