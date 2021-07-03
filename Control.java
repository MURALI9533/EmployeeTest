package emptest;
import java.util.List;


public class Control {	
	private Control() {};
public static int insert() {
	return Serve.getServe().insertLogic(EmplApp.userChoice());
}
public static List<Employee> records(){	
	return Serve.getServe().showAllRecords();
	
}
public static void raiseSalary() {
	Serve.getServe().raiseSalaryLogic(EmplApp.userChoice());
}

	
public static int deleteRecord(int id) {
	return Serve.getServe().deleteRecordByIdLogic(id);
}
	
	}

