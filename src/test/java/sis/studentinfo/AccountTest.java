package sis.studentinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    static final String ABA = "102000012";
    static final String ACCOUNT_NUMBER = "194431518811";

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
        account.setBankAba(ABA);
        account.setBankAccountNumber(ACCOUNT_NUMBER);
        account.setBankAccountType(Account.BankAccountType.CHECKING);
    }

    @Test
    public void testTransferFromBank(){
//        account.setAch(new com.jimbob.ach.JimBobAch());
        account.setAch(new MockAch());
        final BigDecimal amount = new BigDecimal("50.00");
        account.transferFromBank(amount);

        assertEquals(amount, account.getBalance());
    }

    @Test
    public void testTransactions() {
        Account account = new Account();
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));
        assertEquals(new BigDecimal("11.10"), account.getBalance());

        assertEquals(new BigDecimal("5.300"), new BigDecimal("5.000").add(new BigDecimal("0.3")));
    }

    @Test
    public void testTransactionAverage() {
        Account account = new Account();
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));
        account.credit(new BigDecimal("2.99"));

        assertEquals(new BigDecimal("4.70"), account.transactionAverage());

        BigDecimal balance = new BigDecimal("11.12");
        double doubleBigDecimal = balance.doubleValue();
        int intBigDecimal = balance.intValue();

        assertEquals(11.12, doubleBigDecimal);
        assertEquals(11, intBigDecimal);

        assertEquals(12, 0xc);
        assertEquals(10, 012);


        double x = 3.1415d;
        float y = (float) x;

        assertEquals(600.0f, 20.0f * 30, 2);
        assertEquals(0.5, 15 / 30, 1);
        assertEquals(0.5, 15 / 30.0, 1);

        int total = 35;
        int avg = 2;
        assertEquals(17.5,  (double) total / avg);
    }
}