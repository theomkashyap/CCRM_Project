package edu.ccrm.domain;

public enum Grade {
    S(10.0),
    A(9.0),
    B(8.0),
    C(7.0),
    D(6.0),
    E(5.0),
    F(0.0),
    N(0.0); // N for Not Graded Yet

    private final double gradePoint;

    Grade(double gradePoint) {
        this.gradePoint = gradePoint;
    }

    public double getGradePoint() {
        return gradePoint;
    }
}