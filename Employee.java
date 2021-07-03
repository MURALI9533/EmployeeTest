package emptest;
abstract class Employee {
	private String name;
	private String desig;
	private int age;
	private int sal;
	private int empid;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	Employee(){}
	protected Employee(String name, String desig, int age, int sal) {
		super();
		this.name = name;
		this.desig = desig;
		this.age = age;
		this.sal = sal;
	}
	public String toString() {
		return "\n\n---------------------------\nEmployeeId: " + empid + "\nName: "+ name + "\nAge: " + age + "\nSalary: " + sal + "\nDesignation: " + desig +"\n----------------------------";
	}
	public abstract void raiseSalary();
}
class Temp extends Employee {
	Temp(){}
	public void raiseSalary() {
		//It does need this method  its just for holding Employee object temporarily
	}
	
}

