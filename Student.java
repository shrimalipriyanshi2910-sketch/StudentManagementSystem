public class Student extends Person {

    private int rollNo;
    private String course;
    private double marks;

    public Student(int rollNo, String name, int age, String course, double marks) {
        super(name, age);

        this.rollNo = rollNo;
        this.course = course;

        if (marks < 0 || marks > 100) {
            this.marks = 0;
        } else {
            this.marks = marks;
        }
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    public String calculateGrade() {
        if (marks >= 80) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 40) return "C";
        else return "Fail";
    }

    @Override
public String toString() {
    return rollNo + "," + getName() + "," + getAgeSafe() + "," + course + "," + marks + "," + calculateGrade();
}

    public int getAgeSafe() {
        try {
            return super.getAge();
        } catch (Exception e) {
            return 0;
        }
    }
}