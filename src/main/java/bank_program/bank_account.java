package bank_program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class bank_account {

    private String account_id = "";
    private String LastName = "";
    private String FirstName = "";
    private double acc_balance = 0;
    private String acc_email = "";
    private String phone_num = "";

    public String getAccount_id() { return account_id; }
    public String getLastName() { return LastName; }
    public String getFirstName() { return FirstName; }
    public double getAccBalance() { return acc_balance; }
    public String getAcc_email() { return acc_email; }
    public String getPhone_num() { return phone_num; }

    public void setAccount_id(String id){ account_id = id; }
    public void setLastName(String ln) { LastName = ln; }
    public void setFastName(String fn) { FirstName = fn; }
    public void setAcc_balance(double amt) { acc_balance = amt; }

    void print_balance(){System.out.println("Your current balance is : $" + acc_balance);}

    // create a new account and insert it to the table
    void create_account(){
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/bankDB";
        final String USER = "root";
        final String PASS = "mypassword";
        Connection conn = null;
    }

    // deposit money into account
    boolean make_deposit(double amt){
        if(amt <= 0) {
            System.out.println("Please enter a valid deposit amount!");
            return false;
        }
        else {
            setAcc_balance(amt);
            System.out.println("You make a deposit of " + amt + " into your account.");
            System.out.println("You account balance is $" + acc_balance + " now");
            return true;
        }
    }

    // withdraw money (This should deduct from the balance field)
    // but not allow the withdrawal to complete if their are insufficient money and print the
    // balance with name of customer
    double withdraw(double amt){
        if(amt > 0){
            if(acc_balance >= amt)
                acc_balance -= amt;
            else {
                System.out.println("Not enough balance in your account");
                //System.out.println("Customer Name: " + customer_name);
                //System.out.println("Balance: " + balance);
            }
        }

        return acc_balance;
    }

    // print Customer Name, Account Number, Balance, Email and Phone Number
    void print_info(){
        //System.out.println("Customer Name: " + customer_name);
        //System.out.println("Account Balance: " + balance);
        //System.out.println("Email: " + email);
        //System.out.println("Phone: " + phone_number);
    }
}
