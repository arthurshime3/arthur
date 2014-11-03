package p16_9;

import java.io.IOException;

public class StudentDataTester {

	public static void main(String[] args) throws IOException {
		StudentData test = new StudentData("ch_16/p16_9/students.bin");
		
		//StudentInfo one = new StudentInfo(123, "billy", "mandy", 3.8);
		//test.addStudent(1, one);
		
		//System.out.println(test.getSize());
		
		System.out.println(	test.getStudent(1).getFirstName());
		System.out.println(	test.getStudent(1).getLastName());
		System.out.println(	test.getStudent(1).getIdNum());
		System.out.println(	test.getStudent(1).getGPA());
		
		
//		byte[] a = ("hello").getBytes();
//		System.out.println(test.toString(a));
		
	
	}

}
