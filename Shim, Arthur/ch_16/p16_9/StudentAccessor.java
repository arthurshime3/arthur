package p16_9;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentAccessor {
	
	private static Scanner k = new Scanner(System.in);
	public static void main(String[] args) 
	{
		//	H:/random files/output.bin
		//  ch_16/p16_9/students.bin
		
		boolean done = false, fileFound = false;
		int choice = 0, pos = 0;
		StudentData data = null;
		StudentInfo student = null;
		
		while (!fileFound)
		{
			System.out.println("Enter file path (ex. ch_16/p16_9/students.bin)");
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
			try
			{
			choice = k.nextInt();
			
			switch(choice)
			{
			//add student
			case 1:
				int id = getID();
				String firstName = getFirstName();
				String lastName = getLastName();
				double gpa = getGPA();
				try 
				{
					if (data.getSize() == 0)
						data.addStudent(1, new StudentInfo(id, firstName, lastName, gpa));
					else
						data.addStudent(data.getSize(), new StudentInfo(id, firstName, lastName, gpa));
				} 
				catch (IOException e) 
				{
					System.out.println("File was not found");
				}
		
			break;
			
			//get student info
			case 2:
				try 
				{
					student = getStudent(data, getPos());
					
					if (student != null)
					{
						System.out.println("ID Number: " + student.getIdNum());
						System.out.println("First Name: " + student.getFirstName());
						System.out.println("Last Name: " + student.getLastName());
						System.out.println("GPA: " + student.getGPA());
					}
						
				} 
				catch (IOException e) 
				{
					System.out.println("That student was not found");
				}
			
				break;
			
			//get first name
			case 3:
				try 
				{
					student = getStudent(data, getPos());
					
					if (student != null)
						System.out.println("First Name: " + student.getFirstName());
					
				} 
				catch (IOException e) 
				{
					System.out.println("That student was not found");
				}
				
				break;
			
			//get last name
			case 4:
				try 
				{
					student = getStudent(data, getPos());
					
					if (student != null)
						System.out.println("Last Name: " + student.getLastName());
				} 
				catch (IOException e) 
				{
					System.out.println("That student was not found");
				}
				
				break;
				
			//get id
			case 5:
				try 
				{
					student = getStudent(data, getPos());
					
					if (student != null)
						System.out.println("GPA: " + student.getIdNum());
				} 
				catch (IOException e) 
				{
					System.out.println("That student was not found");
				}

				break;
				
			//get gpa
			case 6:
				try 
				{
					student = getStudent(data, getPos());
					
					if (student != null)
						System.out.println("GPA: " + student.getGPA());
				} 
				catch (IOException e) 
				{
					System.out.println("That student was not found");
				}
		
				break;
			
			//update first name
			case 7:
				try
				{
					pos = getPos();
					student = getStudent(data, pos);
					
					System.out.println("Enter student's first name");
					student.setFirstName(k.nextLine());
					data.addStudent(pos, student);
														
				}
				catch (IOException e) 
				{
					System.out.println("That student was not found");
				}
				break;
			
			//update last name
			case 8:
				try
				{
					pos = getPos();
					student = getStudent(data, pos);
					
					System.out.println("Enter student's last name");
					student.setLastName(k.nextLine());
					data.addStudent(pos, student);
														
				}
				catch (IOException e) 
				{
					System.out.println("That student was not found");
				}
				break;
			
			//update id number
			case 9:
				try
				{
					pos = getPos();
					student = getStudent(data, pos);
					
					System.out.println("Enter student's id number");
					student.setIdNum(k.nextInt());
					data.addStudent(pos, student);
					k.nextLine();
				}
				catch (IOException e) 
				{
					System.out.println("That student was not found");
				}
				break;
			
			//update gpa
			case 10:
				try
				{
					pos = getPos();
					student = getStudent(data, pos);
					
					System.out.println("Enter student's gpa");
					student.setGPA(k.nextDouble());
					data.addStudent(pos, student);
					k.nextLine();									
				}
				catch (IOException e) 
				{
					System.out.println("That student was not found");
				}
				break;
			
			//exit
			case 11: 
				done = true;
				break;
				
			default:
				System.out.println("Invalid option");
				break;
			}
			}
		
			catch(InputMismatchException e)
			{
				System.out.println("That's not a valid input");
				k.nextLine();
			}

		}
		
		try 
		{
			data.close();
		} catch (IOException e)
		{
			System.out.println("File missing");
		}
		
		k.close();
	}
	
	public static void showOptions()
	{
		System.out.println("1: Enter a student's info");
		System.out.println("2: Get a student's info");
		System.out.println("3: Get a student's first name");
		System.out.println("4: Get a student's last name");
		System.out.println("5: Get a student's id");
		System.out.println("6: Get a student's GPA");
		System.out.println("7: Update a student's first name");
		System.out.println("8: Update a student's last name");
		System.out.println("9: Update a student's id");
		System.out.println("10: Update a student's GPA");
		System.out.println("11: Quit");
	}
	
	
	public static int getID()
	{
		System.out.println("Enter student id");
		int id = -1;
		
		while (id == -1)
		{
			try{
				id = k.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("That's not a valid student id");
			}
			k.nextLine();
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
		double gpa = -1;
		
		while (gpa == -1)
		{
			try{
				gpa = k.nextDouble();
			}
			catch(InputMismatchException e)
			{
				System.out.println("That's not a valid GPA");
			}
			k.nextLine();
		}
		

		return gpa;
	}
	
	public static StudentInfo getStudent(StudentData data, int pos) throws IOException
	{
		return data.getStudent(pos);
	}
	
	/**
	 * Returns the number of the student being accessed
	 * @return position of student being accessed
	 */
	public static int getPos() 
	{	
		int pos = -1;
		while (pos == -1)
		{
			System.out.println("Enter the number of the student you would like to get (i.e. 1 for the first student, 2 for the second, etc");
		
			try
			{
				pos = k.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.out.println("That is not a valid number");
			}
			k.nextLine();
		}
		
		return pos;
	}
}
