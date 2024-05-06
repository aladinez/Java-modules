import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProvideFileSignature {
    
    private static FileOutputStream fileOutputStream;
    private static final String OUTPUT_FILE = "results.txt";
    private static final String SIGNATURES_FILE = "signatures.txt";
    // map that contains the format name and its signature
    private static Map<String, String> fileSignatures;

    public ProvideFileSignature() {
        try {
            fileOutputStream = new FileOutputStream(OUTPUT_FILE, true);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        this.setFileSignatures();
    }

    private void setFileSignatures() {
        fileSignatures = new HashMap<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(SIGNATURES_FILE);
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(", ");
                line[1] = line[1].replace(" ", "");
                fileSignatures.put(line[0], line[1]);
            }
            scanner.close();
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    public static void execute(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            byte[] bytes = new byte[8];
            fileInputStream.read(bytes);
            String signature = bytesToHex(bytes);
            System.out.println("==> " + signature);
            for (Map.Entry<String, String> entry : fileSignatures.entrySet()) {
                if (signature.startsWith(entry.getValue())) {
                    fileOutputStream.write((entry.getKey() + "\n").getBytes());
                    fileOutputStream.close();
                    return;
                }
            }
            fileOutputStream.write("UNDEFINED\n".getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }




}