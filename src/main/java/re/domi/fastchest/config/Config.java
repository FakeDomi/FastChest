package re.domi.fastchest.config;

import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.util.Properties;

public class Config
{
    private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "fast-chest.properties");

    public static boolean simplifiedChestRendering = true;

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

            simplifiedChestRendering = Boolean.toString(true).equals(properties.getProperty("simplifiedChestRendering"));
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
            properties.setProperty("simplifiedChestRendering", Boolean.toString(simplifiedChestRendering));
            properties.store(outputStream, "FastChest config file");
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
