package com.asos.codetest.se.app.CustomerCreditService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

@WebServiceClient(name = "CustomerCreditService_Service",
                  wsdlLocation = "file:./customer-credit-service.wsdl",
                  targetNamespace = "http://example.asos.com/wsdl/CustomerCreditService.wsdl")
public class CustomerCreditWebServiceClient extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://example.asos.com/wsdl/CustomerCreditService.wsdl", "CustomerCreditService_Service");
    public final static QName GetCreditLimitPort = new QName("http://example.asos.com/wsdl/CustomerCreditService.wsdl", "GetCreditLimit_Port");

    static {
        URL url = null;
        try {
            url = new URL("file:./customer-credit-service.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CustomerCreditWebServiceClient.class.getName())
                                    .log(java.util.logging.Level.INFO,
                                         "Can not initialize the default wsdl from {0}", "file:./customer-credit-service.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerCreditWebServiceClient(URL wsdlLocation) {

        super(wsdlLocation, SERVICE);
    }

    public CustomerCreditWebServiceClient(URL wsdlLocation, QName serviceName) {

        super(wsdlLocation, serviceName);
    }

    public CustomerCreditWebServiceClient() {

        super(WSDL_LOCATION, SERVICE);
    }

    public CustomerCreditWebServiceClient(WebServiceFeature... features) {

        super(WSDL_LOCATION, SERVICE, features);
    }

    public CustomerCreditWebServiceClient(URL wsdlLocation, WebServiceFeature... features) {

        super(wsdlLocation, SERVICE, features);
    }

    public CustomerCreditWebServiceClient(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {

        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "GetCreditLimit_Port")
    public GetCreditLimitPortType getGetCreditLimitPort() {

        return super.getPort(GetCreditLimitPort, GetCreditLimitPortType.class);
    }

    @WebEndpoint(name = "GetCreditLimit_Port")
    public GetCreditLimitPortType getGetCreditLimitPort(WebServiceFeature... features) {

        return super.getPort(GetCreditLimitPort, GetCreditLimitPortType.class, features);
    }

}
