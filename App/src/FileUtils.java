package App.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static String getString(File file) throws IOException {
        String out;
        if (file.exists() && file.isFile()) {
            out = Files.readString(Path.of(file.getPath()));
            return out;
        } else {
            out = "";
            return out;
        }
    }

    public static String[] getLines(File file) throws IOException {
        String text = getString(file);
        String[] lines = text.split("\n");
        return lines;
        /* if (file.exists() && file.isFile()) {
            ArrayList<String> linesList = (ArrayList<String>) Files.readAllLines(Path.of(file.getPath()));
            String[] lines = linesList.;
            return lines;
        } else {
            String[] lines = {};
            return lines;
        } */
    }

    public static String[] divideBlocks(File file, Config cfg) throws IOException {
        String[] lines = getLines(file);
        String out[] = new String[(lines.length / cfg.limit + ((lines.length % cfg.limit == 0) ? 0 : 1))];
        int blockStart = 0;
        String firstline = lines[0];
        
        out[0] += firstline;
        for (int i = 0; i < out.length; i++) {
            if (cfg.constantFirstLine && i > 0) {
                out[i] += firstline;
            }
            for (int j = blockStart; j < (cfg.limit + blockStart) && j < lines.length; j++) {
                out[i] += lines[j] + "\n";
            }
            blockStart += cfg.limit;
        }
        return out;
    }

    public static int getNumberOfLines(File file) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lines = 0;
        while (reader.readLine() != null)lines++;
        reader.close();
        return lines;
    }

    public static boolean hasMoreEntriesThan(File file, int limit) throws IOException {
        return getNumberOfLines(file) > limit ? true : false;
    }
}
