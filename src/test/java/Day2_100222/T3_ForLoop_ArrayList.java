package Day2_100222;

import java.util.ArrayList;

public class T3_ForLoop_ArrayList {
    public static void main(String[] args) {

        //declare and define the arrayList for zip code
        ArrayList<String> zipCode = new ArrayList<>();
        //zipcode list entries
        zipCode.add("11218");
        zipCode.add("11238");
        zipCode.add("11208");
        zipCode.add("11256");
        zipCode.add("10248");

        //call for loop to print out all zip codes from array list
        for(int i=0; i < 5; i++){

            //print out each zip code
            System.out.println("Zip code: " + zipCode.get(i));
        }//end of loop

        //call for loop to print zip codes but dynamic
        for(int i=0; i < zipCode.size(); i++){

            //Print out each zip code
            System.out.println("Automatic/dynamic zip code: " + zipCode.get(i));
        }//end of for loop
    }//end of main
}//end of java class
