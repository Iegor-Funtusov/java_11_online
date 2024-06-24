package ua.com.alevel;

import org.reflections.Reflections;
import ua.com.alevel.configurator.BeanConfigurator;
import ua.com.alevel.factory.BeanFactory;
import ua.com.alevel.starter.ApplicationStarter;

public class AlevelDiApplication {

    public static void run(Class<?> mainClass) {
        final Reflections scanner = new Reflections(mainClass.getPackageName());
        BeanFactory beanFactory = new BeanFactory(scanner);
        beanFactory.initBeans();
        BeanConfigurator beanConfigurator = new BeanConfigurator();
        beanConfigurator.configure(beanFactory.getBeans());
        ApplicationStarter starter = new ApplicationStarter();
        starter.start(beanFactory.getBeans().values());
    }
}
