public class Program {
    public static void main(String[] args) {
        ProvideFileSignature provideFileSignature = new ProvideFileSignature();
        provideFileSignature.setfileInputStream("/workspaces/Java-modules/test/video.mp4");
        provideFileSignature.execute();
       
    }
}
