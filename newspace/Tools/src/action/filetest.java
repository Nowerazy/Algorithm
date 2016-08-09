package action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class filetest{
	
public static void main(String[] args)throws Exception {
	String string="f2147YGU就见对是见将看方";
	char[] sb=string.toCharArray();
	int digitnum=0,letternum=0,hannum=0;
	for (int i = 0; i < sb.length; i++) {
		if ((sb[i]>'a'&&sb[i]<'z')||(sb[i]>'A'&&sb[i]<'Z')) {
			letternum++;
			continue;
		}
		if (sb[i]>='0'&&sb[i]<='9') {
			digitnum++;
			continue;
		}
		if((sb[i] >='\u4e00'&& sb[i] <= '\u9fa5')||(sb[i] >= '\uf900' && sb[i] <='\ufa2d')) {
			hannum++;
			continue;
		}
		
	}
	Character.UnicodeBlock iCharacter =Character.UnicodeBlock.of(sb[4]);
	System.out.println("数字有："+digitnum);
	System.out.println("汉字有："+hannum);
	System.out.println("字母有："+letternum);
//	File dir = new File("c:\\q\\3\\r");
//	dir.mkdir();
//	ObjectOutputStream tr=new ObjectOutputStream(new FileOutputStream(dir));
//	ObjectInputStream te=new ObjectInputStream(new FileInputStream(dir));
//	tr.writeObject(dir);
//	try {
//		String[] ty=(String[])te.readObject();
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
	
}
}
