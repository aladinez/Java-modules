import java.io.File;
import java.util.Scanner;

public class NanoShell {
    private String currentDirectory;
    private Scanner sc;

    public NanoShell(String initialDirectory) {
        currentDirectory = initialDirectory;
        sc = new Scanner(System.in);
    }

    public void execute() {
        String command = "";
        try {
            File initDir = new File(currentDirectory);
            if (!initDir.exists() || !initDir.isDirectory()) {
                System.out.println("Folder not found");
                return;
            }
            System.out.println(initDir.getCanonicalPath());
        } catch (Exception e) {
            System.out.println("Error: Folder not found");
            return;
        }
        while (!command.trim().equals("exit")) {
            command = sc.nextLine();
            if (command.startsWith("ls")) {
                ls();
            } else if (command.startsWith("mv")) {
                String[] parts = command.split(" ");
                if (parts.length == 3) {
                    mv(parts[1], parts[2]);
                } else {
                    System.out.println("Usage: mv WHAT WHERE");
                }
            } else if (command.startsWith("cd")) {
                String[] parts = command.split(" ");
                if (parts.length == 2) {
                    cd(parts[1]);
                } else {
                    System.out.println("Usage: cd FOLDER_NAME");
                }
            } else if (!command.trim().equals("exit")) {
                System.out.println("Unknown command");
            }
        }
        sc.close();
    }

    public void ls() {
        try {
            File dir = new File(currentDirectory);
            File[] files = dir.listFiles();
            for (File file : files) {
                System.out.println(file.getName() + " " + file.length() / 1024 + "KB");
            }
        } catch (Exception e) {
            System.out.println("Folder not found");
        }
    }

    public void mv(String what, String where) {
        try {
            File file = new File(currentDirectory,  what);
            File newFile = new File(currentDirectory, where);
            if (newFile.isDirectory()) {
                newFile = new File(newFile.getCanonicalPath(), file.getName());
                file.renameTo(newFile);
            } else {
                file.renameTo(newFile.getAbsoluteFile());
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    public void cd(String folderName) {
        try {
            File dir;
            dir = new File(currentDirectory, folderName);
            if (dir.isDirectory()) {
                currentDirectory = dir.getCanonicalPath();
                System.out.println(currentDirectory);
            } else {
                System.out.println("Folder not found");
            }
        } catch (Exception e) {
            System.out.println("Error: Folder not found");
        }
    }
}
