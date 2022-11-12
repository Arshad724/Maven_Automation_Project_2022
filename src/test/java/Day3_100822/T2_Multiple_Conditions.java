package Day3_100822;

public class T2_Multiple_Conditions {
    public static void main(String[] args) {
        //declare three int variables
        int a, b, c;
        a = 2;
        b = 3;
        c = 4;

        // a multiple conditional statements that covers when a+b < c, a+b > c, a+b = c
        if(a+b < c){
            System.out.println("a & b is less than c");
        } else if(a+b > c){
            System.out.println("a & b is greater than c");
        } else {
            System.out.println(" a & b is equal to c");
        }//end of condition

    }//end of main
}//end of java class
