/**
 * ʱ��
 */
 import java.util.Date;
 import java.text.SimpleDateFormat;
 
 public class Shijian
 {
     public static void main(String args[])
     {
        Date date = new Date();
        long times = date.getTime();
        // ���ʱ���
        // System.out.println(times);
        
        // ��ʽ��ʱ��
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(times);
        System.out.println(dateString);
        
        // ʱ�����ʽ��
        long times1 = 1412654676572L;
        Date date1 = new Date(times1);
        System.out.println(date1);
     }
 }