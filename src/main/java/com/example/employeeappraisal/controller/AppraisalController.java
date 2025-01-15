// Appraisal Controller
package com.example.employeeappraisal.controller;

import com.example.employeeappraisal.model.Employee;
import com.example.employeeappraisal.model.RatingCategory;
import com.example.employeeappraisal.service.AppraisalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/appraisal")
public class AppraisalController {

    @Autowired
    private AppraisalService appraisalService;

    @GetMapping("/percentages")
    public Map<RatingCategory, Double> getActualPercentages() {
        return appraisalService.calculateActualPercentage();
    }

    @GetMapping("/deviation")
    public Map<RatingCategory, Double> getDeviation() {
        return appraisalService.calculateDeviation();
    }

    @GetMapping("/suggestions")
    public List<Employee> getSuggestedAdjustments() {
        return appraisalService.suggestRatingAdjustments();
    }
    
}
