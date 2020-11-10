package sis.studentinfo;

import com.jimbob.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

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
    public void testTransferFromBank() {
//        account.setAch(new com.jimbob.ach.JimBobAch());

        Ach mockAch = new MockAch() {
            @Override
            public AchResponse issueDebit(AchCredentials credentials, AchTransactionData data) {

                assertEquals(data.account, AccountTest.ACCOUNT_NUMBER);
                assertEquals(data.aba, AccountTest.ABA);

                AchResponse response = new AchResponse();
                response.timestamp = new Date();
                response.traceCode = "1";
                response.status = AchStatus.SUCCESS;
                return response;
            }
        };

        account.setAch(mockAch);
        final BigDecimal amount = new BigDecimal("50.00");
        account.transferFromBank(amount);

        assertEquals(amount, account.getBalance());
    }

    @Test
    public void testFailedTransferFromBank() {
        account.setAch(createMockAch(AchStatus.FAILURE));
        final BigDecimal amount = new BigDecimal("50.00");
        account.transferFromBank(amount);
        assertEquals(new BigDecimal("0.00"), account.getBalance());
    }

    @Test
    public Ach createMockAch(AchStatus status) {

        return new MockAch() {
            @Override
            public AchResponse issueDebit(AchCredentials achCredentials, AchTransactionData data) {

                assertTrue(data.account.equals(AccountTest.ACCOUNT_NUMBER));
                assertTrue(data.aba.equals(AccountTest.ABA));

                AchResponse response = new AchResponse();
                response.timestamp = new Date();
                response.traceCode = "1";
                response.status = status;
                return response;
            }
        };
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
        assertEquals(17.5, (double) total / avg);
    }
}