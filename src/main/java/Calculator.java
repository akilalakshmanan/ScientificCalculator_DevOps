import java.util.Scanner;

import java.util.InputMismatchException;
import static java.lang.System.exit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
    private static final Logger logger = LogManager.getLogger("["+String.valueOf(Calculator.class)+"]");

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int option;
        double value1, value2;
        Calculator calc = new Calculator();
        System.out.println("==============================================================================================");
        System.out.println("Welcome to our Scientific Calculator!!!");
        System.out.println("==============================================================================================");

        while (true)
        {
            System.out.println("\n");
            System.out.print("Select one of the following operation \n=> 1.Square Root \n=> 2.Factorial \n=> 3.Natural Logarithm \n=> 4.Power function \n=> 5.Exit \n");
            System.out.print("Enter your option :: ");
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }
            switch (option)
            {
                case 1:
                    System.out.println("\n======[ Square Root ]======");
                    System.out.print("Enter the number: ");
                    value1 = scanner.nextDouble();
                    System.out.println("Square Root of " + value1 + " = " + calc.sqrt(value1));
                    break;
                case 2:
                    System.out.println("\n======[ Factorial ]======");
                    System.out.print("Enter the number: ");
                    value1 = scanner.nextDouble();
                    double result = calc.fact(value1);
                    System.out.println("Factorial of " + value1 + " = " + result);
                    break;
                case 3:
                    System.out.println("\n======[ Natural Logarithm ]======");
                    System.out.print("Enter the number: ");
                    value1 = scanner.nextDouble();
                    System.out.println("Natural Logarithm of " + value1 + " = " + calc.log(value1));
                    break;
                case 4:
                    System.out.println("\n======[ Power ]======");
                    System.out.println("Enter the first number: ");
                    value1 = scanner.nextDouble();
                    System.out.println("Enter the second number : ");
                    value2 = scanner.nextDouble();
                    System.out.println("Power : " + value1 + " ^ " + value2 + " = " + calc.power(value1,value2));
                    break;
                case 5:
                    System.out.println("\n****** Exiting ******\n");
                    exit(0);
                default:
                    System.out.println("\nInvalid Option");
            }
        }
    }
    public double sqrt(double var){
        logger.info("Square Root of [ " + var + " ]\n Result [ " + Math.sqrt(var) +" ]");
        return Math.sqrt(var);
    }
    public double fact(double var){
        if(var < 0){
            logger.info("Factorial of negative number is not possible");
            return Double.NaN;
        }
        else{
            double fact = 1;
            for(int i = 1; i <= var; i++){
                fact *= i;
            }
            logger.info("Factorial of [ " + var + " ]\n Result is [ " + fact +" ]");
            return fact;
        }
    }
    public double log(double var){
        logger.info("Natural Logarithm of [ " + var + " ]\n Result [ " + Math.log(var) +" ]");
        return Math.log(var);
    }

    public double power(double var1, double var2){
        logger.info("Power [ " + var1 + " ]^[ " + var2 + " ]\n Result [ " + Math.pow(var1, var2) +" ]");
        return Math.pow(var1, var2);
    }

}
