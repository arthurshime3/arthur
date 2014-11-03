package p16_9;

import java.io.IOException;
import java.io.RandomAccessFile;

public class StudentData 
{
	private RandomAccessFile file;
	private final int ID_SIZE = 4, FIRST_NAME_SIZE = 20, LAST_NAME_SIZE = 20, GPA_SIZE = 8;
	private final int SIZE = ID_SIZE + FIRST_NAME_SIZE + LAST_NAME_SIZE + GPA_SIZE;
	
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
		byte[] fName = new byte[20];
		byte[] f = student.getFirstName().getBytes();
		byte[] lName = new byte[20];
		byte[] l = student.getLastName().getBytes();
		
		System.arraycopy(f, 0, fName, 0, f.length);
		System.arraycopy(l, 0, lName, 0, l.length);
		file.write(fName);
		file.write(lName);
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
		byte[] a = new byte[FIRST_NAME_SIZE];
		byte[] b = new byte[LAST_NAME_SIZE];
		file.read(a);
		file.read(b);
		double gpa = file.readDouble();
		
		String first = toString(a);
		String last = toString(b);
		
		
		return new StudentInfo(id, first, last, gpa);
	}
	
	/**
	 * Closes the file
	 * @throws IOException
	 */
	public void close() throws IOException
	{
		file.close();
	}
	
//	/**
//	 * Returns the location of a student's info given an id number
//	 * @param idNum id number of student info to be found
//	 * @return location of student info; -1 if not found
//	 * @throws IOException
//	 */
//	public int find(int idNum) throws IOException
//	{
//		for (int x = 0; x < getSize(); x++)
//		{
//			file.seek(x * SIZE);
//			
//			int y = file.readInt();
//			System.out.println(y);
//			if (idNum ==y)
//				return x;
//		}
//		
//		return -1;
//	}
//	
	/**
	 * Gets the size of the file
	 * @return size of file
	 * @throws IOException
	 */
	public int getSize() throws IOException
	{
		return (int)(file.length() / SIZE);
	}
	
	/**
	 * Converts a byte array to a string
	 * @param a
	 * @return string form of given byte array
	 */
	public String toString(byte[] a)
	{
		String word = "";
		for (int x = 0; x < a.length; x++)
		{
			word += (char)(a[x]);
		}
		return word;
	}
}
