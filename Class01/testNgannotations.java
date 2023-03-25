package Class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNgannotations {
    @BeforeMethod
    public void beforeMethods(){
        System.out.println("i am before method");
    }
    @AfterMethod
    public void afterMethods(){
        System.out.println("i am after method");
    }
    @Test(groups = "regression")
    public void aFirstTestCase(){
        System.out.println("I am the first test case");
    }
    @Test
    public void bSecondTestCase(){
        System.out.println("i am the second test case");
    }
    @Test
    public void cThirdTestCase(){
        System.out.println("i am the third test case");
    }

}
