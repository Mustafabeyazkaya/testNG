package Class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class softAssert {
    // go to syntax hrms
    //send no credentials and click on login button
    // verify the error message is username can nor be amepty
    public static WebDriver driver;
    @BeforeMethod
    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    @Test
    public void testCase(){// in the softAssert execution work even 1 of your assertion is not correct, it does not break your all code
        //find the login button and click
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
        //get the text error message
        WebElement errorMesg=driver.findElement(By.xpath("//span[text()='Username cannot be empty']"));
        // get the actual text
        String errorMsgText=errorMesg.getText();
        //get the expected text
        String expectedText="Username cannot be empty";
        // create softAssert object
        SoftAssert soft=new SoftAssert();
        // compare actual and expected error
        soft.assertEquals(expectedText,errorMsgText);
        // check if login button is displayed?
        boolean displayed=loginBtn.isDisplayed();
        // confirm by calling soft assertion
        soft.assertTrue(displayed);

        // to see which of our assertions failed if we have
        // this is a must to do in soft Assert after making all the assertions
        soft.assertAll();
    }
}
