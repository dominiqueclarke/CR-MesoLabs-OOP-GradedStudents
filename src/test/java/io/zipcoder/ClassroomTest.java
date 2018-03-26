package io.zipcoder;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class ClassroomTest {
    private Double[] s1Scores = { 100.0, 150.0 };
    private Double[] s2Scores = { 225.0, 100.0 };

    private Student s1 = new Student("student", "one", this.s1Scores);
    private Student s2 = new Student("student", "two", this.s2Scores);

    private Student[] students = {s1, s2};

    @Test
    public void testClassroomDefaultConstructor() {
        Classroom classroom = new Classroom();

        int expected = classroom.getStudents().length;
        int actual = 30;

        assertEquals(expected, actual);
    }

    @Test
    public void testClassroomSizeConstructor() {
        // Given
        int n = 15;
        int expected = n;

        // When
        Classroom classroom = new Classroom(n);

        // Then
        int actual = classroom.getStudents().length;
        assertEquals(expected, actual);
    }

    @Test
    public void testClassroomArrayConstructor() {
        // Given
        int expected = 2;

        // When
        Classroom classroom = new Classroom(this.students);

        // Then
        int actual = classroom.getStudents().length;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetStudents() {
        // Given
        Student[] expected = this.students;

        // When
        Classroom classroom = new Classroom(this.students);

        // Then
        Student[] actual = classroom.getStudents();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetAverageExamScore() {
        // Given
        double expected = 143.75;

        // When
        Classroom classroom = new Classroom(this.students);

        // Then
        double actual = classroom.getAverageExamScore();
        assertEquals(expected, actual, .01);
    }

    @Test
    public void testAddStudent() {
        // Given
        int maxNumberOfStudents = 1;
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        String expected = "[Student Name: Leon Hunter\n" +
                "> Average Score: 125\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 150\n" +
                "\tExam 3 -> 250\n" +
                "\tExam 4 -> 0]";

        // When
        Classroom classroom = new Classroom(maxNumberOfStudents);
        classroom.addStudent(student);

        //Then
        String actual = Arrays.toString(classroom.getStudents());
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveStudent() {
        // Given
        String expected = "[Student Name: student two\n" +
                "> Average Score: 162.5\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 225\n" +
                "\tExam 2 -> 100" +
                ", null]";

        // When
        Classroom classroom = new Classroom(this.students);
        classroom.removeStudent("student", "one");

        // Then
        String actual = Arrays.toString(classroom.getStudents());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetStudentsByScore() {
        // Given
        Student[] expected = {this.s2, this.s1};

        // When
        Classroom classroom = new Classroom(this.students);

        // Then
        Student[] actual = classroom.getStudentsByScore();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetGradeBook() {
        // Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 150.0, 175.0 };
        Double[] s3Scores = { 175.0, 200.0 };
        Double[] s4Scores = { 200.0, 225.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);
        Student s4 = new Student("student", "four", s4Scores);

        Student[] students = {s1, s2, s3, s4};

        String expected = "{A=[Student Name: student four\n" +
                "> Average Score: 212.5\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 200\n" +
                "\tExam 2 -> 225], B=[Student Name: student three\n" +
                "> Average Score: 187.5\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 175\n" +
                "\tExam 2 -> 200], C=[Student Name: student two\n" +
                "> Average Score: 162.5\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 150\n" +
                "\tExam 2 -> 175], D=[Student Name: student one\n" +
                "> Average Score: 125\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 150]}";

        // When
        Classroom classroom = new Classroom(students);

        // Then
        String actual = classroom.getGradeBook().toString();
        assertEquals(expected, actual);
    }
}

