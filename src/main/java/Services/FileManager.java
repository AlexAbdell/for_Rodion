package Services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileManager {
    public static String load(Path path) throws IOException {
        File file = new File(path.toString());
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
        }
        return sb.toString();
    }

    public static void save(Path path, String body) throws Exception{
        File file = new File(String.valueOf(path));
        file.createNewFile();
        FileOutputStream oFile = new FileOutputStream(file, false);
        oFile.write(body.getBytes());
        oFile.close();

    }
}
