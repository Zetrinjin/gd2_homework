package task10;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task8_9.Player;

import static org.junit.Assert.*;

public class MallTest {

    @Test
    public void test(){

        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("configTask10.xml");


        Mall mall = context.getBean("mall", Mall.class);

        mall.setMallName("ashan");


       mall.vivod();


    }

}