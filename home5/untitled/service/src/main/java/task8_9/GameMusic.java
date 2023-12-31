package task8_9;

import org.springframework.stereotype.Component;

@Component
public class GameMusic implements GameS{

    @Override
    public String getGame() {
        return "ost";
    }
}
