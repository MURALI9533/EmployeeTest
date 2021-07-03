package emptest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Logic {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	String sal="salary";
	
	private void getDatabaseConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/murali","root","tiger");
	}
	private void closeConnections() {
		try {
			if(connection != null) connection.close();
			if(preparedStatement != null) preparedStatement.close();
			if(resultSet != null) resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int insertRecord(Employee employee) {
		try {
			getDatabaseConnection();
			preparedStatement = connection.prepareStatement("insert into employee_details values(?,?,?,?,?)");
			employee.setEmpid(getRowNumber());
			preparedStatement.setInt(1, employee.getEmpid());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setInt(3, employee.getAge());
			preparedStatement.setString(4, employee.getDesig());
			preparedStatement.setInt(5, employee.getSal());
			return preparedStatement.executeUpdate();
		} catch (SQLException| ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeConnections();
		}
		return 0;
	}
	public int getRowNumber() {
		Statement statement = null;
		String getEmpId = "select coalesce((select max(empid)+1 from murali.employee_details),1) as getid";
		try {
			getDatabaseConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(getEmpId);
			resultSet.next();
			return resultSet.getInt("getid");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	public List<Employee> getAllRecords() {
		List<Employee> emplist = new ArrayList<>();
		try {
			getDatabaseConnection();
			preparedStatement = connection.prepareStatement("select * from employee_details");
			resultSet = preparedStatement.executeQuery();
			Employee em;
			while(resultSet.next()) {
				em = new Temp();
				em.setEmpid(resultSet.getInt("empid"));
				em.setName(resultSet.getString("empname"));
				em.setAge(resultSet.getInt("age"));
				em.setDesig(resultSet.getString("designation"));
				em.setSal(resultSet.getInt(sal));
				emplist.add(em);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return emplist;
	}
	public int raiseSalary(Employee employee) {
		
		try {
			int count=0;
			getDatabaseConnection();
			preparedStatement = connection.prepareStatement("select * from employee_details where designation = ?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			preparedStatement.setString(1, employee.getDesig());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				count=count+1;
				employee.setSal(resultSet.getInt(sal));
				employee = changeSalary(employee);
				resultSet.updateInt(sal, employee.getSal());
				resultSet.updateRow();
			}
			return count;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	public Employee changeSalary(Employee empl) {
		empl.raiseSalary();
		return empl;
	}
	
	public int deleteRecordById(int empid) {
		try {
			getDatabaseConnection();
			preparedStatement = connection.prepareStatement("delete from employee_details where empid = ?");
			preparedStatement.setInt(1, empid);
			return preparedStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeConnections();
		}
		return 0;
	}
	
 }

