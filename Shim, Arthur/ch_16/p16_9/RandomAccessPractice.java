package p16_9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomAccessPractice {

	public static void main(String[] args) throws FileNotFoundException {
		//System.out.println(args[0]);
		
		Scanner k = new Scanner(System.in);
		
//		FileOutputStream out = new FileOutputStream("H:/random files/" + num + ".bin");
//		FileInputStream input = new FileInputStream(args[0] + ".bin");
		
		RandomAccessFile f = new RandomAccessFile("bank.dat", "rw");
	}

}
