import com.management.*;

import javax.xml.crypto.Data;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import  java.sql.SQLException;
import java.util.Scanner;

public class StudentsManagementSystem {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {
            Connection con = DriverManager.getConnection(DatabaseConnection.url, DatabaseConnection.username, DatabaseConnection.password);
            while (true){
                Scanner sc=new Scanner(System.in);
                System.out.println("/*********STUDENT MANAGEMENT SYSTEM**********/");
                System.out.println();
                System.out.println("1. Add Student");
                System.out.println("2. Update Students Details");
                System.out.println("3. Delete Student");
                System.out.println("4. Show All Students");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        AddStudent.addStudent(con,sc);
                        break;
                    case 2:
                        UpdateStudent.updateStudent(con,sc);
                        break;
                    case 3:
                        DeleteStudent.deleteStudent(con,sc);
                        break;
                    case 4:
                        ShowStudent.showStudent(con,sc);
                        break;
                    case 0:
                        AdditionalMethods.exit();
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
