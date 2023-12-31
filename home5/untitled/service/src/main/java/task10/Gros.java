package task10;

import org.springframework.stereotype.Component;

@Component
public class Gros implements GrosInt{

    @Override
    public String getGros() {
        return "milk";
    }
}
