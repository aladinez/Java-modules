import java.util.Scanner;

public class Program {
    /**
     * @param args
     * prints wether the input is a Prime or not, along with the number of iterations
     * in this exercice, iteration is a single comparison operation
     * TODO: check exit code(returns 255), check if the first comparison is considered iteration
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int check = 1;
        sc.close();
        if (num <= 1){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        if (num % 2 == 0){
            System.out.println("false " + check);
            return;
        }
        for (int i = 3; i * i < num; i++){
            check += 2;
            if (num % i == 0){
                System.out.println("false " + check);
                return;
            }
            i++;
        }
        check++;
        System.out.println("true " + check);
    }
}
