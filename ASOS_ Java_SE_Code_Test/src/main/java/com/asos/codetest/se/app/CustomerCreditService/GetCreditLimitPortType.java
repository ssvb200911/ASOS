package com.asos.codetest.se.app.CustomerCreditService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.datatype.XMLGregorianCalendar;

@WebService(targetNamespace = "http://example.asos.com/wsdl/CustomerCreditService.wsdl", name = "GetCreditLimit_PortType")
@SOAPBinding(use = SOAPBinding.Use.ENCODED, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface GetCreditLimitPortType {

    @WebMethod(action = "getCreditLimit")
    @WebResult(name = "creditLimit", targetNamespace = "", partName = "creditLimit")
    int getCreditLimit(

            @WebParam(partName = "firstName", name = "firstName", targetNamespace = "")
                    String firstName,
            @WebParam(partName = "surname", name = "surname", targetNamespace = "")
                    String surname,
            @WebParam(partName = "dateOfBirth", name = "dateOfBirth", targetNamespace = "")
                    XMLGregorianCalendar dateOfBirth
    );
}
