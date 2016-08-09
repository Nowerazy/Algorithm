package action;

import java.io.*;

public class FileExample {

	public static void main(String[] args) {
		try {
			String outfile = "demoout.xml";
			String infile = "demoin.xml";

			DataOutputStream dt = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(outfile)));
			BufferedWriter NewFile = new BufferedWriter(new OutputStreamWriter(
					dt, "GBK"));
			DataInputStream rafFile1 = new DataInputStream(
					new BufferedInputStream(new FileInputStream(infile)));
			BufferedReader rafFile = new BufferedReader(new InputStreamReader(
					rafFile1, "GBK"));
			String xmlcontent ="";
			char tag =0;
			while (tag!=(char)(-1)) {
				xmlcontent=xmlcontent+tag+rafFile.readLine()+'\n';
				tag=(char)rafFile.read();
			}

			NewFile.write(xmlcontent);
			NewFile.flush();
			NewFile.close();
			rafFile.close();
			System.gc();
		} catch (NullPointerException exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch (FileNotFoundException fex) {
			// TODO: handle exception
			System.out.println("fex"+fex.getMessage());
		}catch (IOException iex) {
			// TODO: handle exception
			System.out.println("iex"+iex.getMessage());
		}

	}

}
