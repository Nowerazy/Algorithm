package action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateInstance {

	public static void main(String[] args)throws Exception {
		
		//几种日期格式化格式  
        SimpleDateFormat format;
        SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd hh-mm-ss a",Locale.ENGLISH);
//        format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//    	format = new SimpleDateFormat("GGG yyyy/MMM/d aa hh:mm");
        //G表示“公元”两个字。
//    	format = new SimpleDateFormat("yyyy/MMM/d G 'at' aa HH:mm:ss z");
        //MMM是中文的月，MM是只有数字。EE表示星期几。dd是表示不足两位前加0，d是不加零。
    	format = new SimpleDateFormat("EE, MMM d, ''yyy");
    	//a是中文上下午标记，aa是英文的。
//    	format = new SimpleDateFormat("hh 'o''clock' a,zzzz");
//    	format = new SimpleDateFormat("yyMMddHHmmssZ");
    	
        //Data 的格式化输出
        Date d=new Date(); 
        System.out.println("今天的日期："+format.format(d));
        System.out.println("两天前的日期：" + format.format(new Date(d.getTime() - (long)2 * 24 * 60 * 60 * 1000)));  
        System.out.println("三天后的日期：" + format.format(new Date(d.getTime() + (long)3 * 24 * 60 * 60 * 1000)));
        System.out.println("---------------------------------------");

        //Calendar的使用方式
        Calendar cal = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。    
        cal.add(Calendar.DAY_OF_MONTH, -1);//获得当前日期的前一天.
//      cal.add(Calendar.DAY_OF_MONTH, +1);//获得当前日期的后一天.
        
        //通过格式化输出日期
        System.out.println("Today is:"+format.format(Calendar.getInstance().getTime()));    
        System.out.println("yesterday is:"+format.format(cal.getTime()));
        System.out.println("---------------------------------------");
        
        //自定义日期
        Calendar calendar = new GregorianCalendar(2007, 11, 25,0,0,0);
        Date date = calendar.getTime();
        System.out.println("2007 圣诞节日期是: "+format.format(date));   
        System.out.println("---------------------------------------");
        //另一种日期定义
        String cdateString= "2015-10-02 10-20-30 am";
        try {
    		Date date2 	=dateFormat.parse(cdateString);//
    		System.out.println(date2);
    	} catch (IndexOutOfBoundsException | NumberFormatException e) {
    		e.printStackTrace();
    	}
        //取日期的部分:
        int year =calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;//日历型日期的月份要+1。0代表1月份
        int day =calendar.get(Calendar.DAY_OF_MONTH);    
        int hour =calendar.get(Calendar.HOUR_OF_DAY);    
        int minute =calendar.get(Calendar.MINUTE);    
        int seconds =calendar.get(Calendar.SECOND);  
        
        //当前月份的最大天数:
        Calendar ca = Calendar.getInstance();  
        int day1=ca.getActualMaximum(Calendar.DAY_OF_MONTH);    
        System.out.println(day1);
	}
	
}
