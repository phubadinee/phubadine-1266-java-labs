package mehom.phubadine.lab2;

/*
 * The Primitive Data Type Program:
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

public class PrimitiveDataType {
    public static void main(String[] args) {


        String studentID = "6630401266", firstName = "Phubadine";
        byte byte_val = (byte) Integer.parseInt(studentID.substring(studentID.length()-2));
        Short short_val = (short) Integer.parseInt(studentID.substring(studentID.length()-3));
        int int_val = Integer.parseInt(studentID.substring(studentID.length()-6));
        long long_val = Long.parseLong(studentID.substring(studentID.length()-8));
        float float_val = Float.parseFloat(studentID.substring(studentID.length()-2)) /100;
        double double_val = Double.parseDouble(studentID.substring(studentID.length()-7)) /10000000;
        char prefix_firstname_val = firstName.charAt(0);
        
        boolean check_val = true;
        if (Integer.parseInt(studentID.substring(studentID.length()-1)) % 2 != 0 ){
            check_val = !check_val; 
        }

        System.out.println("Student ID:" + studentID);
        System.out.println("First Name: " + firstName);
        System.out.println("Byte Value: " + byte_val);
        System.out.println("Short Value: " + short_val);
        System.out.println("Int Value: " + int_val);
        System.out.println("Long Value: " + long_val);
        System.out.println("Float Value: " + float_val);
        System.out.println("Double Value: " + double_val);
        System.out.println("Char Value: " + prefix_firstname_val);
        System.out.println("Boolean: " + check_val);
    }
}
