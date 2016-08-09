package FileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileRW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strings={"nihao","zhaijian","buhaoyishi","huanyinguangli"};
		try {
			PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("people.dat")));
			out.println("ty"+"w");
			for (String string : strings) {
			out.write(string);
			}
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}

}
