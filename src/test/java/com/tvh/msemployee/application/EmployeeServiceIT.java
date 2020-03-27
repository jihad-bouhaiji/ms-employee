package com.tvh.msemployee.application;

import com.tvh.msemployee.domain.Employee;
import com.tvh.msemployee.dto.EmployeeDto;
import com.tvh.msemployee.dto.EmployeeDtoMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(value = "com.tvh.msemployee.infrastructure")
@Import(EmployeeService.class)
public class EmployeeServiceIT extends AbstractTransactionalJUnit4SpringContextTests {

    private final EntityManager entityManager;

    private final EmployeeService service;

    public EmployeeServiceIT(EntityManager manager, EmployeeService service){
        this.entityManager = manager;
        this.service = service;
    }

    private final EmployeeDtoMapper mapper = new EmployeeDtoMapper();

    @Test
    void AddEmployeeAndRetrieveTest()
    {
        Employee toAdd =  Employee.builder()
                .id(0)
                .firstName("tester")
                .lastName("the second")
                .active(true)
                .dateInService(LocalDate.now())
                .employeeNumber("dto.getEmployeeNumber()")
                .wage(10.0)
                .build();
        EmployeeDto dto = service.updateEmployee(mapper.mapToDto(toAdd));
        entityManager.flush();
        Assertions.assertEquals(toAdd,mapper.mapToEmployee(dto));
    }

}


