package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_31_Basic_JDBC_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnectionDemo {

    public static void main(String[] args) {

        String url =
                "jdbc:mysql://localhost:3306/javafse";

        String username = "root";

        String password = "root";

        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            Connection connection =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            Statement statement =
                    connection.createStatement();

            ResultSet resultSet =
                    statement.executeQuery(
                            "SELECT * FROM students"
                    );

            System.out.println("Students Table:");

            while (resultSet.next()) {

                int id =
                        resultSet.getInt("id");

                String name =
                        resultSet.getString("name");

                int age =
                        resultSet.getInt("age");

                System.out.println(
                        id + " | "
                        + name + " | "
                        + age
                );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}