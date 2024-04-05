package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CircleTest {

    void test() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        forTest(text);
    }

    void forTest(String text) {
        char[] charArray = text.toCharArray();
        int countBigChars = 0;
        for (int i = 0; i < charArray.length; i++) {
            int val = charArray[i];
            if (val >= 65 && val <= 90) {
                countBigChars++;
            }
        }
        System.out.println("countBigChars = " + countBigChars);

        int countOfChars = 0;
        countBigChars = 0;
        while (countOfChars < charArray.length) {
            int val = charArray[countOfChars];
            if (val >= 65 && val <= 90) {
                countBigChars++;
            }
            countOfChars++;
        }

        System.out.println("countBigChars = " + countBigChars);
    }
}
