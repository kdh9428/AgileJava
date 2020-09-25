package sis.studentinfo;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance = new BigDecimal("0.00");

    public void credit(BigDecimal amount) {

        balance = balance.add(amount);
    }

    public BigDecimal getBalance(){
        return balance;
    }
}
