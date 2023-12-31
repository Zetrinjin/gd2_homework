package task8_9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Player {

    private String playerName;


    //можно подлкючать через поле но так будет больше записей
//    @Autowired
//    @Qualifier("game")  //можно указывать что именно мы хотим получить
    private GameS game1;

//    @Autowired
//    @Qualifier("gameMusic")
    private GameS game2;
    public Player() {
    }

   // @Autowired(required = false)// будет хотеть два autowired в виде playername & game, а нам это не надо
    public Player(String playerName, GameS game1) {
        this.playerName = playerName;
        this.game1 = game1;
    }

    //@Autowired
    public Player(String playerName, GameS game1,GameS game2) {
        this.playerName = playerName;
        this.game1 = game1;
        this.game2 = game2;
    }

    //можно и так подключать без player с квалифаерами и все будет работать
    @Autowired
    public Player(@Qualifier("game") GameS game1,@Qualifier("gameMusic") GameS game2) {
        this.game1 = game1;
        this.game2 = game2;
    }

    public void gamer(){
        System.out.println("Player: " + playerName + " " + " GameComponent: " + game1.getGame() +
                " gmus: " + game2.getGame());
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public GameS getGame() {
        return game1;
    }

    public void setGame(Game game) {
        this.game1 = game;
    }

    public GameS getGame2() {
        return game2;
    }

    public void setGame2(GameS game2) {
        this.game2 = game2;
    }
}
