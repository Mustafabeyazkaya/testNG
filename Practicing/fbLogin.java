package Practicing;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class fbLogin {
    public static WebDriver driver;
    @BeforeMethod
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    @Test
    public void testCase(){
        WebElement username=driver.findElement(By.xpath("//input[@placeholder='Email or phone number']"));
        username.sendKeys("mustafa");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("beyazkaya");
        WebElement loginBtn=driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();
        WebElement incorrectPaswrd=driver.findElement(By.xpath("//div[text()='The password you’ve entered is incorrect. ']"));
        String actaulText=incorrectPaswrd.getText();
        String expectedText="The password you’ve entered is incorrect. Forgot Password?";
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(actaulText,expectedText);
        soft.assertAll();
    }

}
