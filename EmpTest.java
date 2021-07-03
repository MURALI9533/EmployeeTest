package emptest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


import org.junit.jupiter.api.Test;


class EmpTest {

	

	@Test
	void testInsertRecord() {
		Logic l=new Logic();
		Employee c=new Clerk("anjanana",10);
		int actual=l.insertRecord(c);
		int expected=1;
		assertEquals(expected,actual);
	}
	@Test
	void testDeleteRecordByID() {
		Logic l=new Logic();
		int actual=l.deleteRecordById(87);
		int expected=1;
		assertEquals(expected, actual);
	}
	@Test
	void testChangeSalary() {
		Logic l=new Logic();
		Employee c=new Clerk("Amar",18);
		Employee e=l.changeSalary(c);
		int actual=e.getSal();
		int expected=21000;
		assertEquals(expected, actual);
		
	}
	@Test
	void testgetRowNumber() {
		Logic l=new Logic();
		int actual=l.getRowNumber();
		int expected=88;
		assertEquals(expected, actual);
	}
	@Test
	void testGetAllRecords() {
		Logic l=new Logic();
		 List<Employee> emplist=l.getAllRecords();
		 int actual=emplist.size();
		 int expected=58;
		 assertEquals(expected, actual);
		
	}
	@Test
	void testRaiseSalary() {
		Logic l=new Logic();
		Employee clerk=new Clerk();
		clerk.setDesig("Clerk");
		int actual=l.raiseSalary(clerk);
		int expected=41;
		assertEquals(expected, actual);
	}
	@Test
	void testShowAllRecords() {
		List<Employee> emplist=Serve.getServe().showAllRecords();
		 int actual=emplist.size();
		 int expected=62;
		 assertEquals(expected, actual);
		
	}

}
