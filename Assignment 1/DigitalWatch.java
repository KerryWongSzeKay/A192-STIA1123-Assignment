public class DigitalWatch extends Watch//inherit from the class Watch.
{
   private String time1;//private because it cannot be directly accessed in other class
   
   // set method for time1 to access  
   // private variable time1 
   public void setTime1(String newTime1)
   {
      this.time1=newTime1;
   }
   // get method for time1 to access  
   // private variable time1 
   public String getTime1()
   {
      return time1;
   }
   public void showTime()//Overriding the superclass (Watch class) method
   {
      System.out.println("Display Time      : Digits and Numbers form (usually on LED screen)");
   }
   public void readTime()//method Overriding
   {
      System.out.println("Read Time Format  : 12-hour or 24-hour format");
   }
   public void waterproof()//method Overriding
   {
      System.out.println("Waterproof Level  : Strong");
   }
   public void batteryLife()//method Overriding
   {
      System.out.println("Battery's Life    : Not lasting");
   }
   public static void stopwatch()
   {
      System.out.println("Stopwatch         : Counting Timer");
   }
   public static void alarm()
   {
      System.out.println("Alarm             : Vibration");
   }
   public static void light() 
   {
      System.out.println("Light             : ON or OFF");
   }
   public void print()//Overriding the superclass (Watch class) method
   {
      System.out.println("***************************");
      System.out.println(" Features of Digital Watch ");
      System.out.println("***************************");
   }
   public void display()
   {
      super.print();//call method print() in superclass (Watch class) 
   }
}