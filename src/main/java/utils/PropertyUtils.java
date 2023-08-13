package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    Properties properties = new Properties();

    private void propertySetup() throws IOException {
        File file = new File("src/main/resources/config/uiconfig.properties");
        FileInputStream is = new FileInputStream(file);
        properties.load(is);
    }

    public String getProperty(String propertyName) throws IOException {
        propertySetup();
        return properties.getProperty(propertyName);
    }
}
