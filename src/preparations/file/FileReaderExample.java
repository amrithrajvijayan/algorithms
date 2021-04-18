package preparations.file;
import java.io.*;

public class FileReaderExample {
	
	
	
	public static void main(String args[]) {
	
		File file = null;
		BufferedReader br = null;
		
		try {
			file = new File("C:\\eclipse-workspace\\coding\\src\\input.txt");
			br = new BufferedReader(new FileReader(file));
			
			String line = null;
			do {
				
				line = br.readLine();
				if (line == null)
					break;
				System.out.println(line);
				
			} while(line != null);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
