package bank_program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DockerContainer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/bankDB";
        final String USER = "root";
        final String PASS = "mypassword";

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating table in given database...");
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE TestJava " +
                    "(AccountId INTEGER not NULL, " +
                    " firstName VARCHAR(255), " +
                    " lastName VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( AccountId ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
