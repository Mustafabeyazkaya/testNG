package Class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class dataProvider {
//    Test Scenario:
//    navigate to syntax HRMS
//    login into the webiste using the following credentials and check for correct errors
//    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
//    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"

    @DataProvider(name="credentials")// each dataProvider must have a name to be calling
    public Object[][] data(){
        Object[][] loginData={
                {"Admin", "12345", "Invalid credential"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empt"},
                {"", "Hum@nhrm123", "Username cannot be empt"}
        };
        return loginData;
    }
    public static WebDriver driver;
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
    @Test(dataProvider = "credentials")// connect you test case with a data provider
    public void testCase(String username,String password,String errorMsg){
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id = 'txtPassword']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='Submit']")).click();

        // get the error message
        WebElement error=driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualError=error.getText();

        //Assertion
        Assert.assertEquals(actualError,errorMsg);


    }
}
