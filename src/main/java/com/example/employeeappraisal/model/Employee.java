package com.example.employeeappraisal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "rating")
    private char rate;
    
    @Transient
    private int rating;

    public Employee() {}

    public Employee(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    
    public char getRate() {
		return rate;
	}

	public void setRate(char rate) {
		this.rate = rate;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        if(this.rate=='A')
        	return 1;
        else if(this.rate=='B')
        	return 2;
        else if(this.rate=='C')
        	return 3;
        else if(this.rate=='D')
        	return 4;
        else
        	return 5;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}