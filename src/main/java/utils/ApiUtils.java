package utils;

import java.io.IOException;

public class ApiUtils {

    protected static String getBaseUri() throws IOException {
        return new PropertyUtils().getProperty("src/main/resources/config/api-config.properties", "baseUri");
    }

    protected static String getBasePath() throws IOException {
        return new PropertyUtils().getProperty("src/main/resources/config/api-config.properties", "basePath");
    }
}
