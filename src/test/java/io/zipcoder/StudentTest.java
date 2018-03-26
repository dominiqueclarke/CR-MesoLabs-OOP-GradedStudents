package io.zipcoder;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest {
    private Double[] testScores = {100.0, 99.0, 98.0};

    @Test
    public void testGetFirstName() {
        // Given
        String expected = "Dominique";

        // When
        Student student = new Student("Dominique", "Clarke", this.testScores);

        // Then
        String actual = student.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLastName() {
        // Given
        String expected = "Clarke";

        // When
        Student student = new Student("Dominique", "Clarke", this.testScores);

        // Then
        String actual = student.getLastName();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberOfExams() {
        // Given
        int expected = 3;

        // When
        Student student = new Student("Dominique", "Clarke", this.testScores);

        // Then
        int actual = student.getNumberOfExams();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetExamScores() {
        // Given
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 99\n" +
                "\tExam 3 -> 98";

        // When
        Student student = new Student("Dominique", "Clarke", this.testScores);

        // Then
        String actual = student.getExamScores();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddExamScore1() {
        // Given
        Double[] testScores = new Double[0];
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100";

        // When
        Student student = new Student("Dominique", "Clarke", testScores);

        // Then
        String actual = student.addExamScore(100.0);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddExamScore2() {
        // Given
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 99\n" +
                "\tExam 3 -> 98\n" +
                "\tExam 4 -> 100";

        // When
        Student student = new Student("Dominique", "Clarke", this.testScores);

        // Then
        String actual = student.addExamScore(100.0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSetExamScore() {
        // Given
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 99\n" +
                "\tExam 3 -> 100";

        // When
        Student student = new Student("Dominique", "Clarke", this.testScores);

        // Then
        String actual = student.setExamScore(3, 100.0);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageExamScore() {
        // Given
        double expected = 99;

        // When
        Student student = new Student("Dominique", "Clarke", this.testScores);

        // Then
        double actual = student.getAverageExamScore();
        assertEquals(expected, actual, .01);
    }

    @Test
    public void testToString() {
        // Given
        String expected = "Student Name: Dominique Clarke\n" +
                "> Average Score: 99\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 99\n" +
                "\tExam 3 -> 98";

        // When
        Student student = new Student("Dominique", "Clarke", this.testScores);

        // Then
        String actual = student.toString();
        assertEquals(expected, actual);
    }
}