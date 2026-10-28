package com.logicalCodinTest.emp.logical;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EmpTest {
    public static void main(String[] args) {
        List<Employee> empList = Arrays.asList(new Employee(1, "Rajan", "Ranchi", LocalDate.of(1982, 2, 20), 45000, 55),
                new Employee(1, "Rajan", "Ranchi", LocalDate.of(1982, 2, 27), 45000, 50),
                new Employee(2, "Ravi", "Patana", LocalDate.of(1983, 4, 22), 45067, 45),
                new Employee(3, "Rahul", "Ranchi", LocalDate.of(1984, 3, 25), 50000, 35),
                new Employee(4, "Suresh", "Delhi", LocalDate.of(1985, 5, 31), 60000, 32),
                new Employee(1, "Rajan", "Ranchi", LocalDate.of(1982, 2, 20), 45000, 23)

        );

        //Find the max sal of employ

    }
}
