package App.src;

import java.io.File;
import java.io.FileNotFoundException;

public class Config {
    int limit;
    Boolean constantFirstLine;

    public Config(File cfg_file) throws FileNotFoundException {
        this(FileUtils.getString(cfg_file));
    }

    public Config(String cfg) {
        String cfgLines[] = cfg.split("\n");
        String settings[][] = new String[cfgLines.length][];
        for (int i = 0; i < cfgLines.length; i++) {
            settings[i] = cfgLines[i].split("=");
        }
        for (int i = 0; i < settings.length; i++) {

            switch (settings[i][0]) {
                case "limit":
                    this.limit = Integer.parseInt(settings[i][1]);
                    break;
                case "constant_first_line":
                    this.constantFirstLine = settings[i][1].equals("true")?true:false;
                    break;

                default:
                    break;
            }
        }
    }

}
