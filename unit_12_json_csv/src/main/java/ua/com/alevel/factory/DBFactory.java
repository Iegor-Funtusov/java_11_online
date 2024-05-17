package ua.com.alevel.factory;

import org.apache.commons.collections4.MapUtils;
import ua.com.alevel.bd.BDStorage;
import ua.com.alevel.bd.CSVStorage;
import ua.com.alevel.bd.JsonStorage;
import ua.com.alevel.util.ResourceUtil;

import java.util.HashMap;
import java.util.Map;

public class DBFactory {

    private static DBFactory instance = null;
    private BDStorage bdStorage;

    private DBFactory() {
        final Map<String, String> properties = ResourceUtil.getResourceAsMap(this.getClass());
        if (MapUtils.isNotEmpty(properties)) {
            String fileFormat = properties.get("db.format");
            switch (fileFormat) {
                case "csv" -> bdStorage = new CSVStorage();
                case "json" -> bdStorage = new JsonStorage();
            }
        }
    }

    public static DBFactory getInstance() {
        if (instance == null) {
            instance = new DBFactory();
        }
        return instance;
    }

    public BDStorage getBdStorage() {
        return bdStorage;
    }
}
