package com.asos.codetest.se.app;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CustomerServiceShould {

    @Test
    void addCustomerFromExistingConsumers()
            throws Exception {

        /*
         *	You MUST NOT change this code. This represents an existing consumer of the CustomerService
         *  and you MUST maintain backwards compatibility.
         */

        CustomerService customerService = new CustomerService();
        boolean addResult = customerService.addCustomer("J", "Bloggs", "jbloggs@adomain.com", LocalDateTime.of(1980, 3, 27, 0, 0), 4);

        assertThat(addResult, is(true));
    }
}