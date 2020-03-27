package com.tvh.msemployee.infrastructure;

import com.tvh.msemployee.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class )
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    public List<Employee> getAllByFirstNameIgnoreCase(String name);
}
