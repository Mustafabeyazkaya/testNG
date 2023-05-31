package Class04;

import org.testng.annotations.*;

public class Annotations02 {
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am After Class");
    }
    @BeforeMethod
    public void before(){
        System.out.println("I am Before Method");
    }
    @AfterMethod
    public void after(){
        System.out.println("I am After Method");
    }
    @Test
    public void TestA(){
        System.out.println("I am test A");
    }
    @Test
    public void TestB(){
        System.out.println("I am test B");
    }
}
