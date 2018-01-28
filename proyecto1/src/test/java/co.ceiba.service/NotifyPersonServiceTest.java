package co.ceiba.service;

import co.ceiba.domain.Person;
import co.ceiba.testDataBuilder.PersonTestDataBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NotifyPersonServiceTest {

    private NotifyPersonService notifyPersonService;
    private EmailService emailService;

    @Before
    public void setUp(){
        emailService = new EmailService();
        notifyPersonService = new NotifyPersonService(emailService);
    }

    @Test
    public void notifyTest(){
        //Arrange
        Person person = new PersonTestDataBuilder().build();

        //Act
        String message = notifyPersonService.notify(person);

        //Assert
        Assert.assertNotNull(message);
    }
}
