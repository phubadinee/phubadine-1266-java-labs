package mehom.phubadine.lab2;

import java.util.Scanner;

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
        // Scanner  name_prompt = new Scanner(System.in);
        // Scanner  age_prompt = new Scanner(System.in);
        // Scanner  gen_prompt = new Scanner(System.in);
        
        // String patient_name,gender,age;

        // System.out.print("Patient's Name : "); 
        // patient_name = name_prompt.nextLine();   
         
        // System.out.print("Age : ");
        // age = age_prompt.nextLine();

        // System.out.print("Gender : ");
        // gender = gen_prompt.nextLine();



        System.out.println("Patient's Name : " + args[0]);
        System.out.println("Age : " + args[1]);
        System.out.println("Gender : " + args[2]);

    }
}
