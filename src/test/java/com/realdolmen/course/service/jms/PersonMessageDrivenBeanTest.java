package com.realdolmen.course.service.jms;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.domain.RegularPerson;
import com.realdolmen.course.utilities.integration.RemoteJmsTest;
import org.junit.Test;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

public class PersonMessageDrivenBeanTest extends RemoteJmsTest {
    @Test
    public void shouldSendAPersonMessage() throws JMSException {
        ObjectMessage message = session.createObjectMessage(new RegularPerson("Theo", "Tester"));
        producer.send(message);
        assertPatiently(() -> assertEquals(3, count(Person.class)));
    }
}
