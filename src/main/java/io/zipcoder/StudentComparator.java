package io.zipcoder;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    private boolean descendingOrderByScore;

    public StudentComparator() {
        this.descendingOrderByScore = true;
    }

    public StudentComparator(boolean isDescendingByScore) {
        this.descendingOrderByScore = isDescendingByScore;
    }

    @Override
    public int compare(Student s1, Student s2) {
        if (s1 == null) {
            return 1;
        }
        if (s2 == null) {
            return -1;
        }
        if (s1.getAverageExamScore() > s2.getAverageExamScore()) {
            return -1;
        }
        if (s2.getAverageExamScore() > s1.getAverageExamScore()) {
            return 1;
        }
        if(s1.getAverageExamScore() == s2.getAverageExamScore()) {
            return s1.getLastName().compareToIgnoreCase(s2.getLastName());
        }

        return 0;
    }
}
