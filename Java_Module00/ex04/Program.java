import java.util.Scanner;

public class Program {

    public static boolean isPrintHash(int occurences, int maxOccurences, int i) {
        int coefficient = 10000 / maxOccurences;

        coefficient++;
        int result = (occurences * coefficient);
        if (result >= i + 1000) {
            return true;
        }
        return false;
    }

    public static boolean isPrintOccurences(int occurences, int maxOccurences, int i) {
        int coefficient = 10000 / maxOccurences;

        coefficient++;
        int result = occurences * coefficient;
        if (result > i  && result < i + 1000) {
            return true;
        }
        return false;
    }

    public static boolean isPrintSpace(int occurences, int maxOccurences, int i) {
        int coefficient = 10000 / maxOccurences;

        coefficient++;
        int result = (occurences * coefficient);
        if (result < i) {
            return true;
        }
        return false;
    }

    // print the most 10 frequent characters in histogram format
    public static void printHistogram(int[] occurences, int[] occurencesLength, int[] mostFrequentCharacters) {
        String cell = "";

        System.out.println();
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                if (isPrintOccurences(occurences[j], occurences[0], i * 1000)) {
                    cell = occurences[j] + "";
                    for (int k = 0; k < 4 - occurencesLength[j]; k++) { // add spaces to align the numbers
                        cell = " " + cell;
                    }
                    System.out.print(cell);
                }
                else if (isPrintHash(occurences[j], occurences[0], i * 1000)) {
                    cell = "   #";
                    System.out.print(cell);
                }
                else if (isPrintSpace(occurences[j], occurences[0], i * 1000)) {
                    cell = "    ";
                    System.out.print(cell);
                }
            }
            System.out.println();
        }
        for (int j = 0; j < 10; j++) {
            cell = "   " + ((char)mostFrequentCharacters[j]);
            System.out.print(cell);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        char[] characters;
        int[] charOccurences = new int[65536];
        int[] mostFrequentCharacters = new int[10];
        int[] occurences = new int[10];

        // scan input
        input = sc.nextLine();
        sc.close();

        // convert input to char array
        characters = input.toCharArray();

        // count occurences of each character
        for (int i = 0; i < characters.length; i++) {
            charOccurences[characters[i]]++;
        }

        // extract the most 10 frequent characters
        for (int i = 0; i < 10; i++) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < charOccurences.length; j++) { // get the most frequent character
                if (charOccurences[j] > max) {
                    max = charOccurences[j];
                    index = j;
                }
            }
            if (max > 0) { // store and reset the most frequent character to 0.
                mostFrequentCharacters[i] = index;
                occurences[i] = charOccurences[index];
                charOccurences[index] = 0;
            }
        }

        // create occurences length array
        int[] occurencesLength = new int[10];
        for (int i = 0; i < 10; i++) {
            occurencesLength[i] = (occurences[i] + "").length();
        }
        
        // print the most 10 frequent characters in histogram format
        printHistogram(occurences, occurencesLength, mostFrequentCharacters);
    }
}
