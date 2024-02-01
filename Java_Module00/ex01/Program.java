import java.util.Scanner;

public class Program {
    /**
     * @param args
     * prints wether the input is a Prime or not, along with the number of iterations
     * in this exercice, iteration is a single comparison operation
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        int iterations = 1;

        if (num <= 1){
            System.err.println("IllegalArgument");
            return ;
        }

        if (num % 2 == 0){
            System.out.println("false " + iterations);
            return;
        }
        iterations++;
        
        for (int i = 3; i * i <= num; i += 2){
            if (num % i == 0){
                System.out.println("false " + iterations);
                return;
            }
            iterations += 2;
        }
        System.out.println("true " + iterations);
    }
}
