package com.logicalCodinTest.emp.logical;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private int empId;
    private String empName;
    private String empAdd;
    private LocalDate empDOB;
    private double empSal;
    private Integer empAge;

}
