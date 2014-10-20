package p16_9;

import java.io.IOException;
import java.io.RandomAccessFile;

public class StudentData 
{
	private String path;
	private RandomAccessFile file;
	private int ID_SIZE = 1, FIRST_NAME_SIZE = 20, LAST_NAME_SIZE = 20, GPA_SIZE = 8;
	private int RECORD_SIZE = ID_SIZE + FIRST_NAME_SIZE + LAST_NAME_SIZE + GPA_SIZE;
	
	/**
	 * Opens a random access file with the given path
	 * @param f file path
	 * @throws IOException
	 */
	public StudentData(String f) throws IOException
	{
		path = f;
		file = new RandomAccessFile(path, "rw");
	}
	
	/**
	 * Adds a student's info to the file
	 * @throws IOException 
	 */
	public void addStudent(int n, StudentInfo student) throws IOException
	{
		file.seek(n * RECORD_SIZE);
		file.writeInt(student.getIdNum());
		file.writeChars(student.getFirstName());
		file.writeChars(student.getLastName());
		file.writeDouble(student.getGpa());
	}
	
	/**
	 * Gets student info from the file at n
	 * @param n 
	 * @return
	 * @throws IOException 
	 */
	public StudentInfo getStudent(int n) throws IOException
	{
		file.seek(n * RECORD_SIZE);
		int id = file.readInt();
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
}
