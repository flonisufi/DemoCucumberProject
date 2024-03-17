package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("globalData.properties");
            properties.load(fis);
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occured while reading config file");

        }
    }

    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }
}
