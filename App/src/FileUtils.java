package App.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileUtils {
    public static String getString(File file) throws FileNotFoundException {
        String out = "";
        Scanner reader = new Scanner(file);
        if (file.exists() && file.isFile()) {
            while (reader.hasNextLine()) {

                out += reader.nextLine() + "\n";

            }
            reader.close();
            return out;
        } else {
            reader.close();
            return out;
        }
    }

    public static String[] getLines(File file) throws FileNotFoundException {
        String text = getString(file);
        return text.split("\n");
    }

    public static String[] divideBlocks(File file, int limit) throws FileNotFoundException {
        String[] lines = getLines(file);
        String out[] = new String[(lines.length / limit + ((lines.length % limit == 0) ? 0 : 1))];
        int blockStart = 0;
        
        for (int i = 0; i < out.length; i++) {
            for (int j = blockStart; j < (limit + blockStart) && j < lines.length; j++) {
                out[i] += lines[j] + "\n";
            }
            blockStart += limit;
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
