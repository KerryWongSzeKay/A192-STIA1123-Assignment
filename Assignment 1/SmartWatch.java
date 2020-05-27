public class SmartWatch extends DigitalWatch//inherit from the class DigitalWatch.
{
   public void showTime()//Overriding the superclass (DigitalWatch class) method
   {
      System.out.println("Display Time      : Digits form or Analog form");    
   }
   public static void count(String a,String b) //Overloading method
   {
      System.out.println("Count             : "+a+", "+b);
   }
   public static void count(String c,String d,String e)//Overloading method
   {
      System.out.println("Health Measurement: "+c+", "+d+", "+e);
   }
   public static void others()
   {
      System.out.println("Others Features   : TouchScreen!!!");
      System.out.println("                    Allows Connection to Phone.");
      System.out.println("                    Reply to Messages.");
      System.out.println("                    Receive Calls Instantly.");
   }
   public void print()//Overriding the superclass (DigitalWatch class) method
   {
      System.out.println("*************************");
      System.out.println(" Features of Smart Watch ");
      System.out.println("*************************");
      super.display();//call method display() in superclass (DigitalWatch class)
   }
}