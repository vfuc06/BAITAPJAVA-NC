package TH130325;
import java.io.File;

public class B5_LietKeFile {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\phuc2\\IdeaProjects\\Java - NC";
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Directory is empty or unreadable");
            }
        } else {
            System.out.println("This is not a valid directory.");
        }
    }
}
