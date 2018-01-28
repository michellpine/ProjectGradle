package co.ceiba.service;

import co.ceiba.domain.Person;
import co.ceiba.testDataBuilder.PersonTestDataBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class NotifyPersonServiceTest {

    private NotifyPersonService notifyPersonService;
    private EmailService emailService;

    @Before
    public void setUp(){
        //emailService = new EmailService();
        //Usando Mockito
        emailService = Mockito.mock(EmailService.class);
        notifyPersonService = new NotifyPersonService(emailService);
    }

    @Test
    public void notifyTest(){
        //Arrange
        Person person = new PersonTestDataBuilder().build();
        Mockito.when(emailService.sendEmail(Mockito.anyString())).thenReturn("Hola Mundo");

        //Act
        String message = notifyPersonService.notify(person);

        //Assert
        Assert.assertNotNull(message);
        System.out.println(message);
    }
}
