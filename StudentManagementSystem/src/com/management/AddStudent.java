package com.management;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddStudent {

    public static void addStudent(Connection con, Scanner sc){
        System.out.println("Enter Student Name: ");
        String studentName = sc.next();
        sc.nextLine();
        System.out.println("Enter Student Branch: ");
        String studentBranch = sc.next();
        sc.nextLine();
        System.out.println("Enter Contact Number: ");
        String contactNumber = sc.next();

        String sql = "INSERT INTO students(name, branch, contact_no)" +
                "VALUES ('" + studentName + "' , '" + studentBranch + "', '" + contactNumber + "')";

        try (Statement statement = con.createStatement()){
            int affectedRows = statement.executeUpdate(sql);

            if (affectedRows>0){
                System.out.println("Student Added Successfully!!");
            }else {
                System.out.println("Student Adding Failed");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
