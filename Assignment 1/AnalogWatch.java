public class AnalogWatch extends Watch//inherit from the class Watch. 
{
   public void showTime()//Overriding the superclass (Watch class) method
   {
      System.out.println("Display Time     : Through hands on a dial ");
   }
   public void readTime()//method overriding
   {
      System.out.println("Read Time Format : 12-hour format");
   }
   public void waterproof()//method overriding
   {
      System.out.println("Waterproof Level : Weak");
   }
   public void batteryLife()//method overriding
   {
      System.out.println("Battery's Life   : Long-lasting");
   }
   public static void special(String a)//Overloading method
   {
      System.out.println("Motion            : \""+a+"\" ");
   }
   public static void special(String b,String c,String d)//Overloading method
   {
      System.out.println("Move With 3 Hands : "+b);
      System.out.println("                    "+c);
      System.out.println("                    "+d);
   }
   public void print()//Overriding the superclass (Watch class) method
   {
      System.out.println("**************************");
      System.out.println(" Features of Analog Watch ");
      System.out.println("**************************");
      super.print();//call method print() in superclass (Watch class)

   }
}
