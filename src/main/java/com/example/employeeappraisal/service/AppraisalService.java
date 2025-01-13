// Appraisal Logic Service
package com.example.employeeappraisal.service;

import com.example.employeeappraisal.model.Employee;
import com.example.employeeappraisal.model.RatingCategory;
import com.example.employeeappraisal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppraisalService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Map<RatingCategory, Double> STANDARD_PERCENTAGE = Map.of(
            RatingCategory.OUTSTANDING, 10.0,
            RatingCategory.VERY_GOOD, 20.0,
            RatingCategory.GOOD, 40.0,
            RatingCategory.NEED_TO_IMPROVE, 20.0,
            RatingCategory.LOW_PERFORMER, 10.0
    );

    public Map<RatingCategory, Double> calculateActualPercentage() {
        List<Employee> employees = employeeRepository.findAll();
        Map<RatingCategory, Long> ratingCounts = employees.stream()
                .collect(Collectors.groupingBy(
                        employee -> RatingCategory.values()[employee.getRating() - 1],
                        Collectors.counting()
                ));

        double totalEmployees = employees.size();
        return Arrays.stream(RatingCategory.values())
                .collect(Collectors.toMap(
                        category -> category,
                        category -> (ratingCounts.getOrDefault(category, 0L) / totalEmployees) * 100
                ));
    }

    public Map<RatingCategory, Double> calculateDeviation() {
        Map<RatingCategory, Double> actualPercentage = calculateActualPercentage();
        return STANDARD_PERCENTAGE.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> actualPercentage.getOrDefault(entry.getKey(), 0.0) - entry.getValue()
                ));
    }

    public List<Employee> suggestRatingAdjustments() {
        Map<RatingCategory, Double> deviation = calculateDeviation();
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .filter(employee -> deviation.get(RatingCategory.values()[employee.getRating() - 1]) > 0)
                .collect(Collectors.toList());
    }
}
