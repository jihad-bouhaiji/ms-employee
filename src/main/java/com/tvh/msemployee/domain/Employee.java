package com.tvh.msemployee.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees",schema = "msemployees")
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Employee {
    @Id
    @Column(name="employee_id")
    private Integer id;
    @Column(name = "first_name", columnDefinition = "VARCHAR(40)")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "VARCHAR(60)", nullable = false)
    private String lastName;
    @Column(name = "employee_number", columnDefinition = "VARCHAR(15)", unique = true)
    private String employeeNumber;
    @Column(name = "date_in_service", nullable = false)
    private LocalDate dateInService;

    private boolean active;

    @Column(nullable = false)
    private Double wage;
}
