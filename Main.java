import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Cau1DocFile c1 = new Cau1DocFile();
		//cau 1
		c1.docfile();
		System.out.println("-----------------------------------------");
		//cau 2
		c1.docfile2();
		//Xu ly cau 3
		System.out.println("-----------------------------------------");
		XuLy xl = new XuLy();
		xl.xuly();
	}

}
