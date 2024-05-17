package ua.com.alevel.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class ResourceUtil {

    private static final String APP_PROPERTIES = "app.properties";

    private ResourceUtil() {}

    public static Map<String, String> getResourceAsMap(Class<?> aClass) {
        Map<String, String> map = new HashMap<>();
        ClassLoader classLoader = aClass.getClassLoader();
        try(InputStream inputStream = classLoader.getResourceAsStream(APP_PROPERTIES)
        ) {
            if(inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + APP_PROPERTIES);
            }
            try(InputStreamReader inputStreamReader = new InputStreamReader(inputStream)
            ) {
                Properties properties = new Properties();
                properties.load(inputStreamReader);
                properties.forEach((key, value) -> map.put(key.toString(), value.toString()));
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
        return map;
    }
}
