package p16_9;

public class StudentInfo {
	
	private String firstName, lastName;
	private int idNum;
	private double gpa;
	
	public StudentInfo(int n, String f, String l, double g)
	{
		idNum = n;
		firstName = f;
		lastName = l;
		gpa = g;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
}
