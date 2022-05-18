package com.asos.codetest.se.app;

import com.asos.codetest.se.app.CustomerCreditService.CustomerCreditServiceClient;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public class CustomerService {

    public boolean addCustomer(String firname, String surname, String email, LocalDateTime dateOfBirth, int companyId)
            throws Exception {

        if (StringUtils.isEmpty(firname) || StringUtils.isEmpty(surname)) {
            return false;
        }

        if (!email.contains("@") && !email.contains(".")) {
            return false;
        }

        LocalDateTime now = LocalDateTime.now();
        int age = now.getYear() - dateOfBirth.getYear();
        if (now.getMonthValue() < dateOfBirth.getMonthValue() || (now.getMonthValue() == dateOfBirth.getMonthValue() && now.getDayOfMonth() < dateOfBirth.getDayOfMonth())) {
            age--;
        }

        if (age < 21) {
            return false;
        }

        CompanyRepository companyRepository = new CompanyRepository();
        Company company = companyRepository.getById(companyId);

        Customer customer = new Customer();
        customer.setCompany(company);
        customer.setDateOfBirth(dateOfBirth);
        customer.setEmailAddress(email);
        customer.setFirstName(firname);
        customer.setSurname(surname);

        if ("VeryImportantClient".equals(company.getName())) {
            // Skip credit check
            customer.setHasCreditLimit(false);
        } else if ("ImportantClient".equals(company.getName())) {
            // Do credit check and double credit limit
            customer.setHasCreditLimit(true);
            int creditLimit;
            try (CustomerCreditServiceClient customerCreditService = new CustomerCreditServiceClient()) {
                creditLimit = customerCreditService.getCreditLimit(customer.getFirstName(), customer.getSurname(), customer.getDateOfBirth()).get();
            }
            creditLimit = creditLimit * 2;
            customer.setCreditLimit(creditLimit);

        } else {
            customer.setHasCreditLimit(true);
            int creditLimit;
            try (CustomerCreditServiceClient customerCreditService = new CustomerCreditServiceClient()) {
                creditLimit = customerCreditService.getCreditLimit(customer.getFirstName(), customer.getSurname(), customer.getDateOfBirth()).get();
            }
            customer.setCreditLimit(creditLimit);
        }

        if (customer.getHasCreditLimit() && customer.getCreditLimit() < 500) {
            return false;
        }

        CustomerDataAccess.addCustomer(customer);

        return true;
    }
}
