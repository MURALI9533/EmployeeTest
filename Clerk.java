package emptest;
public final class Clerk extends Employee {
	Clerk(){}
	public Clerk(String name, int age) {
		super(name,"Clerk",age,20000);
	}
	public void raiseSalary() {
		setSal(getSal()+1000);
	}	
}
