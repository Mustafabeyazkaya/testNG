package Class01;

import org.testng.annotations.Test;

public class dependsOn {
    @Test
    public void Login(){// if this is enable to be executed, DashBoardverification code won't be executed also because it depends on Login method
        System.out.println(6/0);
    }
    @Test(dependsOnMethods = {"Login"})// if your code depend on something and that things is not able to execute, your code depended on won't work
    public void DashBoardverification(){
        System.out.println("after login i am verifying dashboard");
    }
}
