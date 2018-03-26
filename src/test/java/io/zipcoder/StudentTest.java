package io.zipcoder;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest {
    private Double[] testScores = {100.0, 99.0, 98.0};

    @Test
    public void testGetFirstName() {
        Student student = new Student("Dominique", "Clarke", testScores);

        String expected = "Dominique";
        String actual = student.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLastName() {
        Student student = new Student("Dominique", "Clarke", testScores);

        String expected = "Clarke";
        String actual = student.getLastName();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberOfExams() {
        Student student = new Student("Dominique", "Clarke", testScores);

        int expected = 3;
        int actual = student.getNumberOfExams();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetExamScores() {
        Student student = new Student("Dominique", "Clarke", testScores);

        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 99\n" +
                "\tExam 3 -> 98";
        String actual = student.getExamScores();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddExamScore1() {
        testScores = new Double[0];
        Student student = new Student("Dominique", "Clarke", testScores);

        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100";
        String actual = student.addExamScore(100.0);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddExamScore2() {
        Student student = new Student("Dominique", "Clarke", testScores);

        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 99\n" +
                "\tExam 3 -> 98\n" +
                "\tExam 4 -> 100";
        String actual = student.addExamScore(100.0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSetExamScore() {
        Student student = new Student("Dominique", "Clarke", testScores);

        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 99\n" +
                "\tExam 3 -> 100";
        String actual = student.setExamScore(3, 100.0);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageExamScore() {
        Student student = new Student("Dominique", "Clarke", testScores);

        double expected = 99;
        double actual = student.getAverageExamScore();
        assertEquals(expected, actual, .01);
    }

    @Test
    public void testToString() {
        Student student = new Student("Dominique", "Clarke", testScores);

        String expected = "Student Name: Dominique Clarke\n" +
                "> Average Score: 99\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 99\n" +
                "\tExam 3 -> 98";
        String actual = student.toString();
        assertEquals(expected, actual);
    }
}