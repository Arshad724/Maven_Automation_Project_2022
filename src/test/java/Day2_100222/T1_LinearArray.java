package Day2_100222;

public class T1_LinearArray {

    public static void main(String[] args) {

        //declare string array variable
        String[] zipCode, streetNumber;

        //defining zip code values for the linear string array
        zipCode = new String[]{"11218","11222","10001","11377"};

        //defining street number values for the linear array
        streetNumber = new String[]{"222","333","444","555"};

        //print value from zipcode. Array always start from 0 index
        System.out.println("zip code: " + zipCode[0] + " " + zipCode[3]);

        //print value from zip code and street number
        System.out.println("zip code and street number: " + zipCode[1] + " " + streetNumber[3]);

    }//end of main
}//end of java class
