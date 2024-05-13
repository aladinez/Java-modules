public class Program {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Program <file1> <file2>");
            return;
        }

        FileSimilarityCalculator fsc = new FileSimilarityCalculator();
        fsc.execute(args[0], args[1]);
    }
}
