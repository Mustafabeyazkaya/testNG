package Practicing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class instalogin {
    public static WebDriver driver;
       @BeforeMethod
       public void setUpBrwser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.instagram.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
        @AfterMethod
            public void closing(){
                   driver.quit();
        }
        @Test
            public void LoginingInsta(){
           WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
           username.sendKeys("mustafa");
           WebElement password= driver.findElement(By.xpath("//input[@name='username']/parent::label/parent::div/parent::div/following-sibling::div/div/label/input"));
           password.sendKeys("beyazkaya");
           WebElement loginBtn=driver.findElement(By.xpath("//input[@name='username']/parent::label/parent::div/parent::div/following-sibling::div/following-sibling::div/button"));
           loginBtn.click();
           System.out.println(loginBtn.isEnabled());
            SoftAssert soft=new SoftAssert();
            WebElement pageText=driver.findElement(By.xpath("//p[text()='Sorry, your password was incorrect. Please double-check your password.']"));
            String getText=pageText.getText();
            String text="Sorry, your password was incorrect. Please double-check your password.";
            soft.assertEquals(getText,text);
        }

}
