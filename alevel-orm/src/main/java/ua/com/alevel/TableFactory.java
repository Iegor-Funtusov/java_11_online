package ua.com.alevel;

import org.reflections.Reflections;
import ua.com.alevel.annotations.PK;
import ua.com.alevel.annotations.Table;

import java.lang.reflect.Field;
import java.util.*;

public class TableFactory {

    private final Set<Class<?>> tableClasses;
    private List<String> queries = new ArrayList<>();

    public TableFactory(String packageName) {
        Reflections reflections = new Reflections(packageName);
        tableClasses = reflections.getTypesAnnotatedWith(Table.class);
    }

    public void initTable() {
        for (Class<?> tableClass : tableClasses) {
            List<Field> fields = getAllFields(tableClass, new ArrayList<>());
            fields.sort((o1, o2) -> {
                if (o2.isAnnotationPresent(PK.class)) {
                    return 1;
                }
                return -1;
            });
            queries.add(generateTable(tableClass, fields));
        }
    }

    public List<String> getQueries() {
        return queries;
    }

    private String generateTable(Class<?> tableClass, List<Field> fields) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table ");
        Table tableAnnotation = tableClass.getAnnotation(Table.class);
        String tableName = tableAnnotation.name();
        if (!tableName.isBlank()) {
            stringBuilder.append(tableName);
        } else {
            stringBuilder.append(tableClass.getSimpleName().toLowerCase());
        }
        stringBuilder.append(" (");

        for (Field field : fields) {
            if (field.isAnnotationPresent(PK.class)) {
                if (field.getType().isAssignableFrom(Long.class)) {
                    stringBuilder.append(field.getName());
                    stringBuilder.append(" bigint auto_increment primary key not null,");
                }
                if (field.getType().isAssignableFrom(Integer.class)) {
                    stringBuilder.append(field.getName());
                    stringBuilder.append(" int auto_increment primary key not null, ");
                }
            } else {
                if (field.getType().isAssignableFrom(String.class)) {
                    stringBuilder.append(field.getName());
                    stringBuilder.append(" varchar(255), ");
                }
                if (field.getType().isAssignableFrom(Integer.class)) {
                    stringBuilder.append(field.getName());
                    stringBuilder.append(" int, ");
                }
                if (field.getType().isAssignableFrom(Long.class)) {
                    stringBuilder.append(field.getName());
                    stringBuilder.append(" bigint, ");
                }
            }
        }
        String query = stringBuilder.toString();
        int index = query.lastIndexOf(",");
        query = query.substring(0, index);
        query = query + ")";
        return query;
    }

    private List<Field> getAllFields(Class<?> tableClass, List<Field> fields) {
        Class<?> superclass = tableClass.getSuperclass();
        if (superclass != null) {
            getAllFields(superclass, fields);
        }
        fields.addAll(Arrays.asList(tableClass.getDeclaredFields()));
        return fields;
    }
}
