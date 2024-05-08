import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProvideFileSignature {
    private static final String SIGNATURES_FILE = "signatures.txt";
    // map that contains the format name and its signature
    private static Map<String, String> fileSignatures;

    public ProvideFileSignature() {
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

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    public String execute(String filePath){
        try (FileInputStream fileInputStream = new FileInputStream(filePath)
        ){
            byte[] bytes = new byte[8];
            //check read returns -1
            fileInputStream.read(bytes);
            String signature = bytesToHex(bytes);
            System.out.println("==> " + signature);
            for (Map.Entry<String, String> entry : fileSignatures.entrySet()) {
                if (signature.startsWith(entry.getValue())) {
                    System.out.println("PROCESSED");
                    return entry.getKey();
                }
            }
            System.out.println("UNDEFINED");
        }
         catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return "";
    }
}