package com.realdolmen.course.web.webservice.soap;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="dumbDetector", serviceName = "funStuff", targetNamespace = "http://dumbdetector.realdolmen.com")
@Stateless
public class DumbDetector {
    @WebMethod
    @WebResult(name = "answer")
    public String isDumb(@WebParam(name = "question", targetNamespace = "http://dumbdetector.realdolmen.com") String value) {
        return "yes";
    }
}
