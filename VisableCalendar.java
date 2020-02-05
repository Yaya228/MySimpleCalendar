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
		System.out.println("���������ڣ���ʽΪ��2010-3-3����");//�Ӽ��̶�ȡ����
		Scanner scanner=new Scanner(System.in);
		str=scanner.nextLine();
		System.out.println("���ո�����������ǣ�" + str);
		scanner.close();
		/**
		 * String[] str = dateString.split("-"); //����Ҫ����DateFormat��ת��  ֱ�ӽ��ַ����ָ�
        int year = Integer.parseInt(str[0]);
        int month = new Integer(str[1]);
        int day = new Integer(str[2]);
        Calendar c = new GregorianCalendar(year, month - 1, day); // Month:0-11
		 */
		
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd"); //���Ӽ��̻�õ�string���� ת���ɹ̶���ʽ��DATE
		Date dt=df.parse(str);
		
		Calendar c1=new GregorianCalendar();  //��DATE ת����Calendar����
		c1.setTime(dt);     //c1���ڴ�ӡ
		Calendar c2=new GregorianCalendar();
		c2.setTime(dt); //c2���ڼ����ճ�
		
		printCalendar(c1);
		System.out.println();
		DaysBetwoon(c2);
	}
	public static void printCalendar(Calendar c) throws ParseException {
		int day=c.get(Calendar.DAY_OF_MONTH);  //����û���������� �Ա�������*
		System.out.println("��\tһ\t��\t��\t��\t��\t��"); //��ӡ ���ڼ�
		
		c.set(Calendar.DAY_OF_MONTH, 1);       // ����������Ϊ1    ������µ�һ�쿪ʼ��ӡ  
		for(int i=0;i<c.get(Calendar.DAY_OF_WEEK)-1;i++) {   //��ӡ1�������ڼ�֮ǰ�Ŀո�
			System.out.print("\t");
		}
		
		int maxday=c.getActualMaximum(Calendar.DATE);  //��ȡ����� ��������
		for(int i=1;i<=maxday;i++) {
			System.out.print(c.get(Calendar.DAY_OF_MONTH)+(i==day?"*\t":"\t"));//��һ��  ���û���������� ��*
			if(c.get(Calendar.DAY_OF_WEEK)==7) {         //ÿ������ ����
				System.out.println();
			}
			c.add(Calendar.DAY_OF_MONTH, 1);       //���ڼ�1
		}
	}
	public static void DaysBetwoon(Calendar c1) throws ParseException {
		Calendar c2=new GregorianCalendar(); //��ȡ��ǰʱ��

		long time1=c1.getTimeInMillis();
		long time2=c2.getTimeInMillis();
		long between_days=(time1-time2)/(1000*3600*24);
		if(between_days<0) {
			between_days=-between_days;
		}else {
			between_days++;
		}
		System.out.println("�����������������ڻ���:"+between_days+"��.");
	}

}
