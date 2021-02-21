package re.domi.fastchest.config;

import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.util.Properties;

public class Config
{
    private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "fast-chest.properties");
    private static final String CONFIG_COMMENT = "FastChest config file";
    private static final String SIMPLIFIED_CHEST = "simplifiedChest";

    public static boolean simplifiedChest = true;

    private static void read()
    {
        try
        {
            if (CONFIG_FILE.createNewFile())
            {
                write();
                return;
            }

            FileInputStream configInputStream = new FileInputStream(CONFIG_FILE);

            Properties properties = new Properties();
            properties.load(configInputStream);

            simplifiedChest = Boolean.toString(true).equals(properties.getProperty(SIMPLIFIED_CHEST));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    static void write()
    {
        try
        {
            FileOutputStream outputStream = new FileOutputStream(CONFIG_FILE);

            Properties properties = new Properties();
            properties.setProperty(SIMPLIFIED_CHEST, Boolean.toString(simplifiedChest));
            properties.store(outputStream, CONFIG_COMMENT);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    static
    {
        read();
    }
}
