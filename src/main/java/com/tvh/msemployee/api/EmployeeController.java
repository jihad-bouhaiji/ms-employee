package com.tvh.msemployee.api;

import com.tvh.msemployee.application.EmployeeService;
import com.tvh.msemployee.domain.Employee;
import com.tvh.msemployee.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(){
        return service.getAllEmployees();

    }

    @GetMapping(value = "/employee/{id}", produces = "application/json")
    public EmployeeDto getEmployeeWithID(@PathVariable String id){
        return service.getEmployeeById(Integer.parseInt(id));
    }


    @GetMapping("/employee/new")
    public EmployeeDto addEmployeeWithName(@RequestParam String name){
        return addEmployee(name);
    }

    private EmployeeDto addEmployee(String name){
        Random random = new Random();
        EmployeeDto dto = EmployeeDto.builder()
                .id(Integer.toString(random.nextInt(10000000)))
                .firstName(name)
                .lastName(name+"lastname")
                .employeeNumber(name)
                .dateInService(LocalDate.now().toString())
                .active(true)
                .wage(Double.toString(10.0))
                .build();

        return service.updateEmployee(dto);
    }
}
