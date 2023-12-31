package home.dao;

import home.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.Assert.*;
public class PeopleDaoImlpTest {

    Connection conn;
    @Test
    public void create() {
        ApplicationContext ctx =new ClassPathXmlApplicationContext("beans-annotation.xml");
        /*PeopleDao peopleDao =ctx.getBean(PeopleDao.class);
        peopleDao.create(new People());*/

        PeopleDao peopleDao =ctx.getBean("peopleDao",PeopleDao.class);
        People ppl = new People("1", "testSave", 121.21);

        peopleDao.create(ppl);

       /* ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from user where name = 'testSave'");
        rs.next();
        long count = rs.getLong(1);
        assertEquals(1, count);*/

    }

    @Test
    public void update() {
    }

    @Test
    public void getPeople() {
    }
}