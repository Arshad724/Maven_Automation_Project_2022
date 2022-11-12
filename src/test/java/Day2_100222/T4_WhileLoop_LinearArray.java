package Day2_100222;

public class T4_WhileLoop_LinearArray {
    public static void main(String[] args) {
        //you can also use arraylist for while loop. Will use linear
        //declare and define linear array for street number
        int[] streetNumber = new int[]{111,222,333,444,555,666,777};

        //iterate through all street number by while loo
        //set the initializer (while loop has int outside)
        int i = 0;

        //now set the condition for while loop
        //linear array gets the count by .length command
        while(i < streetNumber.length){

            System.out.println("Street number: " + streetNumber[i]);

            //incrementation goes at the end
            i++;
        }//end of while loop
    }//end of main
}//end of java class
