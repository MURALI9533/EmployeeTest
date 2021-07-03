package emptest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
public class Serve {
	private String name;
	private int age;
	private boolean readData() {
		try {
			EmplApp.enterNameMessage();
			name = br.readLine();
			EmplApp.enterAgeMessage();
			age = Integer.parseInt(br.readLine());
			return true;
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} 
		return false;
	}
	public static Logic getLogic() {
		return new Logic();
	}
	public static Serve getServe() {
		return new Serve();
	}
	Scanner scanner = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public int insertLogic(int choice) {
		Employee emp = null;
		switch(choice) {
				
		case 1: if(!readData()) {
			EmplApp.errorMessage();
					return 0;
				}
				emp = new Clerk(name, age);
			break;
		case 2: if(!readData()) {
			EmplApp.errorMessage();
					return 0;
				}
				emp = new Manager(name, age);
			break;
		case 3:if(!readData()) {
				EmplApp.errorMessage();
					return 0;
				}
				emp = new Programmer(name, age);
			break;
		case 4:EmplApp.exitMessage();
				return 0;
		default:EmplApp.invalidEntryMessage();
				return 0;
		}
		return getLogic().insertRecord(emp);
	}
	public List<Employee> showAllRecords() {
		return getLogic().getAllRecords();
	}
	public void raiseSalaryLogic(int choice) {
		Employee emp = null;
		switch(choice) {
		case 1: emp = new Clerk();
				emp.setDesig("Clerk");
			break;
		case 2: emp = new Manager();
				emp.setDesig("Manager");
			break;
		case 3:	emp = new Programmer();
				emp.setDesig("Programmer");
			break;
		case 4:EmplApp.exitMessage();
		break;
		default:EmplApp.invalidEntryMessage();
			return;
		}
		if(emp != null) getLogic().raiseSalary(emp);
	}
	public int deleteRecordByIdLogic(int empid) {
		return getLogic().deleteRecordById(empid);
	}
}


