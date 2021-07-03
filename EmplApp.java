package emptest;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
public class EmplApp {
	static Scanner  scanner = new Scanner(System.in);
	static Logger logger=Logger.getLogger(EmplApp.class.getName());
	public static void main(String[] args) {
		int choice = 0;
		do {
			logger.info("1.insert record\n2.display records\n3.raise salary\n4.delete record by id\n5.exit");
			choice = scanner.nextInt();
			switch(choice) {
			case 1:int insertion=Control.insert();
			if(insertion>0) logger.info("insertion suceesfull....."); else logger.info("insertion not sucessfull....");
				break;
			case 2: List<Employee> emplist=Control.records();
			for(Employee e: emplist) {
				System.out.println(e);
			}
				break;
			case 3:Control.raiseSalary();
				break;
			case 4:logger.info("enter id to remove record...");
				int delete=Control.deleteRecord(scanner.nextInt());
				if(delete > 0) logger.info("record removed successfully...");
					else logger.info("record remove unsuccessful..."); 
			
					break;
			case 5: logger.info("exiting...");
			        break;
				default: logger.info("invalid choice..."); 
						break;
			}
		} while(choice != 5);
		scanner.close();
	}
	public static int userChoice() {
		logger.info("1.Clerk\n2.Manger\n3.Programmer\n4.Exit...");
		return scanner.nextInt();
	}
	public static void errorMessage() {
		logger.info("error while reading data...");
	}
	public static void exitMessage() {
		logger.info("exiting................");
	}
	public static void invalidEntryMessage() {
		logger.info("invalid entry......");
	}
	public static void enterNameMessage() {
		logger.info("enter name...");
	}
	public static void enterAgeMessage() {
		logger.info("age...");
	}
}


