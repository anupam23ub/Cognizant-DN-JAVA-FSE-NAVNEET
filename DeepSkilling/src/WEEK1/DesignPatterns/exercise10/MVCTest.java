package WEEK1.DesignPatterns.exercise10;

public class MVCTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Navneet");
        student.setId("S101");
        student.setGrade("B");

        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A");

        controller.updateView();
    }
}
