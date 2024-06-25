package com.management;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStudent {

    public static void updateStudent(Connection con, Scanner sc){
        try {
            System.out.println("Enter Student Roll No to update: ");
            int rollNumber = sc.nextInt();

            if (!AdditionalMethods.studentExists(con,rollNumber)){
                System.out.println("No Student Details Found for given roll number.");
                return;
            }

            System.out.println("Enter new Student Name: ");
            String newStudentName = sc.next();
            sc.nextLine();
            System.out.println("Enter Branch For New Student: ");
            String newBranch = sc.next();
            sc.nextLine();
            System.out.println("Enter Contact Number of new Student: ");
            String newContactNumber = sc.nextLine();

            String sql = "UPDATE students SET name = '" + newStudentName + "' , " +
                    "branch = '" + newBranch + "', " +
                    "contact_no = '" + newContactNumber + "' " +
                    "WHERE roll_no = " + rollNumber;

            try (Statement statement = con.createStatement()){
                int affectedRows = statement.executeUpdate(sql);

                if (affectedRows>0){
                    System.out.println("Student details updated Successfully!!");
                }else {
                    System.out.println("Updation Failed.");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
