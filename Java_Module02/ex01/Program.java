public class Program {
    public static void main(String[] args) {
        // get to file paths from args
        String file1 = args[0];
        String file2 = args[1];
        
        // create a new instance of FileSimilarityCalculator
        FileSimilarityCalculator fsc = new FileSimilarityCalculator();
        fsc.execute(file1, file2);
    }
}
