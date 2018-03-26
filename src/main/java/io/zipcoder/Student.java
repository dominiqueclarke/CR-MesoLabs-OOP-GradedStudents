package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;
    private static final DecimalFormat decimalFormatter = new DecimalFormat("0.##");


    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<Double>(Arrays.asList(testScores));
    }

    public String getFirstName() { return this.firstName; }

    public String getLastName() { return this.lastName; }

    public String getFullName() { return this.firstName + " " + this.lastName; }

    public int getNumberOfExams() { return examScores.size(); }

    public String getExamScores() {
        StringBuilder builder = new StringBuilder("Exam Scores:");

        for(int i = 1; i <= examScores.size(); i++) {
            builder.append("\n\tExam " + i + " -> " + decimalFormatter.format(examScores.get(i - 1)));
        }

        return builder.toString();
    }

    public String addExamScore(double score) {
        this.examScores.add(score);
        return getExamScores();
    }

    public String setExamScore(int index, double score) {
        this.examScores.set(index - 1, score);
        return getExamScores();
    }

    public double getAverageExamScore() {
        double sum = 0;

        for(Double score : this.examScores) {
            sum += score;
        }

        return sum / this.examScores.size();
    }

    @Override
    public String toString() {
        return "Student Name: " + getFullName() + "\n" +
                "> Average Score: " + decimalFormatter.format(getAverageExamScore()) + "\n" +
                "> " + getExamScores();
    }
}
