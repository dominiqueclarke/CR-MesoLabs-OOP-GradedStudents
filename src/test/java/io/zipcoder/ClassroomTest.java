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
    public void testClassroom1() {
        Classroom classroom = new Classroom();

        int expected = classroom.getStudents().length;
        int actual = 30;

        assertEquals(expected, actual);
    }

    @Test
    public void testClassroom2() {
        int n = 15;
        Classroom classroom = new Classroom(n);

        int expected = classroom.getStudents().length;
        int actual = n;

        assertEquals(expected, actual);
    }

    @Test
    public void testClassroom3() {
        Classroom classroom = new Classroom(this.students);

        int expected = classroom.getStudents().length;
        int actual = 2;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetStudents() {
        Classroom classroom = new Classroom(this.students);

        Student[] expected = classroom.getStudents();
        Student[] actual = this.students;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetAverageExamScore() {
        Classroom classroom = new Classroom(this.students);

        double expected = classroom.getAverageExamScore();
        double actual = 143.75;

        assertEquals(expected, actual, .01);
    }

    @Test
    public void testAddStudent() {
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        classroom.addStudent(student);

        String expected = "[Student Name: Leon Hunter\n" +
         "> Average Score: 125\n" +
         "> Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 150\n" +
                "\tExam 3 -> 250\n" +
                "\tExam 4 -> 0]";
        String actual = Arrays.toString(classroom.getStudents());
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveStudent() {
        Classroom classroom = new Classroom(this.students);

        classroom.removeStudent("student", "one");

        String expected = "[Student Name: student two\n" +
        "> Average Score: 162.5\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 225\n" +
                "\tExam 2 -> 100" +
                ", null]";
        String actual = Arrays.toString(classroom.getStudents());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetStudentsByScore() {
        Classroom classroom = new Classroom(this.students);

        Student[] expected = {this.s2, this.s1};
        Student[] actual = classroom.getStudentsByScore();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetGradeBook() {
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 150.0, 175.0 };
        Double[] s3Scores = { 175.0, 200.0 };
        Double[] s4Scores = { 200.0, 225.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);
        Student s4 = new Student("student", "four", s4Scores);

        Student[] students = {s1, s2, s3, s4};

        Classroom classroom = new Classroom(students);

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
        String actual = classroom.getGradeBook().toString();

        assertEquals(expected, actual);
    }
}

