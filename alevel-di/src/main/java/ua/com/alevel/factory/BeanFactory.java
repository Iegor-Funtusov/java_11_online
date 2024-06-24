package ua.com.alevel.factory;

import org.reflections.Reflections;
import org.reflections.Store;
import ua.com.alevel.annotations.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.reflections.scanners.Scanners.TypesAnnotated;

public class BeanFactory {

    private final Map<Class<?>, Object> beans = new HashMap<>();
    private final Reflections scanner;

    public BeanFactory(final Reflections scanner) {
        this.scanner = scanner;
    }

    public void initBeans() {
        Store store = scanner.getStore();
        Set<String> beanNames = new HashSet<>();
        store.forEach((k, v) -> {
            if (k.equals(TypesAnnotated.name())) {
                v.forEach((key, value) -> {
                    if (key.equals(Service.class.getName())) {
                        if (value != null && !value.isEmpty()) {
                            beanNames.addAll(value);
                        }
                    }
                });
            }
        });
        beanNames.forEach(beanName -> {
            try {
                Class<?> beanClass = Class.forName(beanName);
                Object bean = beanClass.getDeclaredConstructor().newInstance();

                Class<?>[] interfaces = beanClass.getInterfaces();
                if (interfaces.length > 0) {
                    beans.put(interfaces[0], bean);
                } else {
                    beans.put(beanClass, bean);
                }
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Map<Class<?>, Object> getBeans() {
        return beans;
    }
}
