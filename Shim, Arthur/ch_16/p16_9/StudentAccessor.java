package p16_9;
import java.io.IOException;
import java.util.Scanner;
public class StudentAccessor {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		
		boolean done = false, fileFound = false;
		int choice = 0, pos = 0;
		StudentData data = null;
		StudentInfo student = null;
		
		while (!fileFound)
		{
			System.out.println("Enter file path");
			try {
				data = new StudentData(k.nextLine());
				fileFound = true;
			} catch (IOException e) {
				System.out.println("File was not found");
			}
		}
		
		
		while (!done)
		{
			showOptions();
			choice = k.nextInt();
			
			switch(choice)
			{
			case 1:
				int id = getID();
				double gpa = getGPA();
				k.nextLine();
				String firstName = getFirstName();
				String lastName = getLastName();
				try 
				{
					data.addStudent(data.getSize(), new StudentInfo(id, firstName, lastName, gpa));
				} catch (IOException e) {
					System.out.println("File was not found");
				}
				break;
				
			case 2:
				try 
				{
					student = getStudent(data);
				} 
				catch (IOException e) 
				{
					System.out.println("File was not found");
				}
				System.out.println("ID Number: " + student.getIdNum());
				System.out.println("First Name: " + student.getFirstName());
				System.out.println("Last Name: " + student.getLastName());
				System.out.println("GPA: " + student.getGPA());
				break;
				
			case 3:
				try 
				{
					student = getStudent(data);
				} 
				catch (IOException e) 
				{
					System.out.println("File was not found");
				}
				System.out.println("First Name: " + student.getFirstName());
				break;
				
			case 4:
				try 
				{
					student = getStudent(data);
				} 
				catch (IOException e) 
				{
					System.out.println("File was not found");
				}
				System.out.println("Last Name: " + student.getLastName());
				break;
				
			case 5:
				try 
				{
					student = getStudent(data);
				} 
				catch (IOException e) 
				{
					System.out.println("File was not found");
				}
				System.out.println("GPA: " + student.getGPA());
				break;
				
			case 6:
				try
				{
					pos = getPos(data);
					student = getStudentWithPos(data, pos);
					System.out.println("Enter student's first name");
					student.setFirstName(k.nextLine());
					data.addStudent(pos, student);
				}
				catch (IOException e) 
				{
					System.out.println("File was not found");
				}
				break;
				
			case 7:
				try
				{
					pos = getPos(data);
					student = getStudentWithPos(data, pos);
					System.out.println("Enter student's last name");
					student.setLastName(k.nextLine());
					data.addStudent(pos, student);
				}
				catch (IOException e) 
				{
					System.out.println("File was not found");
				}
				break;
				
			case 8:
				try
				{
					pos = getPos(data);
					student = getStudentWithPos(data, pos);
					System.out.println("Enter student's GPA");
					student.setGPA(k.nextDouble());
					data.addStudent(pos, student);
				}
				catch (IOException e) 
				{
					System.out.println("File was not found");
				}

				break;
				
			case 9:
				done = true;
				break;
				
			default:
				System.out.println("Invalid option");
				break;
			}
		}
		
		k.close();
	}
	
	public static void showOptions()
	{
		System.out.println("1: Enter a student's info");
		System.out.println("2: Get a student's info");
		System.out.println("3: Get a student's first name");
		System.out.println("4: Get a student's last name");
		System.out.println("5: Get a student's GPA");
		System.out.println("6: Update a student's first name");
		System.out.println("7: Update a student's last name");
		System.out.println("8: Update a student's GPA");
		System.out.println("9: Quit");
	}
	
	//
	public static int getID()
	{
		Scanner k = new Scanner(System.in);
		System.out.println("Enter student id");
		int id = 0;
		try{
			id = k.nextInt();
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("That's not a valid student id");
		}
		
		k.close();
		return id;
	}
	
	public static String getFirstName()
	{
		Scanner k = new Scanner(System.in);
		System.out.println("Enter student's first name");
		String name = k.nextLine();
		k.close();
		return name;
	}
	
	public static String getLastName()
	{
		Scanner k = new Scanner(System.in);
		System.out.println("Enter student's last name");
		String name = k.nextLine();
		k.close();
		return name;
	}
	
	public static double getGPA()
	{
		Scanner k = new Scanner(System.in);
		System.out.println("Enter student gpa");
		double gpa = 0;
		try{
			gpa = k.nextDouble();
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("That's not a valid GPA");
		}
		
		k.close();
		return gpa;
	}
	
	public static StudentInfo getStudent(StudentData data) throws IOException
	{
		return data.getStudent(getPos(data));
	}
	
	public static StudentInfo getStudentWithPos(StudentData data, int pos) throws IOException
	{
		return data.getStudent(pos);
	}
	
	public static int getPos(StudentData data) throws IOException
	{
		return data.find(getID());
	}
}
