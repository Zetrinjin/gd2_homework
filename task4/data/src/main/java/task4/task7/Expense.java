package task4.task7;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Expense implements Serializable {
    private  Integer num;
    private  String paydate;
    private  String receiver;
    private  Integer value;

    public Expense(Integer num, String paydate, String receiver, Integer value) {
        this.num = num;
        this.paydate = paydate;
        this.receiver = receiver;
        this.value = value;
    }

    public Expense() {

    }


    public Integer getNum() {
        return num;
    }

    public String getPaydate() {
        return paydate;
    }

    public String getReceiver() {
        return receiver;
    }

    public Integer getValue() {
        return value;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
