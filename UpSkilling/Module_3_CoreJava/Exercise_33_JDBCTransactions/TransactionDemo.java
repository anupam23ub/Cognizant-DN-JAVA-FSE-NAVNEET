package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_33_JDBCTransactions;

public class TransactionDemo {

    public static void main(String[] args) {

        AccountDAO dao = new AccountDAO();

        dao.transferMoney(
                1,
                2,
                200
        );
    }
}