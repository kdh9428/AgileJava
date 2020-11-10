package sis.studentinfo;

import sis.security.Permission;
import sis.security.SecureProxy;

import java.lang.reflect.*;

public class AccountFactory {

    public static Accountable create(Permission permission){

        switch (permission){
            case UPDATE :
                return new Account();
            case READ_ONLY:
                return createSecuredAccount();
        }
        return null;
    }

    private static Accountable createSecuredAccount(){
        SecureProxy secureAccount = new SecureProxy(new Account(), "credit", "setBankAba", "setBankAccountNumber", "setBankAccountType", "transferFromBank");
        return (Accountable) Proxy.newProxyInstance(Accountable.class.getClassLoader(), new Class[]{Accountable.class}, secureAccount);
    }
}
