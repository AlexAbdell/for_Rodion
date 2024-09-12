package Services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public static String load(Path path) throws IOException {
        return new String(Files.readAllBytes(path));
    }

    public static void save(Path path, String body) throws Exception{
        System.out.println(String.valueOf(path));
        File file = new File(String.valueOf(path));
        file.createNewFile();
        FileOutputStream oFile = new FileOutputStream(file, false);
        oFile.write(body.getBytes());
        oFile.close();
    }
}
