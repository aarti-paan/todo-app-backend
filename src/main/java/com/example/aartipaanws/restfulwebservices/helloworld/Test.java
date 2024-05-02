package com.example.aartipaanws.restfulwebservices.helloworld;


import java.time.*;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.*;

public class Test {
    public static void main(String args[]){
        String s = "aartipaan";
        String[] s1 =s.split("");
        System.out.println(s1[0]);
        int freq=0;
       Map<String,Long> countmap =  stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(),counting()));
       //System.out.print(countmap);

       Map<Character,Long> map = s.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(Function.identity(),counting()));
    map.forEach((c,f) -> System.out.println(c  + ": " + f));
        List<Employee> employees = Stream.of(
                new Employee(1, "aarti","DEV",50000),
                new Employee(2, "Basant","DEV",80000),
                new Employee(3, "anjali","QA",60000),
                new Employee(4, "arjun","QA",90000),
                new Employee(5, "hemant","DEVOPS",40000)
        ).collect(Collectors.toList());

//        Comparator<Employee> CompareBySalary = Comparator.comparing(Employee::getSalary);
//        Map<String, Optional<Employee>> employeeMap =  employees.stream()
//                .collect(
//                        Collectors.groupingBy(Employee::getDept,Collectors.reducing(BinaryOperator.maxBy(CompareBySalary)))
//                );
//    System.out.println(employeeMap);


      Map<String,Employee> employeeMap1 =  employees.stream().collect(Collectors.groupingBy(Employee::getDept, collectingAndThen(maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
       // System.out.println(employeeMap1);


        LocalDate date = LocalDate.now();
        System.out.println("Current Date: " + date);

        // LocalTime example
        LocalTime time = LocalTime.now();
        System.out.println("Current Time: " + time);

        // LocalDateTime example
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + dateTime);

        // ZonedDateTime example
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Current Date and Time with Timezone: " + zonedDateTime);

        // Instant example
        Instant instant = Instant.now();
        System.out.println("Current Instant (UTC): " + instant);

        // Duration example
        Duration duration = Duration.ofMinutes(30);
        System.out.println("Duration of 30 minutes: " + duration);

        // Period example
        Period period = Period.ofMonths(6);
        System.out.println("Period of 6 months: " + period);
    }



}


