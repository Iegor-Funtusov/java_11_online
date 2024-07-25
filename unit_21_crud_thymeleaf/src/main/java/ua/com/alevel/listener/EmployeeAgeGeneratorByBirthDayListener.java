package ua.com.alevel.listener;

import jakarta.persistence.PostLoad;
import ua.com.alevel.entity.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class EmployeeAgeGeneratorByBirthDayListener {

    @PostLoad
    public void generate(Employee employee) {
        if (employee.getBirthDay() != null) {
            LocalDate curDate = LocalDate.now();
            LocalDate birtDay = employee.getBirthDay().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            int age = Period.between(birtDay, curDate).getYears();
            employee.setAge(age);
        }
    }
}
