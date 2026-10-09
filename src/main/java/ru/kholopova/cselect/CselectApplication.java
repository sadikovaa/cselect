package ru.kholopova.cselect;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kholopova.cselect.service.EmployeeService;
import ru.kholopova.cselect.util.EmployeeFormatter;

@RequiredArgsConstructor
@SpringBootApplication
public class CselectApplication implements CommandLineRunner {

    private final EmployeeService employeeService;

    public static void main(String[] args) {
		SpringApplication.run(CselectApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        var users = employeeService.findAllFetchDepartments();
        System.out.println(EmployeeFormatter.toReadableString(users));
    }
}
