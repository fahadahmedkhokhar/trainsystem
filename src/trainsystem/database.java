/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fahad Ahmed Khokhar
 */
public class database {
private final static String jdbcDatabase = "nomi";
	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private final static String jdbcUrl = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
	private final static String jdbcUser = "root";
	private final static String jdbcPassword = "";
    /**
     * @param args the command line arguments
     */
        public static Connection makeConnection() throws ClassNotFoundException, SQLException {
		Connection con;
		Class.forName(jdbcDriver);
		System.setProperty("jdbc.drivers", jdbcDriver);

		con = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
		con.setAutoCommit(false);

//		Statement s1 = con.createStatement();
//		s1.executeUpdate("DROP DATABASE IF EXISTS " + jdbcDatabase + ";");
//		s1.close();
//
//		Statement s2 = con.createStatement();
//		s2.executeUpdate("CREATE DATABASE  " + jdbcDatabase + ";");
//		s2.close();

		con.setCatalog(jdbcDatabase);
		return con;
	}
        
public static ResultSet query(Connection con, String query) throws SQLException {
		try {
			Statement s = con.createStatement();
			return s.executeQuery(query);
		}
		catch (SQLException e) {
			throw new SQLException("Bad query \"" + query + "\"\n" + e.getMessage());
		}
	}
      
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        // TODO code application logic here
//        Scanner sc = new Scanner(System.in);
        Connection con = makeConnection();
     // System.out.println("Enter the movie you most liked :");
     //   String movielike = sc.nextLine();
     //	query3(con, movielike);

        
    }

    
       
    
}
