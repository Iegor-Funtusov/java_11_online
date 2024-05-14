package ua.com.alevel;

public enum IOUtil {

    TEST_FILE("test.txt"),
    TEST_FILE_UPDATE("test1.txt"),
    TEST_DIR("test"),
    TEST_DIRS("test/test1/test2");

    private final String fileName;

    IOUtil(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
