package ru.kholopova.cselect.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kholopova.cselect.entity.Employee;
import ru.kholopova.cselect.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAllFetchDepartments() {
        return employeeRepository.findAllFetchDepartments();
    }

}
