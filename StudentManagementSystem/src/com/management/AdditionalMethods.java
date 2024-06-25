package com.management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdditionalMethods {

    public static Boolean studentExists(Connection con, int rollNumber){
        try {
            String sql = "SELECT roll_no FROM students WHERE roll_no = "+ rollNumber;

            try (Statement statement = con.createStatement();
                 ResultSet rs = statement.executeQuery(sql)){

                return rs.next();
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static void exit() throws InterruptedException{
        System.out.print("Exiting System");
        int i=5;
        while (i!=0){
            System.out.print(".");
            Thread.sleep(450);
            i--;
        }
        System.out.println();
        System.out.println("ThankYou For Student Management System!!!");
    }
}
