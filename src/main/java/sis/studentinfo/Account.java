package sis.studentinfo;

import com.jimbob.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account implements Accountable {

    private BigDecimal balance = new BigDecimal("0.00");
    private int transactionCount = 0;

    private String bankAba;
    private String bankAccountNumber;
    private BankAccountType bankAccountType;
    private Ach ach;

    public synchronized void withdraw(BigDecimal amount) {
        if (amount.compareTo(balance) > 0)
            return;

        try {
            Thread.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        balance = balance.subtract(amount);
    }


    public enum BankAccountType {
        CHECKING("ck"), SAVINGS("sv");
        private String value;
        private BankAccountType(String value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "BankAccountType{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    public void credit(BigDecimal amount) {

        balance = balance.add(amount);
        transactionCount++;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal transactionAverage() {
        return balance.divide(new BigDecimal(transactionCount), RoundingMode.HALF_UP);

    }

    public void setBankAba(String bankAba) {
        this.bankAba = bankAba;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public void setBankAccountType(BankAccountType bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public void transferFromBank(BigDecimal amount){
        AchCredentials credentials = createCredentials();

        AchTransactionData data = createData(amount);

        Ach ach = getAch();

        AchResponse achResponse = ach.issueDebit(credentials, data);

        if (achResponse.status == AchStatus.SUCCESS)
            credit(amount);

        System.out.println(achResponse.status);
    }

    private AchCredentials createCredentials(){
        AchCredentials credentials = new AchCredentials();
        credentials.merchantId = "12355";
        credentials.userName = "sismerc1920";
        credentials.password = "pitselen411";
        return credentials;
    }

    private AchTransactionData createData(BigDecimal amount){
        AchTransactionData data = new AchTransactionData();
        data.description = "transfer from bank";
        data.amount = amount;
        data.aba = bankAba;
        data.account = bankAccountNumber;
        data.accountType = bankAccountType.toString();
        return data;
    }

    private Ach getAch(){
        return ach;
    }
    public void setAch(Ach ach){
        this.ach = ach;
    }
}
