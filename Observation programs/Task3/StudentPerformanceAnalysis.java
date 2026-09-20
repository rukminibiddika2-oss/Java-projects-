import java.util.*;

class Student {
    int rollNo;
    String name;
    int[] marks;

    Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    int calculateTotal() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    double calculateAverage() {
        return calculateTotal() / (double) marks.length;
    }

    int findHighest() {
        int highest = marks[0];

        for (int mark : marks) {
            highest = Math.max(highest, mark);
        }

        return highest;
    }

    int findLowest() {
        int lowest = marks[0];

        for (int mark : marks) {
            lowest = Math.min(lowest, mark);
        }

        return lowest;
    }

    double calculatePercentage() {
        return (calculateTotal() / (double) (marks.length * 100)) * 100;
    }

    String grade(double percentage) {
        if (percentage >= 90)
            return "A+";
        else if (percentage >= 80)
            return "A";
        else if (percentage >= 70)
            return "B";
        else if (percentage >= 60)
            return "C";
        else if (percentage >= 50)
            return "D";
        else
            return "F";
    }

    String remark(String grade) {
        if (grade.equals("A+"))
            return "Excellent Performance";
        else if (grade.equals("A"))
            return "Very Good Performance";
        else if (grade.equals("B"))
            return "Good Performance";
        else if (grade.equals("C"))
            return "Satisfactory Performance";
        else if (grade.equals("D"))
            return "Needs Improvement";
        else
            return "Fail - Needs Improvement";
    }

    void displayReport() {
        String formattedName = name.trim().toUpperCase();

        double percentage = calculatePercentage();

        double roundedPercentage =
                Math.round(percentage * 100.0) / 100.0;

        String gradeValue = grade(percentage);

        System.out.println("==============================================");
        System.out.println("       STUDENT PERFORMANCE ANALYSIS");
        System.out.println("==============================================");

        System.out.println("Roll Number : " + rollNo);
        System.out.println("Student Name: " + formattedName);
        System.out.println("Name Length : " + formattedName.length());
        System.out.println("Marks       : " + Arrays.toString(marks));
        System.out.println("Total Marks : " + calculateTotal()
                + "/" + (marks.length * 100));

        System.out.printf("Average     : %.2f%n", calculateAverage());

        System.out.println("Highest     : " + findHighest());
        System.out.println("Lowest      : " + findLowest());
        System.out.println("Percentage  : " + roundedPercentage + "%");
        System.out.println("Grade       : " + gradeValue);

        System.out.println("Result      : "
                + (percentage >= 50 ? "PASS" : "FAIL"));

        System.out.println("Remark      : " + remark(gradeValue));

        System.out.println("==============================================");
    }
}

public class StudentPerformanceAnalysis {

    public static void main(String[] args) {

        int[] marks = {92, 85, 78, 88, 95};

        Student student =
                new Student(101, "  Biddika Rukmini  ", marks);

        student.displayReport();
    }
}
