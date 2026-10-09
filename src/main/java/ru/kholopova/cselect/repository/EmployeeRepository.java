package ru.kholopova.cselect.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kholopova.cselect.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("""
            SELECT e FROM Employee e
                    LEFT JOIN FETCH e.departments
            """)
    List<Employee> findAllFetchDepartments();
}
