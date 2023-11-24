/*
 * Auther : Phubadine Mehom 
 * ID : 663040126-6
 * Sec : 1 
 */

package mehom.phubadine.lab2;

public class SimpleCalculator {
    public static void main(String[] args) {
        int number1 = (int) Integer.parseInt(args[0]);
        int number2 = (int) Integer.parseInt(args[1]);
        String operator = args[2];
        float val;

        if (args.length !=3){
            System.err.println("Please provide exactly three arguments.");
        }else{
            if (operator.equals("+")){
                val = number1 + number2;
                System.out.println(number1 + operator + number2 + "=" + val);
            }else if (operator.equals("-")){
                val = number1 - number2;
                System.out.println(number1 + operator + number2 + "=" + val);
            }else if (operator.equals("x")){
                val = number1 * number2;
                System.out.println(number1 + operator + number2 + "=" + val);
            }else if (operator.equals("/")){
                if (number2 == 0){
                    System.err.println("Division by zero is not allowed.");
                }else{
                    val = number1 / number2;
                    System.out.println(number1 + operator + number2 + "=" + val);
                }   
            }else{
                System.err.println("Invalid operator. Please use '+', '-', '*', '/'.");
            }
        
        }
        
        
    }
}
