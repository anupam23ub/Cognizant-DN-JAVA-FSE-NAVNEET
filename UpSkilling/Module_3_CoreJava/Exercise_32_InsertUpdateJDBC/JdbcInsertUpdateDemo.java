package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_32_InsertUpdateJDBC;

public class JdbcInsertUpdateDemo {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        dao.insertStudent(
                4,
                "Neha",
                19
        );

        dao.updateStudent(
                4,
                "Neha Patel",
                20
        );
    }
}