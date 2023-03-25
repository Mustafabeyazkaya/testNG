package Class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testNGExample {
    // test1
    // go to syntaxHrms
    // enter the username and password, verify that you logged in
    // close the browser
    public static WebDriver driver; // we declare this outside of the other to be using it inside every method
    // pre conditions ---> to open the browser
    // to set implicit wait
    @BeforeMethod(alwaysRun = true)
    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    //post-condition---> to close the browser
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    // test case 1
    //verify login functionality
    @Test(groups = "regression")
    public void LoginFunctionality(){
        WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));

        username.sendKeys("Admin");

        WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));

        password.sendKeys("Hum@nhrm123");

        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));

        loginBtn.click();
    }
    // test case 2
    // verify that password textBox is displayed on the login page
    @Test
    public void passwordTextBoxVerification(){
        // find the webElement password textBox
        WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));

        System.out.println(password.isDisplayed());
    }
}
