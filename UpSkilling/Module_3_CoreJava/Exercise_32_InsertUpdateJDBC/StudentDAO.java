package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_32_InsertUpdateJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/javafse";

    private static final String USERNAME =
            "root";

    private static final String PASSWORD =
            "root";

    public void insertStudent(
            int id,
            String name,
            int age) {

        String sql =
                "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";

        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            Connection connection =
                    DriverManager.getConnection(
                            URL,
                            USERNAME,
                            PASSWORD);

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            int rows = ps.executeUpdate();

            System.out.println(
                    rows + " record inserted."
            );

            ps.close();
            connection.close();

        } catch (Exception e) {

            System.out.println(
                    "Insert Error: "
                            + e.getMessage()
            );
        }
    }

    public void updateStudent(
            int id,
            String newName,
            int newAge) {

        String sql =
                "UPDATE students SET name=?, age=? WHERE id=?";

        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            Connection connection =
                    DriverManager.getConnection(
                            URL,
                            USERNAME,
                            PASSWORD);

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setString(1, newName);
            ps.setInt(2, newAge);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            System.out.println(
                    rows + " record updated."
            );

            ps.close();
            connection.close();

        } catch (Exception e) {

            System.out.println(
                    "Update Error: "
                            + e.getMessage()
            );
        }
    }
}