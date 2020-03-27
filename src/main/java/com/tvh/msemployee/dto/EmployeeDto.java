package com.tvh.msemployee.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class EmployeeDto {
    private String id;
    private String firstName;
    private String lastName;
    private String employeeNumber;
    private String dateInService;
    private boolean active;
    private String wage;
}
