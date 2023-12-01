package fight.perClass;

import javax.persistence.*;

@Entity
@Table(name = "game")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    @Column
    private String gameName;
    @Column
    private String genre;
    @Column
    private Integer coast;

    public Game() {
    }

    public Game(String id, String gameName, String genre, Integer coast) {
        this.id = id;
        this.gameName = gameName;
        this.genre = genre;
        this.coast = coast;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getCoast() {
        return coast;
    }

    public void setCoast(Integer coast) {
        this.coast = coast;
    }
}
