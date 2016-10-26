package com.realdolmen.course.web.webservice.soap;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="matchMaker", serviceName = "funStuff", targetNamespace = "http://matchmaker.realdolmen.com")
@Stateless
public class MatchMaker {
    @WebMethod
    @WebResult(name = "matchingPercentage")
    public double match(
            @WebParam(name = "personA", targetNamespace = "http://matchmaker.realdolmen.com") String personA,
            @WebParam(name = "personB", targetNamespace = "http://matchmaker.realdolmen.com") String personB) {

        return Math.abs(personA.hashCode() * personB.hashCode()) % 100;

    }
}
