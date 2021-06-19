package preparations.file;
import java.io.*;

public class FileInputStreamExample {
	
	public static void main(String[] args) {
		
		String fileName = "C:\\eclipse-workspace\\coding\\src\\input.txt";
		
		try {
			FileInputStream inputStream = new FileInputStream(fileName);
			
			int c;
			while((c = inputStream.read()) != -1) {
				System.out.print((char)c);
			}
			
			inputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
