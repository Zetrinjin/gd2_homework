package task8_9;

import org.springframework.stereotype.Component;

@Component
public class Game implements GameS {

    private String gameName;

    public Game() {
    }

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public String getGame() {
        return "star";
    }
}
