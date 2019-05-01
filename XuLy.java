import java.awt.image.DataBufferByte;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class XuLy {
	public void xuly(){
		try {
			long tien=0;
			//Tao reader
			FileReader f1 = new FileReader("input1.txt");
			FileReader f2 = new FileReader("input2.txt");
			BufferedReader buf1 = new BufferedReader(f1);
			BufferedReader buf2 = new BufferedReader(f2);
			//Tao writer
			FileOutputStream fw = new FileOutputStream("output.txt");
			DataOutputStream writer = new DataOutputStream(fw);
			while (true) {
				String st1 = buf1.readLine();
				String st2 = buf2.readLine();
				if(st1==""||st1==null) break;
				//Tach chuoi input1.txt
				String[] Tach1=st1.split("[;]");
				//Tach chuoi input2.txt
				String[] Tach2=st2.split("[;]");
				//Goi ham tinh tien
				long tien2 = tinhTien(Tach1[0], Tach1[3], Tach2[3]);
				//ghi file
				if(Tach2[4].equals("Binh thuong")||Tach2[4].equals("Not Available")) {
					writer.writeBytes(Tach1[0] +";"+Tach1[1]+";"+ Tach1[3]+";"+Tach2[3] +";" + tien2 +"\r\n");
					//writer2.write(Tach1[0] +";"+Tach1[1]+";"+ Tach1[3]+";"+Tach2[3] +";" + tien2 +"\n\n");
					
				
				}
					
				else {
					writer.writeBytes(Tach1[0] +";"+Tach1[1]+";"+ Tach1[3]+";"+Tach2[3] +";" +"Chua xac dinh - Dang xu ly boi thuong\r\n");
					//writer.writeChars(Tach1[0] +";"+Tach1[1]+";"+ Tach1[3]+";"+Tach2[3] +";" + "Chua xac dinh - Dang xu ly boi thuong");
					
				}
					
				}
			
			f1.close();
			f2.close();
			buf1.close();
			buf2.close();
			writer.close();
			fw.close();
			System.out.println("Done.");
		}	catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//Tinh tien gui xe 
	public long tinhTien(String loaixe,String vao,String ra) throws ParseException {
		//Tao formatter
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm dd/MM/yyyy");
		//Chuyen du lieu tu String sang Date
		Date dvao = formatter.parse(vao);
		Date dra = formatter.parse(ra);
		long tien = 0;
		double tg4 =0.0;
		double tg20 =0.0;
		if(loaixe.equals("4")) {
			//Tien = (0.5h)*5000
			tg4=(dra.getTime()-dvao.getTime())/(double)3600000;
			tg4/=0.5;
			if(tg4%0.5>0) {
				tg4 = (tg4-(tg4%0.5))+0.5;
			}
			tien = (long)(tg4)*5000;
			return tien;
		}
		else if(loaixe.equals("2")) {
			//tien = 1d*3000
			long miliGiay1Ngay = 24*60*60*1000;
			tg20=(dra.getTime()-dvao.getTime())/(double)miliGiay1Ngay;
			if(tg20>(long)tg20) {
				tg20=(long)tg20+1;
			}
			tien = (long)(tg20)*3000;
			return tien;
		}
		else {
			//tien = 1d*1000
			long miliGiay1Ngay = 24*60*60*1000;
			tg20=(dra.getTime()-dvao.getTime())/(double)miliGiay1Ngay;
			if(tg20>(long)tg20) {
				tg20=(long)tg20+1;
			}
			tien = (long)(tg20)*1000;
			return tien;
		}
	}
}
