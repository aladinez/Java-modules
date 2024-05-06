import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ProvideFileSignature provideFileSignature = new ProvideFileSignature();
        String inputFile = in.nextLine();

        while (!inputFile.equals("42")) {
            provideFileSignature.execute(inputFile);
            inputFile = in.nextLine();
        }
        in.close();
    }
}
