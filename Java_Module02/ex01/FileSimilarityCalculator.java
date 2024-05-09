import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class FileSimilarityCalculator {

    BufferedReader bufferedReader1;
    BufferedReader bufferedReader2;
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 10;
    Map<String, int[]> wordFrequencyMap = new HashMap<String, int[]>();

    public void fillDictionary(BufferedReader bufferedReader, int index) {
        String line;
        
        try {
            line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (wordFrequencyMap.containsKey(word)) {
                        wordFrequencyMap.get(word)[index]++;
                    } else {
                        int[] frequency = new int[2];
                        frequency[index] = 1;
                        wordFrequencyMap.put(word, frequency);
                    }
                }
                // print the line
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void execute(String file1, String file2) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("dictionary.txt");) {
            File filex = new File(file1);
            File filey = new File(file2);
            if (!filex.exists() && filey.exists() && (filex.length() > MAX_FILE_SIZE || filey.length() > MAX_FILE_SIZE)) {
                System.out.println("Error: file size is too large");
                return;
            }

            bufferedReader1 = new BufferedReader(new FileReader(file1));
            fillDictionary(bufferedReader1, 0);
            bufferedReader1.close();
            
            bufferedReader2 = new BufferedReader(new FileReader(file2));
            fillDictionary(bufferedReader2, 1);
            bufferedReader2.close();

            // calculate similarity
            double similarity = calculateSimilarity();
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.FLOOR);

            System.out.println("Similarity = " + df.format(similarity));
            for (Map.Entry<String, int[]> entry : wordFrequencyMap.entrySet()) {
                fileOutputStream.write((entry.getKey() + "\n").getBytes());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
    }

    public double calculateSimilarity() {
        double numerator = getNumerator();
        double denominator = getDenominator();
        if (denominator == 0 || numerator == 0) {
            return 0;
        }
        return numerator / denominator;
    }

    public double getNumerator() {
        double numerator = 0;
        for (Map.Entry<String, int[]> entry : wordFrequencyMap.entrySet()) {
            numerator += entry.getValue()[0] * entry.getValue()[1];
        }
        return numerator;
    }

    public double getDenominator() {
        double sum1 = 0;
        double sum2 = 0;
        for (Map.Entry<String, int[]> entry : wordFrequencyMap.entrySet()) {
            sum1 += entry.getValue()[0] * entry.getValue()[0];
            sum2 += entry.getValue()[1] * entry.getValue()[1];
        }
        return Math.sqrt(sum1) * Math.sqrt(sum2);
    }
}