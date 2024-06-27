package ua.com.alevel.configurator;

import ua.com.alevel.annotations.Config;
import ua.com.alevel.annotations.Dependency;
import ua.com.alevel.annotations.PostConstruct;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;

public class BeanConfigurator {

    private final Map<Class<?>, Object> beans;
    private final Map<String, String> configMap;

    public BeanConfigurator(final Map<Class<?>, Object> beans, final Map<String, String> configMap) {
        this.beans = beans;
        this.configMap = configMap;
    }

    public void configure() {
        Collection<Object> beanObjectList = beans.values();
        beanObjectList.forEach(bean -> {
            Class<?> beanClass = bean.getClass();
            Field[] declaredFields = beanClass.getDeclaredFields();
            for (Field field : declaredFields) {
                injectDependency(field, bean);
                injectConfig(field, bean);
            }

            Method[] declaredMethods = beanClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                runPostConstruct(method, bean);
            }
        });
    }

    private void injectDependency(Field field, Object bean) {
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

    private void injectConfig(Field field, Object bean) {
        if (field.isAnnotationPresent(Config.class)) {
            Config config = field.getAnnotation(Config.class);
            String value = config.value();
            if (Modifier.isPrivate(field.getModifiers()) || Modifier.isProtected(field.getModifiers())) {
                field.setAccessible(true);
            }
            try {
                field.set(bean, configMap.get(value));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void runPostConstruct(Method method, Object bean) {
        if (method.isAnnotationPresent(PostConstruct.class)) {
            method.setAccessible(true);
            try {
                method.invoke(bean);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
