import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.PrintWriter;
public class Io {
    public static String[] readFile(String path, boolean discardEmptyLines, boolean trim) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            if (discardEmptyLines) {
                lines.removeIf(line -> line.trim().equals(""));
            }
            if (trim) {
                lines.replaceAll(String::trim);
            }
            return lines.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void writeToFile(String path, String content, boolean append, boolean newLine) {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(path, append));
            ps.print(content + (newLine ? "\n" : ""));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.flush();
                ps.close();
            }
        }
    }
    public static void fileCleaner() {
        try {
            PrintWriter writer = new PrintWriter("output.txt");
            writer.print("");
            writer.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}