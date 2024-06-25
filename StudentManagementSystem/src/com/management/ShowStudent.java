package com.management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ShowStudent {

    public static void showStudent(Connection con, Scanner sc){
        try {

            String sql = "SELECT roll_no, name, branch, contact_no FROM students";

            try (Statement statement = con.createStatement();
                 ResultSet rs = statement.executeQuery(sql)){

                System.out.println("Students Details For Given Roll Number: ");
                while (rs.next()){
                    int roll_no = rs.getInt("roll_no");
                    String name = rs.getString("name");
                    String branch = rs.getString("branch");
                    String contact_no = rs.getString("contact_no");
                    System.out.println();
                    System.out.println("============================================");
                    System.out.println("Roll Number "+roll_no);
                    System.out.println("Student Name: "+name);
                    System.out.println("Branch: "+branch);
                    System.out.println("Contact Number: "+contact_no);
                    System.out.println("============================================");
                    System.out.println();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
