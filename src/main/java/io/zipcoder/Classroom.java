package io.zipcoder;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeMap;

public class Classroom {
    private Student[] students;

    public Classroom() {
        this(30);
    }

    public Classroom(int n) {
        this.students = new Student[n];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return this.students;
    }

    public double getAverageExamScore() {
        double sum = 0;

        for (Student student : this.students) {
            sum += student.getAverageExamScore();
        }

        return sum / this.students.length;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < this.students.length; ++i) {
            if (this.students[i] == null) {
                this.students[i] = student;
                return;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < this.students.length; ++i) {
            if (this.students[i] != null && this.students[i].getFullName().equals(firstName + " " + lastName)) {
                this.students[i] = null;
            }
        }

        Arrays.sort(this.students, new StudentComparator());

        return;
    }

    public Student[] getStudentsByScore() {
        Arrays.sort(this.students, new StudentComparator());

        return this.students;
    }

    public TreeMap<Character, ArrayList<Student>> getGradeBook() {
        Student[] students = getStudentsByScore();
        TreeMap<Character, ArrayList<Student>> gradeBook = new TreeMap<>();

        for (int i = 0; i < students.length; ++i) {
            double numOfStudents = students.length;
            Character gradeLetter;

            double fIndex = Math.ceil(.9 * numOfStudents);
            double dIndex = Math.ceil(.51 * numOfStudents);
            double cIndex = Math.ceil(.3 * numOfStudents);
            double bIndex = Math.ceil(.11 * numOfStudents);

            if (i >= fIndex) { gradeLetter = 'F'; }
            else if (i >= dIndex) { gradeLetter = 'D'; }
            else if (i >= cIndex) { gradeLetter = 'C'; }
            else if (i >= bIndex) { gradeLetter = 'B'; }
            else { gradeLetter = 'A'; }

            if (!gradeBook.containsKey(gradeLetter)) {
                gradeBook.put(gradeLetter, new ArrayList<>());
            }

            gradeBook.get(gradeLetter).add(students[i]);
        }

        return gradeBook;
    }


}
