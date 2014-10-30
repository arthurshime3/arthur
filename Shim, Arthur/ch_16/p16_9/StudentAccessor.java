package p16_9;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentAccessor {
	
	private static Scanner k = new Scanner(System.in);
	public static void main(String[] args) {
		//	H:/random files/output.bin
		
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
				
				if (id != 0)
				{
					double gpa = getGPA();
					k.nextLine();
					String firstName = getFirstName();
					String lastName = getLastName();
					try 
					{
						data.addStudent(data.getSize() + 1, new StudentInfo(id, firstName, lastName, gpa));
					} catch (IOException e) {
						System.out.println("File was not found");
					}
				}
				else
					System.out.println("That student was not found");
				
				break;
				
			case 2:
				try 
				{
					student = getStudent(data);
					
					if (student != null)
					{
						System.out.println("ID Number: " + student.getIdNum());
						System.out.println("First Name: " + student.getFirstName());
						System.out.println("Last Name: " + student.getLastName());
						System.out.println("GPA: " + student.getGPA());
					}
					else
						System.out.println("That student was not found");
				} 
				catch (IOException e) 
				{
					System.out.println("File was not found");
				}
			
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
				
				if (student != null)
					System.out.println("First Name: " + student.getFirstName());
				else
					System.out.println("That student was not found");
				
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
				
				if (student != null)
					System.out.println("Last Name: " + student.getLastName());
				else
					System.out.println("That student was not found");
				
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
				if (student != null)
					System.out.println("GPA: " + student.getGPA());
				else
					System.out.println("That student was not found");
				
				break;
				
			case 6:
				try
				{
					pos = getPos(data);
					
					if (pos > 0)
					{
						student = getStudentWithPos(data, pos);
						System.out.println("Enter student's first name");
						k.nextLine();
						student.setFirstName(k.nextLine());
						data.addStudent(pos, student);
					}
					else
						System.out.println("That student was not found");
										
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
					
					if (pos > 0)
					{
						student = getStudentWithPos(data, pos);
						System.out.println("Enter student's last name");
						k.nextLine();
						student.setLastName(k.nextLine());
						data.addStudent(pos, student);
					}
					else
						System.out.println("That student was not found");
										
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
					
					if (pos > 0)
					{
						student = getStudentWithPos(data, pos);
						System.out.println("Enter student's GPA");
						student.setGPA(k.nextDouble());
						data.addStudent(pos, student);
					}
					else
						System.out.println("That student was not found");
						
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
		System.out.println("Enter student id");
		int id = 0;
		try{
			id = k.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("That's not a valid student id");
		}
		
		return id;
	}
	
	public static String getFirstName()
	{

		System.out.println("Enter student's first name");
		String name = k.nextLine();

		return name;
	}
	
	public static String getLastName()
	{

		System.out.println("Enter student's last name");
		String name = k.nextLine();

		return name;
	}
	
	public static double getGPA()
	{

		System.out.println("Enter student gpa");
		double gpa = 0;
		try{
			gpa = k.nextDouble();
		}
		catch(InputMismatchException e)
		{
			System.out.println("That's not a valid GPA");
		}
		

		return gpa;
	}
	
	public static StudentInfo getStudent(StudentData data) throws IOException
	{
		int pos = getPos(data);
		if (pos < 0)
			return null;
		return data.getStudent(pos);
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
