package ua.com.alevel.util;

import ua.com.alevel.entity.BaseEntity;

import java.util.List;
import java.util.UUID;

public final class DBUtil {

    private DBUtil() {}

    public static <T extends BaseEntity> String generateId(List<T> list) {
        String id = UUID.randomUUID().toString();
        if (list.stream().anyMatch(entity -> entity.getId().equals(id))) {
            generateId(list);
        }
        return id;
    }
}
