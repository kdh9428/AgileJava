package sis.studentinfo;

import com.jimbob.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockAch implements Ach {
    @Override
    public AchResponse issueDebit(AchCredentials achCredentials, AchTransactionData data) {
//        assertTrue(data.account.equals(AccountTest.ACCOUNT_NUMBER));
//
//        assertTrue(data.aba.equals(AccountTest.ABA));
//
//        AchResponse response = new AchResponse();
//        response.timestamp = new Date();
//        response.traceCode = "1";
//
//        response.status = AchStatus.SUCCESS;
//        return response;
        return null;
    }

    @Override
    public AchResponse markTransactionAsNSF(AchCredentials achCredentials, AchTransactionData data, String traceCode) {
        return null;
    }

    @Override
    public AchResponse refundTransaction(AchCredentials credentials, AchTransactionData data, String traceCode) {
        return null;
    }

    @Override
    public AchResponse issueCredit(AchCredentials credentials, AchTransactionData data) {
        return null;
    }

    @Override
    public AchResponse voidSameDayTransaction(AchCredentials credentials, AchTransactionData data, String traceCode) {
        return null;
    }

    @Override
    public AchResponse queryTransactionStatus(AchCredentials credentials, AchTransactionData data, String traceCode) {
        return null;
    }
}
