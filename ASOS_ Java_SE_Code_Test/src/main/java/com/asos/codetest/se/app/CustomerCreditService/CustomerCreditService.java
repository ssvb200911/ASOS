package com.asos.codetest.se.app.CustomerCreditService;

import java.time.LocalDateTime;
import java.util.concurrent.Future;

public interface CustomerCreditService {

    Future<Integer> getCreditLimit(String firstName, String surname, LocalDateTime dateOfBirth);
}
