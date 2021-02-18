package re.domi.fastchest.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.util.Properties;

public class Configs {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "fast-chest.properties");

    public static boolean simplifiedChestRendering = true;

    private static void read() {
        Properties properties = new Properties();
        FileInputStream configInputStream;
        try {
            configInputStream = new FileInputStream(CONFIG_FILE);
        } catch (FileNotFoundException e) {
            try {
                CONFIG_FILE.createNewFile();
                configInputStream = new FileInputStream(CONFIG_FILE);
            } catch (IOException ex) {
                ex.printStackTrace();
                return;
            }
        }
        try {
            properties.load(configInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        simplifiedChestRendering = Boolean.toString(true).equals(properties.getProperty("simplifiedChestRendering"));
    }

    static void write() {
        Properties properties = new Properties();
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(CONFIG_FILE);
        } catch (FileNotFoundException e) {
            try {
                CONFIG_FILE.createNewFile();
                outputStream = new FileOutputStream(CONFIG_FILE);
            } catch (IOException ex) {
                ex.printStackTrace();
                return;
            }
        }
        try {
            properties.setProperty("simplifiedChestRendering", Boolean.toString(simplifiedChestRendering));
            properties.store(outputStream, "Configs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        read();
    }

}
