package com.training.jdbctransactiondemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {

			System.out.println("Enter Amount :: ");
			Scanner sc = new Scanner(System.in);
			Integer ammount = sc.nextInt();

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springboot55", "root", "admin");
			
			con.setAutoCommit(false);

			// Account 1 Balance
			Statement account1stmt = con.createStatement();
			ResultSet resaccount1 = account1stmt.executeQuery("select * from account1");
			int account1balance = 0;
			if (resaccount1.next()) {
				account1balance = resaccount1.getInt("balance");
				System.out.println("ACCOUNT1 BALANCE :: " + account1balance);
			}

			// Account 2 Balance
			Statement stmtaccount2 = con.createStatement();
			ResultSet account2res = stmtaccount2.executeQuery("select * from account2");
			int account2balance = 0;
			if (account2res.next()) {
				account2balance = account2res.getInt("balance");
				System.out.println("ACCOUNT2 BALANCE ::: " + account2balance);
			}

			if (account1balance > ammount) {
				int deuctedammount = account1balance - ammount;
				PreparedStatement preparestmt = con
						.prepareStatement("update account1 set balance = ? where balance > 0");
				preparestmt.setInt(1, deuctedammount);
				preparestmt.execute(); 
				System.out.println("AMMOUNT DEBITED FROM ACCOUNT1");

				PreparedStatement account2PrepareStatment = con
						.prepareStatement("update account2 set balance = ? where balance > 0");
				int totalammount = account2balance + ammount;
				account2PrepareStatment.setInt(1, totalammount);
				account2PrepareStatment.execute();
				System.out.println("AMMOUNT CREDIT IN ACCOUNT2");

				con.commit();
			} else {
				System.out.println("Insuffeciant Balance");
			}
			con.close();
			System.out.println("Data Inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.err.println("Transaction RollBacked");
		}
    }
}
