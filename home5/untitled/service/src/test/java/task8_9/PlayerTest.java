package task8_9;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlayerTest {


    @Test
    public void test(){

        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("configtask8.xml");


        Player player = context.getBean("player", Player.class);

        player.setPlayerName("jok");
//        player.setGame(new Game("pok"));

        player.gamer();


    }

}