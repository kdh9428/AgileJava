package AgileLesson8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    private String Exception_Message = "Somebody should catch this!";

    @Test
    public void testBlowsUpException(){

        try {
        blowsUp();

        }catch (RuntimeException e){
            e.printStackTrace();
        }

    }

    private void blowsUp() {
        throw new SimpleException(Exception_Message);
    }

    @Test
    public void testRethrowsException(){

        try {
        rethrows();

        }catch (RuntimeException e){
            Throwable cause = e.getCause();
            assertTrue(cause instanceof RuntimeException);
            assertEquals(Exception_Message, cause.getMessage());
        }
    }

    private void rethrows() {
        try {
            blowsUp();
        }catch (RuntimeException e){
            throw new RuntimeException(e);

        }
    }

    @Test
    public void testExceptionOrder1(){
        try {
            blowsUp();
            rethrows();
            fail("no exception");
        }catch (SimpleException exception){
            fail("caught wrong exception");
        } catch (RuntimeException success){
        }
    }

    @Test
    public void testExceptionOrder2(){
        try {
            rethrows();
            blowsUp();
            fail("no exception");
        }catch (SimpleException success){

        }catch (RuntimeException failure){
            fail("caught wrong exception");
        }
    }

    @Test
    public void testExceptionOrder3(){
        try {
            blowsUp();
            rethrows();
            fail("no exception");
        }catch (RuntimeException success){

        }
//        catch (SimpleException yours){
//            fail("caught wrong exception");
//        }
    }

    @Test
    public void testExceptionOrder4(){
        try {
            blowsUp();
            rethrows();
        }catch (RuntimeException fail){

        }
//        catch (SimpleException yours){
//
//        }
        finally{
            return;
        }
    }
    @Test
    public void testExceptionOrder5(){
        try {
            blowsUp();
            rethrows();
            fail("no exception");
        }catch (SimpleException yours){
            fail("caught wrong exception");
        }catch (RuntimeException success){

        }
    }

    @Test
    public void testExceptionOrder6(){
        try {
            rethrows();
            blowsUp();
            fail("no exception");
        }catch (SimpleException yours){
            fail("caught wrong exception");
        }catch (RuntimeException success){

        }
    }

    @Test
    public void testExceptionOrder7(){
        try {
            rethrows();
            blowsUp();
            fail("no exception");
        }catch (SimpleException fail){

        }catch (RuntimeException fail){
            fail("caught wrong exception");
        }
    }

    @Test
    public void testErrorException1(){
        try {
            throw new RuntimeException("fail");
        }catch (Exception success){

        }
    }

    @Test
    public void testErrorException2(){
        try {
            new Dyer();
        }catch (Exception success){

        }
    }

    @Test
    public void testErrorException3(){
        try {
            new Dyer();
        }catch (Error success){

        }
    }

    @Test
    public void testErrorException4(){
        try {
            new Dyer();
        }catch (Throwable success){

        }
    }

    @Test
    public void testErrorException5(){
        try {
            new Dyer();
        }catch (Throwable fail){
            fail("caught exception in wrong place");
        }
//        catch (Error success){
//
//        }
    }

    @Test
    public void testErrorException6(){
        try {
            new Dyer();
        }catch (Error fail){
            fail("caught exception in wrong place");
        }catch (Throwable success){

        }
    }

    @Test
    public void testErrorException7(){
        try {
            new Dyer();
        }catch (Error fail){
            fail("caught exception in wrong place");
        }catch (Throwable success){

        }finally {
            return;
        }
    }

//    Dyer:
    class Dyer{
        Dyer(){
            throw new RuntimeException("oops.");
        }
    }


    // no.7
    @Test
    public void testWithProblems(){
        try {
            doSomething();
            fail("no exception");
        }catch (Exception success){

        }
    }

    void doSomething() throws Exception{
        throw new Exception("blah");
    }

}


class SimpleException extends RuntimeException {
    public SimpleException(String exception_message) {
        super(exception_message);
    }
}
