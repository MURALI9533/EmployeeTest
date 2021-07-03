package emptest;
public final class Programmer extends Employee {
	Programmer(){}
	public Programmer(String name, int age) {
		super(name,"Programmer",age,40000);
		
	}
	public void raiseSalary() {
		setSal(getSal()+3000);
	}
}
