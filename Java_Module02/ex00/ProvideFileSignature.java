import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProvideFileSignature {
    
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private static final String OUTPUT_FILE = "results.txt";
    // map that contains the format name and its signature
    private Map<String, String> fileSignatures;

    public ProvideFileSignature() {
        try {
            this.fileOutputStream = new FileOutputStream(OUTPUT_FILE);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        // set files signatures from signature.txt that contains the format name and its signature as follow : GIF, 47 49 46 38 37 61
        this.setFileSignatures();
    }

    private void setFileSignatures() {
        fileSignatures = new HashMap<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("signatures.txt");
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(", ");
                line[1] = line[1].replace(" ", "");
                fileSignatures.put(line[0], line[1]);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    public void setfileInputStream(String fileInputStream) {
        try {
            this.fileInputStream = new FileInputStream(fileInputStream);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void execute() {
        try {
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