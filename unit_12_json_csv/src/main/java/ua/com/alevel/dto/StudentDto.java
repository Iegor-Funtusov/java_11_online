package ua.com.alevel.dto;

// immutable data class
public record StudentDto(String id, String fullName, Integer age) { }

//public class StudentDto {
//
//    private final String id;
//    private final String fullName;
//    private final Integer age;
//
//    public StudentDto(String id, String fullName, Integer age) {
//        this.id = id;
//        this.fullName = fullName;
//        this.age = age;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    @Override
//    public String toString() {
//        return "StudentDto{" +
//                "id='" + id + '\'' +
//                ", fullName='" + fullName + '\'' +
//                ", age=" + age +
//                '}';
//    }
}