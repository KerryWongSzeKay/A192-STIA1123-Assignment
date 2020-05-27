import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;  
import java.time.DayOfWeek;    
import java.time.LocalDateTime;
import java.text.DateFormat;  
import java.util.Date;     
public class MainWatch
{
   public static void main (String[]args)
   {
      Date currentDate = new Date(); //current date 
      LocalDateTime now = LocalDateTime.now();     
      String time1 = DateFormat.getTimeInstance(DateFormat.SHORT).format(currentDate); //Display time in 12-hour Format 
      String time2 = DateFormat.getTimeInstance().format(currentDate);//Display time in 12-hour Format with AM/PM
      DateTimeFormatter time3 = DateTimeFormatter.ofPattern("HH:mm:ss");//Display time in 24-hour Format 
      SimpleDateFormat form2 = new SimpleDateFormat("HH:mm:ss zzzz");  
      String time4 = form2.format(currentDate);//Display time in 24-hour Format(Malaysia Time)
            
      DateTimeFormatter date1 = DateTimeFormatter.ofPattern("dd");//Display date Format 
      DateTimeFormatter date2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");//Display date Format
      SimpleDateFormat form1 = new SimpleDateFormat("dd/MM/yyyy & dd MMM yyyy");   
      String date3 = form1.format(currentDate);//Display date Format
         
      DateTimeFormatter day1 = DateTimeFormatter.ofPattern("E");//Display day in short form 
      DayOfWeek day2 = DayOfWeek.from(now);//Display day in full name        
     
     //encapsulation and inheritance
      AnalogWatch aw= new AnalogWatch();
      aw.print();//method Overriding
      System.out.println();
      aw.setTime(time1);
      aw.setDate(date1.format(now));
      aw.setDay(day1.format(now));
      System.out.println("Time (hh:mm)     : "+ aw.getTime());
      System.out.println("Date (dd)        : "+ aw.getDate());
      System.out.println("Day              : "+ aw.getDay());
      aw.showTime();//method Overriding
      aw.readTime();
      aw.waterproof();
      aw.batteryLife();
      System.out.println();
      
      aw.specialFeatures();
      System.out.println();
      aw.special("Ticking");//method Overloading
      aw.special("Hours hand","Minutes hand","Seconds hand");
      System.out.println();
      
      //encapsulation and inheritance
      DigitalWatch dw= new DigitalWatch();
      dw.print();//method Overriding
      dw.display();
      System.out.println();
      dw.setTime(time2);
      dw.setTime1(time3.format(now));
      dw.setDate(date2.format(now));
      dw.setDay(day1.format(now));
      System.out.println("Time 12-hour Format (hh:mm:ss) : "+ dw.getTime());
      System.out.println("Time 24-hour Format (hh:mm:ss) : "+ dw.getTime1());
      System.out.println("Date (dd/MM/yyyy) : "+ dw.getDate());
      System.out.println("Day               : "+ dw.getDay());
      dw.showTime();//method Overriding
      dw.readTime();
      dw.waterproof();
      dw.batteryLife();
      System.out.println();
      
      dw.specialFeatures();
      System.out.println();
      dw.stopwatch();
      dw.alarm();
      dw.light();
      System.out.println();
      
      //encapsulation and inheritance
      SmartWatch sw= new SmartWatch();
      sw.print();//method Overriding
      System.out.println();
      sw.setTime(time2);
      sw.setTime1(time4);
      sw.setDate(date3);
      sw.setDay(day2.name());
      System.out.println("Time 12-hour Format (hh:mm:ss)  : "+ sw.getTime());
      System.out.println("Time 24-hour Format (hh:mm:ss)  : "+ sw.getTime1());
      System.out.println("Date (dd/MM/yyyy)&(dd MMM yyyy) : "+ sw.getDate());
      System.out.println("Day               : "+ sw.getDay());
      sw.showTime();//method Overriding
      sw.readTime();
      sw.waterproof();
      sw.batteryLife();
      sw.stopwatch();
      sw.alarm();
      sw.light();
      System.out.println();
      
      sw.specialFeatures();
      System.out.println();
      sw.count("Steps","Distance");//method overloading
      sw.count("Heart Rate","Calories","Blood Pressure");
      sw.others();   
    }
}