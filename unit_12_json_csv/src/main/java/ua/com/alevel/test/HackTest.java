package ua.com.alevel.test;

import ua.com.alevel.dto.StudentDto;

import java.lang.reflect.Field;
import java.util.UUID;

public class HackTest {

    public void test() {
        StudentDto studentDto = new StudentDto(
                UUID.randomUUID().toString(),
                "John Doe",
                30
        );
        System.out.println("studentDto = " + studentDto);

        Class<?> studentClass = studentDto.getClass();
        Field[] fields = studentClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("id")) {
                field.setAccessible(true);
                try {
                    field.set(studentDto, UUID.randomUUID().toString());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("studentDto = " + studentDto);
    }
}
