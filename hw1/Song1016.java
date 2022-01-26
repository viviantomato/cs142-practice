public class Song1016 {
   public static void main (String [] args ) {
   
      verse1();
      System.out.println();
      verse2(); 
      System.out.println();
      verse3();
      System.out.println();
      verse4(); 
      System.out.println();
      verse5();      
      System.out.println();
      verse6();
      System.out.println();
      verse7();
      }

//STATIC METHOD

   public static void verse1(){
      System.out.println("There was an old woman who swallowed a fly.");
      boboA();   
   }
    public static void verse2(){
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      boboB();
      boboA(); 
   }
    public static void verse3(){
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      boboC();
      boboB();
      boboA();  
   }
    public static void verse4(){
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      boboD();
      boboC();
      boboB();
      boboA();
   }
    public static void verse5(){
     System.out.println("There was an old woman who swallowed a dog,");
     System.out.println("What a hog to swallow a dog.");
     boboE();
     boboD();
     boboC();
     boboB();
     boboA(); 
   }
    public static void verse6(){
      System.out.println("There was an old woman who swallowed a bobo,");
      System.out.println("There was a good bobo and a bad bobo.");
      System.out.println("She swallowed the bad bobo to catch the dog,");
      boboE();
      boboD();
      boboC();
      boboB();
      boboA();   
   }
    public static void verse7(){
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   public static void boboA(){
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
   }  
   public static void boboB(){
      System.out.println("She swallowed the spider to catch the fly,");
   }  
   public static void boboC(){
      System.out.println("She swallowed the bird to catch the spider,");
   }  
   public static void boboD(){
      System.out.println("She swallowed the cat to catch the bird,");
   }  
   public static void boboE(){
      System.out.println("She swallowed the dog to catch the cat,");
   }  
}

 


 


