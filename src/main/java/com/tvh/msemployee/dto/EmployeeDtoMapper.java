package com.tvh.msemployee.dto;

import com.tvh.msemployee.domain.Employee;

import java.time.LocalDate;

public class EmployeeDtoMapper {

    public EmployeeDto mapToDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId().toString())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .active(employee.isActive())
                .dateInService(employee.getDateInService().toString())
                .employeeNumber(employee.getEmployeeNumber())
                .wage(employee.getWage().toString())
                .build();
    }

    public Employee mapToEmployee(EmployeeDto dto){
        return Employee.builder()
                .id(Integer.valueOf(dto.getId()))
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .active(dto.isActive())
                .dateInService(LocalDate.parse(dto.getDateInService()))
                .employeeNumber(dto.getEmployeeNumber())
                .wage(Double.valueOf(dto.getWage()))
                .build();
    }
}
