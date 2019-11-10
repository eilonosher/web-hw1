package h;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScreenColors {
	private FileWriter  file;
	public ScreenColors() throws IOException {
		file = new FileWriter("index.html");
	}

	public void draw() throws IOException {
		writePrefixData();
		Scanner sc = new Scanner(System.in);
		System.out.println("please insert a number between 1-50");
		String selectNumber = sc.next();
		int result = 0;
		try {
			result = Integer.parseInt(selectNumber);
			if(result > 50 || result <1) {
				System.out.println("invalid number");
				return;
			}
		}catch (NumberFormatException e) {
			System.out.println("invalid number");
			return;
		}
		columnDrawing(result);
		writeEndData();
		file.close();

	}

	private void columnDrawing(int result) throws IOException {
		for (int i = 0; i < result; i++) {
			int modeNumber = i % 3;
			switch (modeNumber) {
			case 0:
				file.write("\t\t\t\t\t\t\t<td style=\"height: 100vh;background-color: blue;\"></td>"+"\r\n");
				break;
			case 1:
				file.write("\t\t\t\t\t\t\t<td style=\"height: 100vh;background-color:red;\"></td>"+"\r\n");
				break;
			case 2:
				file.write("\t\t\t\t\t\t\t<td style=\"height: 100vh;background-color: green;\"></td>"+"\r\n");
				break;

			default:
				break;
			}
		}

	}

	private void writePrefixData() throws IOException {
		file.write("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"    <head>\r\n" + 
				"	<title>\r\n" + 
				"        hw q1\r\n" + 
				"    </title>\r\n" + 
				"	</head>\r\n" + 
				"     <body style=\"overflow:hidden;width:100%;margin:0; padding:0\">\r\n" + 
				"            <table style=\"width: 100%; border-collapse: collapse;\">\r\n" + 
				"                    <thead>\r\n" + 
				"                        <tr>\r\n" + 
				"                            <th></th>\r\n" + 
				"                        </tr>\r\n" + 
				"                    </thead>\r\n" + 
				"                    <tbody>\r\n" + 
				"                        <tr>\r\n");
	}

	private void writeEndData() throws IOException {
		file.write("\t\t\t\t\t\t</tr>\r\n" + 
				"                    </tbody>\r\n" + 
				"            </table>\r\n" + 
				"     </body>\r\n" + 
				"</html>");
	}



	public static void main(String[] args) {
		try {
			ScreenColors screenColors = new ScreenColors();
			screenColors.draw();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}