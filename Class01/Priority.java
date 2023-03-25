package Class01;

import org.testng.annotations.Test;

public class Priority {
    @Test(priority = 3)// to give number makes it to be executed based on your order
    public void Atest(){
        System.out.println("i am TestA");
    }


    @Test(priority = 1)// to give number makes it to be executed based on your order
    public void Btest(){
        System.out.println("i am TestB");
    }


    @Test(priority = 2)// to give number makes it to be executed based on your order
    public void Ctest(){
        System.out.println("i am TestC");
    }
}
