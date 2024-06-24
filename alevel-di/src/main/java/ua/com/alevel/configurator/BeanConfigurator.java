package ua.com.alevel.configurator;

import ua.com.alevel.annotations.Dependency;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;

public class BeanConfigurator {

    public void configure(final Map<Class<?>, Object> beans) {
        Collection<Object> beanObjectList = beans.values();
        beanObjectList.forEach(bean -> {
            Class<?> beanClass = bean.getClass();
            Field[] declaredFields = beanClass.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(Dependency.class)) {
                    Class<?> fieldClass = field.getType();
                    Object beanObject = beans.get(fieldClass);
                    if (beanObject != null) {
                        if (Modifier.isPrivate(field.getModifiers()) || Modifier.isProtected(field.getModifiers())) {
                            field.setAccessible(true);
                        }
                        try {
                            field.set(bean, beanObject);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
    }
}
