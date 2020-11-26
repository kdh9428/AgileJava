package sis.studentinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sis.security.Permission;
import sis.security.PermissionException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

public class AccountFactoryTest {

    private List<Method> updateMethods;
    private List<Method> readOnlyMethods;

    @BeforeEach
    void setUp() throws Exception {
        updateMethods = new ArrayList<>();

        addUpdateMethod("setBankAba", String.class);
        addUpdateMethod("setBankAccountNumber", String.class);
        addUpdateMethod("setBankAccountType", Account.BankAccountType.class);
        addUpdateMethod("transferFromBank", BigDecimal.class);
        addUpdateMethod("credit", BigDecimal.class);

        readOnlyMethods = new ArrayList<>();
        addReadOnlyMethod("getBalance");
        addReadOnlyMethod("transactionAverage");


    }

    private void addUpdateMethod(String name, Class parmClass) throws Exception {


        updateMethods.add(Accountable.class.getDeclaredMethod(name, parmClass));
    }

    private void addReadOnlyMethod(String name) throws Exception {
        Class[] noParms = new Class[]{};

        readOnlyMethods.add(Accountable.class.getDeclaredMethod(name, noParms));
    }

    @Test
    public void testUpdateAccess() throws Exception {
        Accountable account = AccountFactory.create(Permission.UPDATE);

        for (Method method : readOnlyMethods)
            verifyNoException(method, account);

        for (Method method : updateMethods)
            verifyNoException(method, account);
    }

    @Test
    public void testReadOnlyAccess() throws Exception {
        Accountable account = AccountFactory.create(Permission.READ_ONLY);

        for (Method method : updateMethods)
            verifyException(PermissionException.class, method, account);

        for (Method method : readOnlyMethods)
            verifyNoException(method, account);
    }

    @Test
    public void testReflect(){
        try {

            Class cls = Class.forName("A");



            boolean b1 = cls.isInstance(new Integer(37));

            System.out.println(b1);



            boolean b2 = cls.isInstance(new A());

            System.out.println(b2);



        } catch (Throwable e) {

            System.err.println("에러 : " +e);

        }

    }

    private void verifyException(Class exceptionType, Method method, Object object) throws Exception {

        try {
            method.invoke(object, nullParmsFor(method));
            fail("expected exception");
        } catch (InvocationTargetException e) {
            assertEquals("expected exception", exceptionType, e.getCause().getClass());
        }
    }

    private void verifyNoException(Method method, Object object) throws Exception {

        try {
            method.invoke(object, nullParmsFor(method));
        }catch (InvocationTargetException e ){
            assertFalse("unexpected permission exception", PermissionException.class == e.getCause().getClass() );
        }
    }


    private Object[] nullParmsFor(Method method){
        return new Object[method.getParameterTypes().length];
    }

    class A {
    }
}


