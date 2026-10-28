package com.logicalCodinTest.emp.logical;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Department {
    private int deptId;
    private String deptName;
    private List<Employee> employees;
}
