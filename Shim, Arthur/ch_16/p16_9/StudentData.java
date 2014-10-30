package p16_9;

import java.io.IOException;
import java.io.RandomAccessFile;

public class StudentData 
{
	private RandomAccessFile file;
	private int ID_SIZE = 1, FIRST_NAME_SIZE = 20, LAST_NAME_SIZE = 20, GPA_SIZE = 8;
	private int SIZE = ID_SIZE + FIRST_NAME_SIZE + LAST_NAME_SIZE + GPA_SIZE;
	
	/**
	 * Opens a random access file with the given path
	 * @param f file path
	 * @throws IOException
	 */
	public StudentData(String f) throws IOException
	{
		file = new RandomAccessFile(f, "rw");
	}
	
	/**
	 * Adds a student's info to the file
	 * @throws IOException 
	 */
	public void addStudent(int n, StudentInfo student) throws IOException
	{
		file.seek(n * SIZE);
		file.writeInt(student.getIdNum());
		file.writeChars("" + '\n');
		file.writeChars(student.getFirstName() + '\n');
		file.writeChars(student.getLastName() + '\n');
		file.writeDouble(student.getGPA());

	}
	
	/**
	 * Gets student info from the file at n
	 * @param n 
	 * @return
	 * @throws IOException 
	 */
	public StudentInfo getStudent(int n) throws IOException
	{
		file.seek(n * SIZE);
		int id = file.readInt();
		file.readLine();
		String first = file.readLine();
		String last = file.readLine();
		double gpa = file.readDouble();
		
		return new StudentInfo(id, first, last, gpa);
	}
	
	/**
	 * Closes the file
	 * @throws IOException
	 */
	public void closeFile() throws IOException
	{
		file.close();
	}
	
	/**
	 * Returns the location of a student's info given an id number
	 * @param idNum id number of student info to be found
	 * @return location of student info; -1 if not found
	 * @throws IOException
	 */
	public int find(int idNum) throws IOException
	{
		for (int x = 0; x < getSize(); x++)
		{
			file.seek(x * SIZE);
			
			if (idNum == file.readInt())
				return x;
		}
		
		return -1;
	}
	
	/**
	 * Gets the size of the file
	 * @return size of file
	 * @throws IOException
	 */
	public int getSize() throws IOException
	{
		return (int)(file.length() / SIZE);
	}
}
