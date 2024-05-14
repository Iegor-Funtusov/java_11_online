package ua.com.alevel;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.IOException;

// OS -> RW, PL -> CRUD (R = R, W = CUD)
public class IOTest {

    public void test() {
//        createFile();
//        createDir();
//        createDirs();
//        renameFile();
//        deleteFile();
        deleteDir();
//        readDir();
    }

    private void createFile() {
        File file = new File(IOUtil.TEST_FILE.getFileName());
        try {
            if (!file.exists()) {
                boolean isCreatedFile = file.createNewFile();
                System.out.println("isCreatedFile = " + isCreatedFile);
            }
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }

    private void createDir() {
        File file = new File(IOUtil.TEST_DIR.getFileName());
        if (!file.exists()) {
            boolean isCreatedDir = file.mkdir();
            System.out.println("isCreatedDir = " + isCreatedDir);
        }
    }

    private void createDirs() {
        File file = new File(IOUtil.TEST_DIRS.getFileName());
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
        if (!file.exists()) {
            boolean isCreatedDir = file.mkdirs();
            System.out.println("isCreatedDir = " + isCreatedDir);
        }
    }

    private void renameFile() {
        File file = new File(IOUtil.TEST_FILE_UPDATE.getFileName());
        boolean isRenamed = file.renameTo(new File(IOUtil.TEST_FILE.getFileName()));
        System.out.println("isRenamed = " + isRenamed);
    }

    private void deleteFile() {
        File file = new File(IOUtil.TEST_FILE.getFileName());
        boolean delete = file.delete();
        System.out.println("delete = " + delete);
    }

    private void deleteDir() {
        File file = new File(IOUtil.TEST_DIR.getFileName());
//        boolean delete = file.delete();
//        System.out.println("delete = " + delete);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readDir() {
        File file = new File(IOUtil.TEST_DIR.getFileName());
        if (file.exists() && file.isDirectory()) {
            readRecursive(file);
        }
    }

    private void readRecursive(File dir) {
        System.out.println("dir = " + dir.getAbsolutePath());
        File[] files = dir.listFiles();
        if (ArrayUtils.isNotEmpty(files)) {
            for (File file : files) {
                if (file.isDirectory()) {
                    readRecursive(file);
                } else {
                    System.out.println("file = " + file.getAbsolutePath());
                }
            }
        }
    }
}
