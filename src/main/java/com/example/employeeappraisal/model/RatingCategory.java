// Rating Category Enum
package com.example.employeeappraisal.model;

public enum RatingCategory {
    OUTSTANDING(1, "A"),
    VERY_GOOD(2, "B"),
    GOOD(3, "C"),
    NEED_TO_IMPROVE(4, "D"),
    LOW_PERFORMER(5, "E");

    private final int value;
    private final String label;

    RatingCategory(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}