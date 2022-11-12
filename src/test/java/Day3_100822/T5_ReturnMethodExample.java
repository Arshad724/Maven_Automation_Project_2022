package Day3_100822;

public class T5_ReturnMethodExample {
    public static void main(String[] args) {

        //the result of return method is e
      int value = ReusableClass.returnTwoAddNumbers(6,9);

      //using the value of the return value and  adding to it
       System.out.println("the new number is " + (value + 10));

    }//end of main
}//end of java class
