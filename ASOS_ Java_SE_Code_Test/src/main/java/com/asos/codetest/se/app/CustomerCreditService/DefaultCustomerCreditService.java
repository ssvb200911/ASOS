package com.asos.codetest.se.app.CustomerCreditService;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.time.LocalDateTime;

public final class DefaultCustomerCreditService implements CustomerCreditService {

    private static final QName SERVICE_NAME = new QName("http://example.asos.com/wsdl/CustomerCreditService.wsdl", "CustomerCreditService_Service");

    private final GetCreditLimitPortType getCreditLimitPortType;

    public DefaultCustomerCreditService() {

        CustomerCreditWebServiceClient customerCreditService = new CustomerCreditWebServiceClient(CustomerCreditWebServiceClient.WSDL_LOCATION, SERVICE_NAME);
        getCreditLimitPortType = customerCreditService.getGetCreditLimitPort();
    }

    @Override
    public int getCreditLimit(String firstName, String surname, LocalDateTime dateOfBirth) {

        final XMLGregorianCalendar convertedDateOfBirth;
        try {
            convertedDateOfBirth = DatatypeFactory.newInstance()
                                                  .newXMLGregorianCalendar(dateOfBirth.toString());
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }

        return getCreditLimitPortType.getCreditLimit(firstName, surname, convertedDateOfBirth);
    }
}
