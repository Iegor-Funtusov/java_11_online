package ua.com.alevel;

import java.io.*;

public class IORWTest {

//    Reader reader;
//    Writer writer;
//
//    InputStream inputStream;
//    OutputStream outputStream;

    private File file;

    public void test() {
        createFile();
        read();
//        write();
    }

    private void read() {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        InputStreamReader isr = new InputStreamReader(System.in);

        // old style before java 7
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(file);
//            byte[] bytes = inputStream.readAllBytes();
//            for (int i = 0; i < bytes.length; i++) {
//                System.out.println("#:" + i + " --- " + bytes[i] + ": " + (char) bytes[i]);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

        // new style after java 7
        // read of bytes
        try(InputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = inputStream.readAllBytes();
            for (int i = 0; i < bytes.length; i++) {
                System.out.println("#:" + i + " --- " + bytes[i] + ": " + (char) bytes[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // read of string
        try(
//                InputStream inputStream = new FileInputStream(file);
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))
                ) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                System.out.println("line = " + line);
            }
        } catch (IOException e) {
            System.out.println("e = " + e);
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                System.out.println("line = " + line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void write() {
//        byte[] bytes = new byte[]{ 72, 101, 108, 108, 111 };
//        try(OutputStream outputStream = new FileOutputStream(file)) {
//            outputStream.write(bytes);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try(FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write("\n");
            fileWriter.write("Hello world");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFile() {
        file = new File(IOUtil.TEST_FILE.getFileName());
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }
}
