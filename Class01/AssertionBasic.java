package Class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AssertionBasic {
    //pre-conditions
    public static WebDriver driver; // we declare this outside of the other to be using it inside every method
    @BeforeMethod
    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    //post-condition---> to close the browser
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    //test case
    // enter the username : Admin
    // enter the password : abracadabra
    //click on login button
    //verify that the message invalid credentials is displayed
    //verify that password texBox is displayed
    @Test
    public void invalidCredentials(){
        // locate the webElement username and send keys
        WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));

        username.sendKeys("Admin");
        // locate the webElement password and send keys
        WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));

        password.sendKeys("abracadabra");
        // locate login button and click login
        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));

        loginBtn.click();

        //verify the error message
        WebElement error = driver.findElement(By.xpath("//span[@id='spanMessage']"));

        String errorMsg=error.getText();

        String expectedError = "Invalid credentials";

        //assert the value
        Assert.assertEquals(expectedError,errorMsg);// this is using in testNG instead of if conditions

        // finding the password again as it is discarded when we clicked on login button because the DOM refreshed
        //password texBox is displayed
        password=driver.findElement(By.xpath("//input[@id='txtPassword']"));// reassing it to be used for next code
        boolean pswrdDisplayed=password.isDisplayed();

        // verify that the text box is displayed
        Assert.assertTrue(pswrdDisplayed);
    }
}
