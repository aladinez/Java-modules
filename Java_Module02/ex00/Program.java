import java.io.FileOutputStream;
import java.util.Scanner;

public class Program {
    private static final String OUTPUT_FILE = "results.txt";
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ProvideFileSignature provideFileSignature = new ProvideFileSignature();
        String inputFile = in.nextLine();

        try(FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE)) {
            while (!inputFile.equals("42")) {
                    String output = provideFileSignature.execute(inputFile);
                    if (!output.isEmpty())
                        fileOutputStream.write((output + "\n").getBytes());
                    inputFile = in.nextLine();
                }
                in.close();
            }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
