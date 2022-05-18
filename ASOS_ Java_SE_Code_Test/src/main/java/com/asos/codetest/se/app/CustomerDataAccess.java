package com.asos.codetest.se.app;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

public class CustomerDataAccess {

    @Value("${app-database}")
    private static String connectionString;

    public static void addCustomer(Customer customer)
            throws SQLException {

        try (Connection connection = DriverManager.getConnection(connectionString); CallableStatement cstmt = connection.prepareCall(
                "{call dbo.uspAddCustomer(?,?,?,?,?,?,?)}")) {

            cstmt.setString(1, customer.getFirstName());
            cstmt.setString(2, customer.getSurname());
            cstmt.setTimestamp(3, Timestamp.valueOf(customer.getDateOfBirth()));
            cstmt.setString(4, customer.getEmailAddress());
            cstmt.setBoolean(5, customer.getHasCreditLimit());
            cstmt.setInt(6, customer.getCreditLimit());
            cstmt.setInt(7, customer.getCompany().getId());

            cstmt.execute();
        }
    }
}
