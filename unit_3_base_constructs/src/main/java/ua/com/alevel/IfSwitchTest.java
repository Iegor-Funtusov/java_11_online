package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IfSwitchTest {

    void test() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        isDigits(text);
        isContainsDigits(text);
        isContainsEvenOrNotEvenDigits(text);
        switchToExtensionDoc(text);
    }

    void isDigits(String text) {
        if (NumberUtils.isDigits(text)) {
            System.out.println("Is digits");
        } else {
            System.out.println("Is not digits");
        }
    }

    void isContainsDigits(String text) {
        if (StringUtils.containsAny(text,"1", "2", "3", "4", "5", "6", "7", "8", "9")) {
            System.out.println("Is contains digits");
        } else {
            System.out.println("Is not contains digits");
        }
    }

    void isContainsEvenOrNotEvenDigits(String text) {
        if (StringUtils.containsAny(text,"2", "4", "6", "8")) {
            System.out.println("Is contains even digits");
        } else if (StringUtils.containsAny(text,"1", "3", "5", "7", "9")) {
            System.out.println("Is contains not even digits");
        } else {
            System.out.println("Is not contains digits");
        }
    }

    void switchToExtensionDoc(String text) {
        if (text.endsWith(".docx")) {
            System.out.println("Is microsoft document");
        } else if (text.endsWith(".pdf")) {
            System.out.println("Is PDF document");
        } else if (text.endsWith(".xml")) {
            System.out.println("Is XML document");
        } else {
            System.out.println("Invalid extension");
        }

        switch (text) {
            case ".docx" -> System.out.println("Is microsoft document");
            case ".pdf" -> System.out.println("Is PDF document");
            case ".xml" -> System.out.println("Is XML document");
            default -> System.out.println("Invalid extension");
        }
    }
}
