package mehom.phubadine.lab2;Z

/*
 * The Patient Program:
 * This program accepts three arguments and
 * displays patient information.
 * The output should be
 * Patient's name : <patient_name>
 * Nationality : <patient_age>
 * Gender : <patient_gender>
 * 
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */
public class Patient {

    public static void main(String[] args) {
        if (args.length != 3){
            System.err.println("Invalid number of arguments. Please provide exactly three arguments.");
        }else{
            System.out.println("Patient's Name : " + args[0]);
            System.out.println("Age : " + args[1]);
            System.out.println("Gender : " + args[2]);
        }
        

    }
}
