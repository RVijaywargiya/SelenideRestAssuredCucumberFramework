package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    private final Properties properties = new Properties();

    private void propertySetup(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream is = new FileInputStream(file);
        properties.load(is);
    }

    public String getProperty(String filePath, String propertyName) throws IOException {
        propertySetup(filePath);
        return properties.getProperty(propertyName);
    }
}
