//Student Class contains 4 fields: first name, last name, grade and student number
public class Student {
    private String firstName;
    private String lastName;
    int grade;
    static int studentNumber = 0;

    public Student(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        studentNumber = studentNumber + 1;
    }

    // Getter
    public String getFirstName() {
        return firstName;
    }

    // Setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter
    public String getLastName() {
        return lastName;
    }

    // Setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter
    public int gerGrade() {
        return grade;
    }

    // Setter
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public static int getStudentNumber() {
        return studentNumber;
    }

    public static void setStudentNumber(int studentNumber) {
        Student.studentNumber = studentNumber;
    }
    @Override
    public String toString(){
        return "Name: " + firstName + " " + lastName + " Grade: " + grade;
    }

}
