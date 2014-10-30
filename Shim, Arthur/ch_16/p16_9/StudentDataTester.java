package p16_9;

import java.io.IOException;

public class StudentDataTester {

	public static void main(String[] args) throws IOException {
		StudentData test = new StudentData("H:/random files/output.bin");
		StudentInfo one = new StudentInfo(123, "billy", "mandy", 3.8);
		test.addStudent(1, one);
		//System.out.println(test.getSize());
		System.out.println(	test.getStudent(test.find(123)).getFirstName());
		System.out.println(	test.getStudent(test.find(123)).getLastName());
		System.out.println(	test.getStudent(test.find(123)).getGPA());
	}

}
