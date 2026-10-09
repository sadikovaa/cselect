package ru.kholopova.cselect.util;

import lombok.experimental.UtilityClass;
import ru.kholopova.cselect.entity.Department;
import ru.kholopova.cselect.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class EmployeeFormatter {

    public static String toReadableString(List<Employee> employees) {
        return employees.stream().map(EmployeeFormatter::toReadableString).collect(Collectors.joining(",\n"));
    }

    public static String toReadableString(Employee employee) {
        StringBuilder builder = new StringBuilder("Employee {\n  ");

        builder
                .append("id=").append(employee.getId())
                .append(",fullname=").append(employee.getFullName())
                .append(",email=").append(employee.getEmail())
                .append(",birthDate=").append(employee.getBirthDate()) // todo возможно потребуется формотирование даты
                .append(",\n  departments=[")
                .append(employee.getDepartments().stream()
                        .map(EmployeeFormatter::toReadableString)
                        .collect(Collectors.joining(","))
                )
                .append("]\n")
                .append("}");
        return builder.toString();
    }

    private static String toReadableString(Department department) {
        StringBuilder builder = new StringBuilder("{id=");
        return builder
                .append(department.getId())
                .append(",name=")
                .append(department.getName())
                .append("}")
                .toString();
    }
}
