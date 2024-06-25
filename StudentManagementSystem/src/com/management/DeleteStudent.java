package com.management;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteStudent {

    public static void deleteStudent(Connection con , Scanner sc){
        try {
            System.out.println("Enter Student Roll Number: ");
            int rollNumber = sc.nextInt();

            if (!AdditionalMethods.studentExists(con,rollNumber)){
                System.out.println("No Student Details Found for given roll number.");
                return;
            }

            String sql = "DELETE FROM students WHERE roll_no = " + rollNumber;

            try (Statement statement = con.createStatement()){
                int affectedRows = statement.executeUpdate(sql);

                if (affectedRows>0){
                    System.out.println("Student details deleted Successfully!!");
                }else {
                    System.out.println("Deletion Failed.");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
