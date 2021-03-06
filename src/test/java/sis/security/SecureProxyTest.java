package sis.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class SecureProxyTest {


    private static final String secureMethodName = "secure";
    private static final String insecureMethodName = "insecure";
    private Object object;
    private SecureProxy proxy;
    private boolean secureMethodCalled;
    private boolean insecureMethodCalled;

    @BeforeEach
    void setUp() {

        object = new Object(){
            public void secure(){
                secureMethodCalled = true;
            }
            public void insecure(){
                insecureMethodCalled = true;
            }
        };
        proxy = new SecureProxy(object, secureMethodName);
    }

    @Test
    public void testSecureMethod() throws Throwable{
        Method secureMethod = object.getClass().getDeclaredMethod(secureMethodName, new Class[]{});

        try {
            proxy.invoke(proxy, secureMethod, new Object[]{});
            fail("expected PermissionException");
        }catch (PermissionException exception){
            assertFalse(secureMethodCalled);
        }
    }
    @Test
    public void testInsecureMethod() throws Throwable{
        Method insecureMethod = object.getClass().getDeclaredMethod(insecureMethodName, new Class[]{});
        proxy.invoke(proxy, insecureMethod, new Object[]{});
        assertTrue(insecureMethodCalled);
    }
}