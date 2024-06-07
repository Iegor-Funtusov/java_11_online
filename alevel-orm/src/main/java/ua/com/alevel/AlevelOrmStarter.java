package ua.com.alevel;

public class AlevelOrmStarter {

    public static void run(Class<?> mainClass) {
        TableFactory factory = new TableFactory(mainClass.getPackageName());
        factory.initTable();
        TableGenerator generator = new TableGenerator();
        generator.generateTables(factory.getQueries());
    }
}
