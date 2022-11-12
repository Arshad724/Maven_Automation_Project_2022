package Wednesday_100522;

import java.util.ArrayList;

public class Exercise2_phoneNumber_arrayListWithForLoop {
    public static void main(String[] args) {

        ArrayList<Integer> phone = new ArrayList<>();

        phone.add(234642789);
        phone.add(987427654);
        phone.add(987654367);
        phone.add(876539023);
        phone.add(756432861);

        for(int i = 0; i < phone.size(); i++){

            System.out.println("My phone number is " + phone.get(i));
        }

    }//end of main
}//end of java class
