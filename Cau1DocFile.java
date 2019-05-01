import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Cau1DocFile {
	public void docfile() throws IOException{
		try {
			//Mo file
			FileReader f = new FileReader("input1.txt");
			BufferedReader doc = new BufferedReader(f);
			
			//Doc file
			while(true) {
				String st = doc.readLine();
				if(st==null ||st=="") 
					break;
				System.out.println(st);
			}
			//dong file
			doc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void docfile2() throws IOException{
		try {
			//Mo file
			FileReader f = new FileReader("input2.txt");
			BufferedReader doc = new BufferedReader(f);
			
			//Doc file
			while(true) {
				String st = doc.readLine();
				if(st==null ||st=="") 
					break;
				System.out.println(st);
			}
			//dong file
			doc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
