package task10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mall {

    private String mallName;

    @Autowired(required = false)
    private GrosInt grosInt;

//    @Autowired(required = false)
    public Mall(String mallName, GrosInt grosInt) {
        this.mallName = mallName;
        this.grosInt = grosInt;
    }

    //не забывай про пустой конструктор, а то ататата
    public Mall() {
    }

    public void vivod(){
        System.out.println("Mall name: " + mallName + " " + " Gros: " + grosInt.getGros());
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }
}
