
public class Program {
    public static void main(String[] args) {
        NanoShell shell;
        if (args.length != 1) {
            System.out.println("Usage: java Program --current-folder=<PATH>");
            return;
        }
        if (args[0].startsWith("--current-folder=")) {
            String path = args[0].substring("--current-folder=".length());
            shell = new NanoShell(path);
            shell.execute();
        } else {
            System.out.println("Usage: java Program --current-folder=<PATH>");
        }
    }
}
