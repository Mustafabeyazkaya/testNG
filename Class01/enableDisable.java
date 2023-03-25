package Class01;

import org.testng.annotations.Test;

public class enableDisable {
    @Test(enabled = false) // when you report the issue to the developer, use this method
    public void Atest(){
        System.out.println("i am first test case");
    }
    @Test
    public void Btest(){
        System.out.println("i am second test case");
    }
    @Test(enabled = false) // when you report the issue to the developer, use this method
    public void Ctest(){
        System.out.println("i am third test case");
    }
}
