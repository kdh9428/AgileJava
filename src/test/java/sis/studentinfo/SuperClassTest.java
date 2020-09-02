package sis.studentinfo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuperClassTest {

    @Test
    public void testConstructorCalls() {
        SuperClass superClass = new SubClass("parm");
        assertTrue(SuperClass.constructorWasCalled);
    }

}

class SuperClass {

    static boolean constructorWasCalled = false;

    public SuperClass(String parm) {
        constructorWasCalled = true;
    }
}

class SubClass extends SuperClass {
    SubClass(String parm) {
        super(parm);
    }
}



