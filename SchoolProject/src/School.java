import java.util.ArrayList;
import java.util.Arrays;

//School class contains an arraylist of teachers, students, and courses.
// It has 3 fields; school name, school type and school number.
public class School {
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private String schoolName;
    private static int schoolNumber;
    private String schoolType;
    private ArrayList<String> courses = new ArrayList<>(3);

    public School(ArrayList<Teacher> teachers, ArrayList<Student> students, String schoolName, String schoolType) {
        this.teachers = teachers;
        this.students = students;
        this.schoolName = schoolName;
        this.schoolType = schoolType;
        this.courses.add("English");
        this.courses.add("Math");
        this.courses.add("Science");
        schoolNumber++;
    }
    public ArrayList<String> getCourses() {
        return courses;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    //method to add teacher to list
    public void addTeacher(Teacher add){
        teachers.add(add);
    }

    //method to delete teacher from list
    public void removeTeacher(Teacher delete){
        teachers.remove(delete);
    }

    //method to add student to list
    public void addStudent(Student add){
        students.add(add);
    }

    //method to delete student from list
    public void removeStudent(Student delete){
        students.remove(delete);
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public static int getSchoolNumber() {
        return schoolNumber;
    }

    public static void setSchoolNumber(int schoolNumber) {
        School.schoolNumber = schoolNumber;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    //method to show all students
    public void showStudents(){
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    //method to show all teachers
    public void showTeachers(){
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println(teachers.get(i));
        }
    }

}