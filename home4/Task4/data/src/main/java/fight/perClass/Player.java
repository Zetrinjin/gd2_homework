package fight.perClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player extends Game{

    @Column
    private String playerName;
    @Column
    private Integer timePlay;

    public Player(String playerName, Integer timePlay) {
        this.playerName = playerName;
        this.timePlay = timePlay;
    }

    public Player(String id, String gameName, String genre, Integer coast, String playerName, Integer timePlay) {
        super(id, gameName, genre, coast);
        this.playerName = playerName;
        this.timePlay = timePlay;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getTimePlay() {
        return timePlay;
    }

    public void setTimePlay(Integer timePlay) {
        this.timePlay = timePlay;
    }
}
