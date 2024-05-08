import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class FileSimilarityCalculator {

    BufferedReader bufferedReader1;
    BufferedReader bufferedReader2;
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
        try {
            bufferedReader1 = new BufferedReader(new FileReader(file1));
            //fill Dictionary from file1
            fillDictionary(bufferedReader1, 0);
            bufferedReader1.close();
            
            bufferedReader2 = new BufferedReader(new FileReader(file2));
            //fill Dictionary from file2
            fillDictionary(bufferedReader2, 1);
            bufferedReader2.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // pretty print the wordFrequencyMap
        for (Map.Entry<String, int[]> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue()[0] + " " + entry.getValue()[1]);
        }

        // calculate the similarity
        double similarity = calculateSimilarity();
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);
        System.out.println("Similarity = " + df.format(similarity));
    }

    public double calculateSimilarity() {
        double numerator = getNumerator();
        double denominator = getDenominator();

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