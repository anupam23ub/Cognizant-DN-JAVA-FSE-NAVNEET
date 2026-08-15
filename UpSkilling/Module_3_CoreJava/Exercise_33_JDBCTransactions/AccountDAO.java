package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_33_JDBCTransactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AccountDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/javafse";

    private static final String USERNAME =
            "root";

    private static final String PASSWORD =
            "root";

    public void transferMoney(
            int fromAccount,
            int toAccount,
            double amount) {

        Connection connection = null;

        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            connection =
                    DriverManager.getConnection(
                            URL,
                            USERNAME,
                            PASSWORD);

            connection.setAutoCommit(false);

            String debitSql =
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?";

            PreparedStatement debitStmt =
                    connection.prepareStatement(debitSql);

            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccount);

            debitStmt.executeUpdate();

            String creditSql =
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            PreparedStatement creditStmt =
                    connection.prepareStatement(creditSql);

            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccount);

            creditStmt.executeUpdate();

            connection.commit();

            System.out.println(
                    "Transaction Successful"
            );

            debitStmt.close();
            creditStmt.close();
            connection.close();

        } catch (Exception e) {

            try {

                if (connection != null) {

                    connection.rollback();

                    System.out.println(
                            "Transaction Rolled Back"
                    );
                }

            } catch (Exception ex) {

                ex.printStackTrace();
            }

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}