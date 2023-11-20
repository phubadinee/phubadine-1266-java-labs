package mehom.phubadine.lab2;

public class CamelCaseNaming {
    public static void main(String[] args) {
        String first_name = args[0];
        String last_name = args[1];


        if (args.length == 2){
            first_name = first_name.toLowerCase();
            last_name = last_name.toLowerCase();

            String prefix_first_name = first_name.substring(0,1);
            String prefix_last_name = last_name.substring(0,1);

            String final_first_name = prefix_first_name.toUpperCase() + first_name.substring(1);
            String final_last_name = prefix_last_name.toUpperCase() + last_name.substring(1);

            String result = final_first_name + final_last_name;
            System.out.println("Camel Case Result: " + result);
        }else{
            System.err.println("Please provide exactly two arguments.");
        }
        
    }
}
