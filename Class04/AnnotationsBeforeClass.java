package Class04;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationsBeforeClass {
    @BeforeClass
    public void hello(){
        System.out.println("i am before class");
    }
    @Test
    public void testB(){
        System.out.println("i am test B");
    }




}
