package action;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tips {
	public static void main(String[] args) {
		// 获取输入，内容分割符设置
		// Scanner sc = new Scanner(System.in);
		// System.out.println("请输入n与m，用空格分隔。");
		// //sc.useDelimiter("\n");
		// while (sc.hasNext()) {
		// System.out.println("输入内容为："+sc.next());
		// }

		/*
		 * 正则表达式应用教程-------------↘↘↘↘↘↘↘↘↘
		 */
		/*
		 * // 使用正则匹配的正确姿势 Pattern p = null; // 正则表达式 Matcher m = null; // 操作的字符串
		 * boolean b = false; String str = "Gar0T94_jHiaGjb5fd-_htrhKfgnJg";
		 * StringBuffer sBuffer = new StringBuffer("Bufferme"); // 匹配的正则表达式 //
		 * 方括号中不同匹配字符的间隔可以用“，”，也可以直接什么也不要。 // 正则表达式表示汉字的一串字符串 // p =
		 * Pattern.compile("^[\u4e00-\u9fa5]+$"); p =
		 * Pattern.compile("[a-zA-Z][a-zA-Z_0-9]{2,4}[A-Z]"); // p =
		 * Pattern.compile("a\\w*b");
		 * 
		 * // 进行匹配 m = p.matcher(str); int i = 0;
		 * 
		 * // 经过多次匹配，匹配替换后的整个字符串内容添加到sBuffer之后 while (m.find()) {
		 * System.out.println("第" + i + "次匹配的位置是" + m.start());
		 * 
		 * // 返回被匹配的字符串 System.out.println(m.group());
		 * m.appendReplacement(sBuffer.append("|||"), "*此位置被置换*"); i++; //
		 * 字符串出现次数 }
		 * 
		 * // 将剩余未匹配的字符加入到sBuffer的尾部 // m.appendTail(sBuffer);
		 * 
		 * // 将匹配的内容进行替换 String string = m.replaceAll("哇哈哈");
		 * System.out.println(string + "   " + sBuffer); b = m.lookingAt();
		 * System.out.println(b); String[] strings = p.split(str);
		 * System.out.println(Arrays.asList(strings).toString());
		 * 
		 * 
		 * 
		 * /* 正则表达式应用教程---------------------↗↗↗↗↗↗↗
		 */

		
		/*
		 * treemap自动根据关键字排序 实现的是红黑树排序
		 */

		// 不指定排序器
		TreeMap<String, String> treeMap1 = new TreeMap<String, String>();
		treeMap1.put("2", "1");
		treeMap1.put("b", "1");
		treeMap1.put("1", "1");
		treeMap1.put("a", "1");
		System.out.println("treeMap1=" + treeMap1);

		// 指定排序器
		TreeMap<String, String> treeMap2 = new TreeMap<String, String>(
				new Comparator<String>() {

					/*
					 * int compare(Object o1, Object o2) 返回一个基本类型的整型， 返回负数表示：o1
					 * 小于o2， 返回0 表示：o1和o2相等， 返回正数表示：o1大于o2。
					 */
					public int compare(String o1, String o2) {

						// 指定排序器按照降序排列
						return o2.compareTo(o1);
					}
				});
		treeMap2.put("2", "1");
		treeMap2.put("b", "1");
		treeMap2.put("1", "1");
		treeMap2.put("a", "1");
		System.out.println("treeMap2=" + treeMap2);
		/*
		 * treemap
		 */

		/*
		 * 小数处理，如何四舍五入
		 */
//		String latitude ="30.226809";
//		String longitude ="120.031403";
//java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.000000");
//		double lat = Double.parseDouble(latitude);
//		double lng = Double.parseDouble(longitude);
//		double lng1=Double.parseDouble(myformat.format(lng-0.002373));
//		double lat1=Double.parseDouble(myformat.format(lat+0.004754));
//		String latString = Double.toString(lat1);
//		String lngString = Double.toString(lng1);
//		
//		System.out.println(lng);
//		System.out.println(lat);
//		System.out.println(lng1);
//		System.out.println(lat1);
		
		
	}
}
