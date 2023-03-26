package com.jdbc;

import java.sql.*;
import java.util.Arrays;

public class Jdbc {
    public static void main(String[] args) {
        Jdbc jdbc=new Jdbc();
        jdbc.createTable();
        jdbc.getAllStudents();
        jdbc.getStudentsByCourse();
        jdbc.updateTable();
        jdbc.getAllStudents();
        jdbc.deleteStudentByEmail();
        System.out.println("After delete");
        jdbc.getAllStudents();
//        jdbc.createStudent();
//        System.out.println("After createStudent");
//        jdbc.getAllStudents();

    }
    public void createTable() {
        String QUERY;
        QUERY = """
                DROP TABLE IF EXISTS Students;
                       CREATE TABLE Students
                       (
                           student_id     INT PRIMARY KEY AUTO_INCREMENT,
                           first_name  VARCHAR(250),
                           last_name VARCHAR(250),
                           email       VARCHAR(250) NOT NULL,
                           specialty    VARCHAR(250) NOT NULL,
                           course  INT
                       );
                    
                       insert into Students (student_id, first_name, last_name, email, specialty,course) values (default, 'Olena', 'Sheremet', 'lenka.sheremet1978@gmail.com', 'software engineering',3);
                       insert into Students (student_id, first_name, last_name, email, specialty,course) values (default, 'Anastasia', 'Sokolvak', 'nasta2003sok@gmail.com', 'software engineering',3);
                """;
        System.out.println(QUERY);
        try (Connection connection = H2JdbcUtils.getConnection();
             Statement statement = connection.createStatement()) {
             statement.execute(QUERY);
        } catch (SQLException e) {
            H2JdbcUtils.printSQLException(e);
        }
    }
    private void createStudent() {
        final String INSERT_SQL=" INSERT INTO Students (student_id, first_name, last_name, email, specialty,course) values (default, ?, ?, ?,?,?)";

        try (Connection connection = H2JdbcUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, "Bohdan");
            preparedStatement.setString(2, "Nazharchuk");
            preparedStatement.setString(3, "bodjech2676@gmail.com");
            preparedStatement.setString(4, "computer science");
            preparedStatement.setInt(5, 3);
            ResultSet rs;
            rs = preparedStatement.executeQuery();
            System.out.println("After ");
            while (rs.next()) {
                int studentID = rs.getInt("student_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String specialty = rs.getString("specialty");
                int course = rs.getInt("course");
                System.out.println("After Update: ");
                System.out.println(studentID + "." + firstName + " " + lastName + ", email: " + email + ",specialty: " + specialty +
                                   ",course: " + course);
            }
        } catch (SQLException e) {
            H2JdbcUtils.printSQLException(e);
        }

    }
    public void getAllStudents() {
        String QUERY;
        QUERY = """
                select * from Students;
                """;

        try (Connection connection = H2JdbcUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            System.out.println("SQL:" + preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("Table Students");
            while (rs.next()) {
                int studentID = rs.getInt("student_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String specialty= rs.getString("specialty");
                int course = rs.getInt("course");
                System.out.println(studentID + "." + firstName + " " + lastName + ", email: " + email + ",specialty: " + specialty+
                                   ",course: "+course);
            }
        } catch (SQLException e) {
            H2JdbcUtils.printSQLException(e);
        }
    }
    public void getStudentsByCourse() {
        String QUERY = """
                select * from Students where course = 3;
                """;

        try (Connection connection = H2JdbcUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            System.out.println("SQL:" + preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int studentID = rs.getInt("student_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String specialty= rs.getString("specialty");
                int course = rs.getInt("course");
                System.out.println(studentID + "." + firstName + " " + lastName + ", email: " + email + ",specialty: " + specialty+
                                   ",course: "+course);
            }
        } catch (SQLException e) {
            H2JdbcUtils.printSQLException(e);
        }
    }

    public void updateTable() {
        String SQL = "UPDATE Students SET first_name=?, last_name=?  WHERE email=?";

        try(Connection connection = H2JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, "Nastya");
            preparedStatement.setString(2, " Sokolvak");
            preparedStatement.setString(3, "nasta2003sok@gmail.com");


            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }
            ResultSet rs;
            rs = preparedStatement.executeQuery();
            System.out.println("After update");
            while (rs.next()) {
                int studentID = rs.getInt("student_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String specialty = rs.getString("specialty");
                int course = rs.getInt("course");
                System.out.println("After Update: ");
                System.out.println(studentID + "." + firstName + " " + lastName + ", email: " + email + ",specialty: " + specialty +
                                   ",course: " + course);
            }
        } catch (SQLException e) {
            H2JdbcUtils.printSQLException(e);
        }

    }
    private void deleteStudentByEmail() {
        final String DELETE_SQL = "delete from Students where email = ?";
        try (Connection connection = H2JdbcUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setString(1, "lenka.sheremet1978@gmail.com");
            int i = preparedStatement.executeUpdate();
            System.out.println("effected rows: " + i);
        } catch (SQLException e) {
            H2JdbcUtils.printSQLException(e);
        }
    }
}
