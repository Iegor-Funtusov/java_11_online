package ua.com.alevel.starter;

import ua.com.alevel.annotations.MainClass;
import ua.com.alevel.annotations.MainMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class ApplicationStarter {

    public void start(Collection<Object> beans) {
        List<Object> list = beans
                .stream()
                .filter(bean -> bean.getClass().isAnnotationPresent(MainClass.class))
                .toList();
        if (list.size() != 1) {
            throw new IllegalStateException("Application starter requires a MainClass annotation");
        }
        Object bean = list.getFirst();
        Class<?> beanClass = bean.getClass();
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        List<Method> mainMethodList = Stream.of(declaredMethods)
                .filter(declaredMethod -> declaredMethod.isAnnotationPresent(MainMethod.class))
                .toList();
        if (mainMethodList.size() != 1) {
            throw new IllegalStateException("Application starter requires a MainMethod annotation");
        }
        Method mainMethod = mainMethodList.getFirst();
        mainMethod.setAccessible(true);
        try {
            mainMethod.invoke(bean);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
