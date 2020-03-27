package com.tvh.msemployee.api;

import com.tvh.msemployee.application.EmployeeService;
import com.tvh.msemployee.dto.EmployeeDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    private EmployeeDtoMapper mapper = new EmployeeDtoMapper();

}
