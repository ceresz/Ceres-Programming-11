import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

       School school1 = new School(new ArrayList<>(), new ArrayList<>(), "University Hill", "High School");
       Student student1 = new Student("Mary", "Li", 1);
       Student student2 = new Student("John", "Smith", 2);
       Student student3 = new Student("Barry", "Lu", 3);
       Student student4 = new Student("Liesel", "Humphrey", 4);
       Student student5 = new Student("Rudy", "Mills", 5);
       Student student6 = new Student("Will", "Meyers", 6);
       Student student7 = new Student("Susie", "Zhang", 7);
       Student student8 = new Student("Chris","Baker",8);
       Student student9 = new Student("Billy", "Jean", 9);
       Student student10 = new Student("Tom","Harmon",10);

        school1.addStudent(student1);
        school1.addStudent(student2);
        school1.addStudent(student3);
        school1.addStudent(student4);
        school1.addStudent(student5);
        school1.addStudent(student6);
        school1.addStudent(student7);
        school1.addStudent(student8);
        school1.addStudent(student9);
        school1.addStudent(student10);


        Teacher teacher1 = new Teacher("John", "Yetmen", "Law");
        Teacher teacher2 = new Teacher("Karen", "Reed", "Math");
        Teacher teacher3 = new Teacher("David", "Matthews", "French");

        school1.addTeacher(teacher1);
        school1.addTeacher(teacher2);
        school1.addTeacher(teacher3);

        school1.showStudents();
        System.out.println();
        school1.showTeachers();

        school1.removeStudent(student1);
        school1.removeStudent(student2);
        school1.removeTeacher(teacher1);

        System.out.println();
        System.out.println();

        school1.showStudents();
        System.out.println();
        school1.showTeachers();

    }

}
