package com.asos.codetest.se.app;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

public class CompanyRepository {

    @Value("${app-database}")
    private static String connectionString;

    public Company getById(int companyId)
            throws SQLException {

        Company company = null;
        try (Connection connection = DriverManager.getConnection(connectionString); CallableStatement cstmt = connection.prepareCall(
                "{call dbo.uspGetCompanyById(?)}")) {

            cstmt.setInt(1, companyId);

            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                company = new Company();
                company.setId(rs.getInt("CompanyId"));
                company.setName(rs.getString("Name"));
                switch (rs.getInt("ClassificationId")) {
                    case 1: company.setClassification(Classification.Bronze);
                    case 2: company.setClassification(Classification.Silver);
                    case 3: company.setClassification(Classification.Gold);
                }
            }
        }

        return company;
    }
}
