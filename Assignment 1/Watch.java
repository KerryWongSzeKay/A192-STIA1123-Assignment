/*Title: Watch 
3 types of watch :Analog watch, Digital watch and Smart watch
2 Superclass which is Watch class and DigitalWatch class
The subclasses for Watch class are AnalogWatch & DigitalWatch class
The subclass for DigitWatch class is SmartWatch class*/

public abstract class Watch //Concept of Abstraction
{
   private String time;
   private String date;//private because it cannot be directly accessed in other class
   private String day;
   
   // set method for time to access  
   // private variable time 
   public void setTime(String newTime)
   {
      this.time=newTime;
   }
   // get method for time to access  
   // private variable time 
   public String getTime()
   {
      return time;
   }
   // set method for date to access  
   // private variable date 
   public void setDate(String newDate)
   {
      this.date=newDate;
   }
   // get method for date to access  
   // private variable date 
   public String getDate()
   {
      return date;
   }
   // set method for day to access  
   // private variable day
   public void setDay(String newDay)
   {
      this.day=newDay;
   }
   // get method for day to access  
   // private variable day 
   public String getDay()
   {
      return day;
   }
   // these are abstract methods 
   public abstract void showTime();//cannot be implemented in Watch class 
   public abstract void readTime();//because their implementations are dependent on the specific type of watch
   public abstract void waterproof();//implementation is provided by the subsclass  
   public abstract void batteryLife();
   
   public void print()
   {
      System.out.println("<<<<< BASIC FEATURES >>>>>");
   }
   public void specialFeatures()
   {
      System.out.println("<<<< SPECIAL FEATURES >>>>");
   }
}