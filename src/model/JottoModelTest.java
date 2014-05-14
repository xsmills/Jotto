package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class JottoModelTest {
    
    
    // make sure assertions are turned on!  
    // we don't want to run test cases without assertions too.
    // see the handout to find out how to turn them on.
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false;
    }
    
    //correct guess
    @Test
    public void test1() {
    	JottoModel jottoModel = new JottoModel();
    	String guess = "";
    	
    	try {
    	guess = jottoModel.makeGuess(16320, "asyla");
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	
    	String expectedOutput = "guess 5 5";
    	assertEquals(expectedOutput, guess);
    }
    
    //invalid length
    @Test
    public void test2() {
    	JottoModel jottoModel = new JottoModel();
    	String guess = "";
    	
    	try {
    	guess = jottoModel.makeGuess(16320, "asylat");
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	
    	String expectedOutput = "error 2";
    	assertEquals(expectedOutput, guess);
    }
    
    //non-number puzzle ID
    @Test
    public void test3() {
    	JottoModel jottoModel = new JottoModel();
    	String guess = "";
    	
    	try {
    	guess = jottoModel.makeGuess(-1, "asylat");
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	
    	String expectedOutput = "error 1";
    	assertEquals(expectedOutput, guess);
    }
    
    
}
