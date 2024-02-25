package Java_Module00.ex04;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        char[] characters;
        int[] charOccurences = new int[127];
        int[] mostFrequentCharacters = new int[10];
        int[] mostFrequentCharactersOccurences = new int[10];

        // scan input
        input = sc.nextLine();
        sc.close();

        // convert input to char array
        characters = input.toCharArray();

        // count occurences of each character
        for (int i = 0; i < characters.length; i++) {
            charOccurences[characters[i]]++;
        }
        
        // print occurences of each character
        for (int i = 0; i < charOccurences.length; i++) {
            if (charOccurences[i] > 0) {
                System.out.println((char) i + " " + charOccurences[i]);
            }
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
                mostFrequentCharactersOccurences[i] = charOccurences[index];
                charOccurences[index] = 0;
            }
        }

        // print the most 10 frequent characters
        for (int i = 0; i < 10; i++) {
            if (mostFrequentCharacters[i] > 0) {
                System.out.println("==>" + (char) mostFrequentCharacters[i] + " " + mostFrequentCharactersOccurences[i]);
            }
        }
      
        // TODO: print the most 10 frequent characters in histogram format
    }
}
