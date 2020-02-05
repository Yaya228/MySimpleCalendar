package MyCalenday;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class VisableCalendar {
	public static String str;
	public static void main(String[] args) throws Exception {
		System.out.println("请输入日期（格式为：2010-3-3）：");//从键盘读取日期
		Scanner scanner=new Scanner(System.in);
		str=scanner.nextLine();
		System.out.println("您刚刚输入的日期是：" + str);
		scanner.close();
		/**
		 * String[] str = dateString.split("-"); //不需要经过DateFormat的转换  直接将字符串分隔
        int year = Integer.parseInt(str[0]);
        int month = new Integer(str[1]);
        int day = new Integer(str[2]);
        Calendar c = new GregorianCalendar(year, month - 1, day); // Month:0-11
		 */
		
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd"); //将从键盘获得的string类型 转换成固定格式的DATE
		Date dt=df.parse(str);
		
		Calendar c1=new GregorianCalendar();  //将DATE 转换成Calendar类型
		c1.setTime(dt);     //c1用于打印
		Calendar c2=new GregorianCalendar();
		c2.setTime(dt); //c2用于计算日长
		
		printCalendar(c1);
		System.out.println();
		DaysBetwoon(c2);
	}
	public static void printCalendar(Calendar c) throws ParseException {
		int day=c.get(Calendar.DAY_OF_MONTH);  //获得用户输入的日期 以便后面添加*
		System.out.println("日\t一\t二\t三\t四\t五\t六"); //打印 星期几
		
		c.set(Calendar.DAY_OF_MONTH, 1);       // 将日期设置为1    从这个月第一天开始打印  
		for(int i=0;i<c.get(Calendar.DAY_OF_WEEK)-1;i++) {   //打印1号是星期几之前的空格
			System.out.print("\t");
		}
		
		int maxday=c.getActualMaximum(Calendar.DATE);  //获取这个月 最大的天数
		for(int i=1;i<=maxday;i++) {
			System.out.print(c.get(Calendar.DAY_OF_MONTH)+(i==day?"*\t":"\t"));//这一天  是用户输入的日期 加*
			if(c.get(Calendar.DAY_OF_WEEK)==7) {         //每逢周六 换行
				System.out.println();
			}
			c.add(Calendar.DAY_OF_MONTH, 1);       //日期加1
		}
	}
	public static void DaysBetwoon(Calendar c1) throws ParseException {
		Calendar c2=new GregorianCalendar(); //获取当前时间

		long time1=c1.getTimeInMillis();
		long time2=c2.getTimeInMillis();
		long between_days=(time1-time2)/(1000*3600*24);
		if(between_days<0) {
			between_days=-between_days;
		}else {
			between_days++;
		}
		System.out.println("今天距离您输入的日期还有:"+between_days+"天.");
	}

}
