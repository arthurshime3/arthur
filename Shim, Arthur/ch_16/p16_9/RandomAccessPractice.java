package p16_9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class RandomAccessPractice {

	public static void main(String[] args) throws FileNotFoundException {
		//System.out.println(args[0]);
		
		Scanner k = new Scanner(System.in);
		
		System.out.println("Enter:");
		int num = k.nextInt();
		
		FileOutputStream out = new FileOutputStream("H:/random files/" + num + ".bin");
		FileInputStream input = new FileInputStream(args[0] + ".bin");
	}

}
