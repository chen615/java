/**
 * 时间
 */
 import java.util.Date;
 import java.text.SimpleDateFormat;
 
 public class Shijian
 {
     public static void main(String args[])
     {
        Date date = new Date();
        long times = date.getTime();
        // 输出时间戳
        // System.out.println(times);
        
        // 格式化时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(times);
        System.out.println(dateString);
        
        // 时间戳格式化
        long times1 = 1412654676572L;
        Date date1 = new Date(times1);
        System.out.println(date1);
     }
 }