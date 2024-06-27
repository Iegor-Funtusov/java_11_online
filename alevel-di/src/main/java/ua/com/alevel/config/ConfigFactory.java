package ua.com.alevel.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigFactory {

    private final Map<String, String> configMap = new HashMap<>();

    public ConfigFactory(Class<?> mainClass) {
        ClassLoader classLoader = mainClass.getClassLoader();
        try(InputStream inputStream = classLoader.getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            properties.forEach((key, value) -> configMap.put(key.toString(), value.toString()));
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    public Map<String, String> getConfigMap() {
        return configMap;
    }
}
