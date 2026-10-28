package com.logicalCodinTest.emp.logical;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeAllLogicalTest {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Employee employee = new Employee(1, "Rajan", "Ranchi", LocalDate.of(1982, 2, 20), 45000,31);

        Employee employee2 = new Employee(
                1,
                "Rajan",
                "Ranchi",
                LocalDate.of(1993, 1, 21),
                30000,35
        );
        List<Employee> employeeList = Arrays.asList(new Employee(1, "Rajan", "Ranchi", LocalDate.of(1982, 2, 20), 45000,23),
                new Employee(1, "Rajan", "Ranchi", LocalDate.of(1982, 2, 27), 45000,24),
                new Employee(2, "Ravi", "Patana", LocalDate.of(1983, 4, 22), 45067,38),
                new Employee(3, "Rahul", "Ranchi", LocalDate.of(1984, 3, 25), 50000,32),
                new Employee(4, "Suresh", "Delhi", LocalDate.of(1985, 5, 31), 60000,30),
                new Employee(1, "Rajan", "Ranchi", LocalDate.of(1982, 2, 20), 45000,40)
        );

        //Q1. Find Employee max salary
        Employee maxSal = employeeList.stream()
                .max(Comparator.comparing(Employee::getEmpSal)).orElse(null);
        // System.out.println(maxSal.getEmpSal());//if only salary want to display
        //System.out.println(maxSal);

        //Q2. Increase the salary by 10 %
//        employeeList.forEach(emp -> emp.setEmpSal(emp.getEmpSal() * 1.10));
//        System.out.println("Printed....");
//        employeeList.forEach(System.out::println);

        //Q3. Find Second Highest salary of Employee
        Employee secondHighestSal = employeeList.stream().sorted(Comparator.comparing(Employee::getEmpSal)
                .reversed()).skip(1).findFirst().orElseThrow(null);
        System.out.println(secondHighestSal);

        //Q4. Group Employee by City
        Map<String, List<Employee>> groupEmpByCity = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAdd));
        //System.out.println(groupEmpByCity);

        //Q5.Count Employee in each city based on address
        Map<String, Long> empCoundBasedOnCity = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAdd, Collectors.counting()));
        //System.out.println(empCoundBasedOnCity);

        //Q5 Find the employee whose salary is greater than 20000

        List<Employee> empSlaGreaterThan = employeeList.stream().filter(e -> e.getEmpSal() > 45000)
                .collect(Collectors.toList());
        System.out.println(empSlaGreaterThan);

        //Find the duplicate employee names
        Set<String> names = new HashSet<>();
        employeeList.stream().map(Employee::getEmpName)
                .filter(item -> !names.add(item)).forEach(System.out::println);

        //Find the average salary of employee

        Double averageSalEmp = employeeList.stream()
                .collect(Collectors.averagingDouble(Employee::getEmpSal));
        System.out.println(averageSalEmp);

        //Find Employee sorted by salary descending order

        List<Employee> empSortedOrderBySal = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getEmpSal)
                        .reversed()).collect(Collectors.toList());
        System.out.println(empSortedOrderBySal);
        //2nd ways
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getEmpSal)
                        .reversed()).forEach(System.out::println);

        //Find the lowest salary of employee

        Employee lowestSal = employeeList.stream()
                .min(Comparator.comparing(Employee::getEmpSal)).orElse(null);
        System.out.println(lowestSal+"Lowest Salary");

        //Get city name without duplicate
        List<String> cityName = employeeList.stream()
                .map(Employee::getEmpAdd).distinct().toList();
        System.out.println(cityName);

        //Find the total salary of All the Employee

        double sumOfTotal = employeeList.stream().mapToDouble(Employee::getEmpSal).sum();
        System.out.println(sumOfTotal);

        //Find the City Having the Highest number of Employee

        Map.Entry<String,Long> cityOfHighestEmp = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAdd,Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByKey()).orElse(null);
        System.out.println(cityOfHighestEmp);

        //Find the Employee whose name start with 'R'

        employeeList.stream().filter(e->e.getEmpName().startsWith("R"))
                .forEach(System.out::println);

        //Find the Highest Paid employee in each city

        Map<String,Optional<Employee>> highPaidEmpBasedOnCity = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAdd,Collectors
                        .maxBy(Comparator.comparing(Employee::getEmpSal))));
        System.out.println(highPaidEmpBasedOnCity);

        //Find the Average salary city_wise

        Map<String,Double> avgEmpSalCityWise = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAdd,Collectors.averagingDouble(Employee::getEmpSal)));
        System.out.println(avgEmpSalCityWise);

        // Find Employee having salary greater than city Employee average salary
        Map<String,Double> averageSalMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAdd,Collectors.averagingDouble(Employee::getEmpSal)));
        List<Employee> result = employeeList.stream().filter(e->e.getEmpSal()>averageSalMap.get(e.getEmpAdd())).toList();
        System.out.println(result);

        //Find the Nth Highest Salary of employee

        int n= 3;
        Employee empNthHighestSal = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getEmpSal).reversed()).skip(n-1)
                .findFirst().orElse(null);
        System.out.println(empNthHighestSal);

        //Find the duplicate Employee  based on Employee Id.
        Set<Integer> ids = new HashSet<>();
        employeeList.stream().filter(e->!ids.add(e.getEmpId()))
                .forEach(System.out::println);

        //Convert List to Map

//        Map<Integer,Employee> listToMap = employeeList.stream()
//                .collect(Collectors.toMap(Employee::getEmpId,e->e));
//        System.out.println("List to Map"+listToMap);


        Map<Integer, Employee> listToMap = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getEmpId, e -> e, (existing, replacement) -> existing
                ));
        System.out.println("List to Map: " + listToMap);

        //Find the youngest employee
        Employee findYoungEmp = employeeList.stream()
                .min(Comparator.comparing(Employee::getEmpDOB)).orElse(null);
        System.out.println(findYoungEmp);

        //Find the top 3 Top Highest Pain employee
        List<Employee> top3HighestPaidEmp =employeeList.stream()
                .sorted(Comparator.comparing(Employee::getEmpSal).reversed()).limit(3).toList();
        System.out.println(top3HighestPaidEmp);

        //Find the employee with the longest name
        Employee empLongestName =employeeList.stream()
                .max(Comparator.comparing(e->e.getEmpName().length())).orElse(null);
        System.out.println(empLongestName);

        //Find All the employeeName in uppercase
        List<String> upperCase = employeeList.stream()
                .map(e->e.getEmpName().toUpperCase()).toList();
        System.out.println(upperCase);

        // Find the employee whose age is greater than 30
        List<Employee> empAge = employeeList.stream().filter(e -> e.getEmpAge() > 30).toList();
        System.out.println(empAge);

        //Find the count of employee in each department
        Map<String,Long> count = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAdd,Collectors.counting()));
        System.out.println(count);

        //Find the employee sorted by name and salary
         employeeList.stream()
                .sorted(Comparator.comparing(Employee::getEmpName).thenComparing(Employee::getEmpSal))
        .forEach(System.out::println);

         //Check All the Employee earn more than 20000
        boolean b = employeeList.stream().allMatch(employee1 -> employee1.getEmpSal()>20000);
        System.out.println(b);

        //Check if any employee belong to ranchi;
        boolean checkCity = employeeList.stream().anyMatch(e->"Ranchi".equals(e.getEmpAdd()));
        System.out.println(checkCity);

        //Find the employee with second-lowest salary
        Employee empSecondLowestSal = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getEmpSal))
                .skip(1).findFirst().orElse(null);
        System.out.println(empSecondLowestSal);

        //Get List of unique emp names
        List<String> uniqueName = employeeList.stream().map(Employee::getEmpName)
                .distinct().toList();
        System.out.println(uniqueName);

        //Find Sum of the salary City wise
        Map<String, Double> sum = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAdd, Collectors.summingDouble(Employee::getEmpSal)));
        System.out.println(sum);

        //Find the oldest employee
        Employee oldestEmp = employeeList.stream()
                .max(Comparator.comparing(Employee::getEmpAge)).orElse(null);
        System.out.println(oldestEmp);

        //Find the employee whose name contain Raj.
        List<Employee> nameWithRaj = employeeList.stream()
                .filter(e->e.getEmpName().contains("Rajan")).toList();
        System.out.println(nameWithRaj);

        //Convert List to Map<Id ,Name>
//        Map<Integer,String> listToMapConvert  = employeeList.stream()
//                .collect(Collectors.toMap(Employee::getEmpId,Employee::getEmpName));
//        System.out.println(listToMapConvert);

    }
}
