package com.tvh.msemployee.application;

import com.tvh.msemployee.domain.Employee;
import com.tvh.msemployee.dto.EmployeeDto;
import com.tvh.msemployee.dto.EmployeeDtoMapper;
import com.tvh.msemployee.infrastructure.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    final EmployeeDtoMapper mapper = new EmployeeDtoMapper();

    final Employee testEmployee = Employee.builder()
            .id(0)
            .firstName("tester")
            .lastName("the second")
            .active(true)
            .dateInService(LocalDate.now())
            .employeeNumber("dto.getEmployeeNumber()")
            .wage(10.0)
            .build();

    Employee toUpdate = Employee.builder()
            .id(0)
            .firstName("not")
            .lastName("Updated")
            .active(true)
            .dateInService(LocalDate.now())
            .employeeNumber("dto.getEmployeeNumber()")
            .wage(10.0)
            .build();

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    public EmployeeServiceTest() {
    }

    @Test
    void getEmployeeByIdTest() {
        Mockito.doReturn(Optional.of(testEmployee)).when(repository).findById(0);
        EmployeeDto dto = service.getEmployeeById(0);
        Mockito.verify(repository).findById(0);
        assertAll("Dto should have same values as test",
                ()->assertEquals(dto.getId(),testEmployee.getId().toString()),
                ()->assertEquals(dto.getFirstName(),testEmployee.getFirstName()),
                ()->assertEquals(dto.getLastName(),testEmployee.getLastName()),
                ()->assertEquals(dto.getDateInService(),testEmployee.getDateInService().toString()),
                ()->assertEquals(dto.getEmployeeNumber(),testEmployee.getEmployeeNumber()),
                ()->assertEquals(dto.getWage(),testEmployee.getWage().toString()));
    }

    @Test
    void getEmployeeByNameTest() {
        Mockito.doReturn(List.of(testEmployee)).when(repository).getAllByFirstNameIgnoreCase("tester");
        service.getEmployeeByName("tester");
        Mockito.verify(repository).getAllByFirstNameIgnoreCase("tester");
    }

    @Test
    void updateEmployeeTest() {
        Mockito.when(repository.save(any(Employee.class))).thenReturn(toUpdate);
        toUpdate.setFirstName("Is");
        var returnedEmployee = service.updateEmployee(mapper.mapToDto(toUpdate));
        Mockito.verify(repository).save(any(Employee.class));
        assertEquals("Is",returnedEmployee.getFirstName());
    }
}
