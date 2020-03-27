package com.tvh.msemployee.application;

import com.tvh.msemployee.domain.Employee;
import com.tvh.msemployee.dto.EmployeeDto;
import com.tvh.msemployee.dto.EmployeeDtoMapper;
import com.tvh.msemployee.infrastructure.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {
    final EmployeeRepository repository;
    final EmployeeDtoMapper mapper = new EmployeeDtoMapper();

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void printServiceName() {
        System.out.println("EmployeeService");
    }

    public List<EmployeeDto> getAllEmployees(){
        return StreamSupport.stream(repository.findAll().spliterator(),false).map(mapper::mapToDto).collect(Collectors.toList());
    }

    public EmployeeDto getEmployeeById(int id){
        return mapper.mapToDto(repository.findById(id).orElse(new Employee()));
    }

    public List<EmployeeDto> getEmployeeByName(String name){
        return repository.getAllByFirstNameIgnoreCase(name).stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    public EmployeeDto updateEmployee(EmployeeDto employee){
        return mapper.mapToDto(repository.save(mapper.mapToEmployee(employee)));
    }

}
