package prob;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void crash(){
        //ApplicationContex можно и так но тогда нет context.close хз поч
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("configContext.xml");
        Person person = context.getBean("person", Person.class);

        System.out.println("name: " + person.getName());
        System.out.println("surname: " + person.getSurname());
        System.out.println("leav: " + person.getAddress());

        context.close();
   }

}