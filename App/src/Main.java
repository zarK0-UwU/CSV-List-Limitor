package App.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Config cfg;
        try {
            cfg = new Config(new File("settings.cfg"));
            File inputFolder = new File("input");
            if (inputFolder.exists() && inputFolder.isDirectory()) {
                File[] inputs = inputFolder.listFiles();
                for (File file : inputs) {
                    if (FileUtils.hasMoreEntriesThan(file, cfg.limit)) {
                        String block[] = FileUtils.divideBlocks(file, cfg);
                        System.out.println("[DIVIDIDO] " + file.getName() + " " + FileUtils.getNumberOfLines(file) + " lineas");
                        for (int i = 0; i < block.length; i++) {
                            File output = new File(
                                "output/" + file.getName().substring(0, file.getName().length()-4) + "-" + i + ".csv"); 
                                //-4 since need to remove .svg ( 4  chars)
                            if (output.exists())output.delete();
                            FileWriter writer = new FileWriter(output);
                            writer.write(block[i]);
                            writer.close();
                            System.out.println(" --> [CORRECTO] " + FileUtils.getNumberOfLines(output) + " lineas");
                        }

                    } else {
                        File output = new File("output/" + file.getName());
                        if (output.exists())output.delete();
                        FileWriter writer = new FileWriter(output);
                        writer.write(FileUtils.getString(file));
                        writer.close();
                        System.out.println("[CORRECTO] " + file.getName() + " " + FileUtils.getNumberOfLines(file) + " lineas");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong chaeck error.log for more info");
            try {
                FileWriter writer = new FileWriter(new File("Error.log"));
                writer.write(e.getCause() + "\n");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } 

    }
}