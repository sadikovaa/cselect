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
            select e from Employee e
                    left join fetch e.departments
            """)
    List<Employee> findAllFetchDepartments();
}
